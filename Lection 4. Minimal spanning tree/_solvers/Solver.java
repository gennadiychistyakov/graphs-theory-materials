import java.util.*;
import java.lang.*;
import java.io.*;

class Solver {
	
	private int inf = 1000000000;

	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int vertex = in.nextInt(), edge = in.nextInt();
		int[][] m = new int[vertex][vertex];
		
		for(int i = 0; i < vertex; i++)
			for(int j = 0; j < vertex; j++)
				m[i][j] = inf;

		int[] p = new int[vertex];
		boolean[] used = new boolean[vertex];
		Arrays.fill(p, inf);
		Arrays.fill(used, false);
		p[0] = 0;

		for(int i = 0; i < edge; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1, z = in.nextInt();
			m[x][y] = z;
			m[y][x] = z;
		}	

		int ans = 0;

		for(int i = 0; i < vertex; i++) {
			int v = -1;
			for(int j = 0; j < vertex; j++)
				if(!used[j] && ((v == -1) || p[v] > p[j]))
					v = j;
			used[v] = true;
			ans += p[v];
			for(int j = 0; j < vertex; j++)
				if(p[j] > m[v][j])
					p[j] = m[v][j];
		} 

		out.print(ans);
		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver s = new Solver();
		s.solve();
	}
}
