import java.util.*;
import java.lang.*;
import java.io.*;

class Solver2 {

	private int vertex;
	private boolean[][] m;
	private boolean[] used;

	private boolean isReachability(int x, int y) {
		used = new boolean[vertex];
		dfs(x);
		return used[y];
	}

	private void dfs(int v) {
		used[v] = true;
		for(int i = 0; i < vertex; i++)
			if(!used[i] && m[v][i])
				dfs(i);
	}
	
	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		vertex = in.nextInt();
		int edge = in.nextInt();
		m = new boolean[vertex][vertex];

		for(int i = 0; i < edge; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1;
			m[x][y] = true;
			m[y][x] = true;
		}
		
		int query = in.nextInt();
		int ans = 0;

		for(int i = 0; i < query; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1;
			if(isReachability(x, y))
				ans++;
		}

		out.print(ans + "\n");
		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver2 s = new Solver2();
		s.solve();
	}
}
