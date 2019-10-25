import java.util.*;
import java.lang.*;
import java.io.*;

class Solver {

	private int inf = 1000000;

	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int vertex = in.nextInt(), edge = in.nextInt();
		int[][] m = new int[vertex][vertex];

		for(int i = 0; i < edge; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1, z = in.nextInt();
			m[x][y] = z;
			m[y][x] = z;
		}	

		int[][] res = new int[1 << vertex][vertex];
		for(int i = 0; i < (1 << vertex); i++)
			Arrays.fill(res[i], inf);
		for(int i = 0; i < vertex; i++)
			res[1 << i][i] = 0;

		for(int i = 1; i < 1 << vertex; i++)
			for(int j = 0; j < vertex; j++)
				for(int k = 0; k < vertex; k++)
					if(res[i][j] != inf)
						if((m[j][k] != 0) && ((i & (1 << k)) == 0))
							res[i | (1 << k)][k] = Math.min(res[i | (1 << k)][k], res[i][j] + m[j][k]);

		int ans = inf;
		for(int i = 0; i < vertex; i++)
			ans = Math.min(ans, res[(1 << vertex) - 1][i]);

		// for(int i = 0; i < 1 << vertex; i++)
		// 	for(int j = 0; j < vertex; j++)
		// 		out.print(Integer.toString(i, 2) + ", " + (j + 1) + ": " + res[i][j] + "\n");

		out.print(ans);
		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver s = new Solver();
		s.solve();
	}
}
