import java.util.*;
import java.lang.*;
import java.io.*;

class Solver {
	
	private ArrayList<Integer>[] tree;
	private int[][] parents;
	private int time = 0, upper;
	private int[] timeIn, timeOut;

	private void dfs(int v, int p) {
		timeIn[v] = time++;

		parents[v][0] = p;
		for(int i = 1; i < upper; i++)
			parents[v][i] = parents[parents[v][i - 1]][i - 1];

		for(int u: tree[v])
			if(u != p)
				dfs(u, v);

		timeOut[v] = time++;
	}

	private boolean lcaPrime(int v, int u) {
		if((timeIn[v] <= timeIn[u]) && (timeOut[v] >= timeIn[u]))
			return true;
		return false;
	}

	private int lca(int v, int u) {
		if(lcaPrime(v, u))
			return v;
		if(lcaPrime(u, v))
			return u;
		for(int i = upper - 1; i >= 0; i--)
			if(!lcaPrime(parents[v][i], u))
				v = parents[v][i];
		return parents[v][0];
	}

	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int vertex = in.nextInt(), root = in.nextInt() - 1;
		upper = (int)(Math.ceil(Math.log(vertex) / Math.log(2)) + 1e-8);
		timeIn = new int[vertex];
		timeOut = new int[vertex];
		parents = new int[vertex][upper];
		for(int i = 0; i < vertex; i++)
			for(int j = 0; j < upper; j++)
				parents[i][j] = root;
		tree = new ArrayList[vertex];
		for(int i = 0; i < vertex; i++)
			tree[i] = new ArrayList<Integer>();

		for(int i = 0; i < vertex; i++) {
			int tmp = in.nextInt();
			for(int j = 0; j < tmp; j++) {
				int v = in.nextInt() - 1;
				tree[i].add(v);
			}
		}
	
		dfs(root, root);

		int query = in.nextInt();
		ArrayList<Integer> lcaList = new ArrayList<Integer>();
		int ans = 0;
		for(int i = 0; i < query; i++) {
			int u = in.nextInt() - 1, v = in.nextInt() - 1;
			int tmp = lca(u, v) + 1;
			lcaList.add(tmp);
			ans += tmp;
		}

		out.print(ans + "\n");
		out.print(query + "\n");
		for(int x: lcaList)
			out.print(x + " ");

		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver s = new Solver();
		s.solve();
	}
}
