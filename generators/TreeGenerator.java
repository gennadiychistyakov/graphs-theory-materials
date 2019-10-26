import java.util.*;
import java.lang.*;
import java.io.*;

class TreeGenerator {
	
	Random rnd = new Random();

	private ArrayList<Integer>[] tree;
	private boolean[] flag;
	
	private boolean dfs(int v, int p) {
		flag[v] = true;
		for(int u: tree[v]) {
			if(flag[u] && (u != p))
				return false;
			if(!flag[u])
				dfs(u, v);
		}
		return true;
	}

	public void treeGraph(int vertex, int root, int query) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + root + "\n");
		
		tree = new ArrayList[vertex];
		flag = new boolean[vertex];

		for(int i = 0; i < vertex; i++)
			tree[i] = new ArrayList<Integer>();

		int cnt = vertex - 1;
		while (cnt > 0) {
			int x = rnd.nextInt(vertex), y = rnd.nextInt(vertex);
			if((x != y) && !tree[x].contains(y)) {
				tree[x].add(y);
				tree[y].add(x);
				Arrays.fill(flag, false);
				if(dfs(x, -1))
					cnt--;
				else {
					tree[x].remove(tree[x].size() - 1);
					tree[y].remove(tree[y].size() - 1);
				}
			}
		}

		for(int i = 0; i < vertex; i++) {
			printer.print(tree[i].size() + " ");
			for(int x: tree[i])
				printer.print((x + 1) + " ");
			printer.print("\n");
		}

		printer.print(query + "\n");
		while(query > 0) {
			int x = rnd.nextInt(vertex), y = rnd.nextInt(vertex);
			if(x != y) {
				query--;
				printer.print((x + 1) + " " + (y + 1) + "\n");
			}
		}

		printer.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		TreeGenerator tg = new TreeGenerator();
		int vertex = Integer.valueOf(args[0]);
		int root = Integer.valueOf(args[1]);
		int query = Integer.valueOf(args[2]);
		tg.treeGraph(vertex, root, query);
	}
}
