import java.util.*;
import java.lang.*;
import java.io.*;

class Solver {
	
	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int vertex = in.nextInt(), edge = in.nextInt(), v = in.nextInt() - 1, z = in.nextInt();
		int[][][] m = new int[10][vertex][vertex];

		for(int i = 0; i < edge; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1;
			m[0][x][y] = 1;
		}
		
		for(int i = 1; i < 10; i++)
			for(int j = 0; j < vertex; j++)
				for(int k = 0; k < vertex; k++)
					for(int l = 0; l < vertex; l++)
						m[i][j][k] = m[i][j][k] | (m[i - 1][i][l] & m[i - 1][l][j]);

		int[][] res = new int[vertex][vertex];

		for(int i = 0; i < vertex; i++)
			res[i][i] = 1;

		for(int i = 0; i < 10; i++)
			if((z & (2 << i)) != 0) {
				int[][] tmp = new int[vertex][vertex];
				for(int j = 0; j < vertex; j++)
					for(int k = 0; k < vertex; k++)
						for(int l = 0; l < vertex; l++)
							tmp[j][k] = tmp[j][k] | (res[j][l] & m[i][k][l]);
				res = tmp;
			}

		int tmp = 0;
		for(int i = 0; i < vertex; i++)
			tmp += res[v][i];

		out.print(tmp);
		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver s = new Solver();
		s.solve();
	}
}
