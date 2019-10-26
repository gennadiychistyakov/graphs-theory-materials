import java.util.*;
import java.lang.*;
import java.io.*;

class Solver2 {
	
	private int inf = 1000000;

	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int vertex = in.nextInt(), edge = in.nextInt();
		int[][] m = new int[vertex][vertex];
		
		for(int i = 0; i < vertex; i++)
			for(int j = 0; j < vertex; j++)
				m[i][j] = inf;

		for(int i = 0; i < edge; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1, z = in.nextInt();
			m[x][y] = z;
			m[y][x] = z;
		}

		for(int i = 0; i < vertex; i++)
			m[i][i] = 0;
		
		for(int k = 0; k < vertex; k++)
			for(int i = 0; i < vertex; i++)
				for(int j = 0; j < vertex; j++)
					if((m[i][k] + m[k][j] < inf) && (m[i][k] + m[k][j] < m[i][j]))
						m[i][j] = m[i][k] + m[k][j];

		
		int query = in.nextInt();

		for(int i = 0; i < query; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1;
			out.print(m[x][y] == inf ? "-1 " : m[x][y] + " ");
		}

		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver2 s = new Solver2();
		s.solve();
	}
}
