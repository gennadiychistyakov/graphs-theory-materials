import java.util.*;
import java.lang.*;
import java.io.*;

class GraphGenerator {
	
	Random rnd = new Random();
	
	private class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void evenDegreeGraph(int vertex, int edge) {
		PrintWriter printer = new PrintWriter(System.out);

		boolean graph[][] = new boolean[vertex][vertex];
		int degree[] = new int[vertex];
		ArrayList<Pair> edges = new ArrayList<Pair>();
		
		if (edge > vertex) {
			edge = edge - vertex + 1;
			int[] tmp = new int[vertex];
			for(int i = 0; i < vertex; i++)
				tmp[i] = i;
			for(int i = 0; i < 2 * vertex; i++) {
				int x = rnd.nextInt(vertex);
				int y = rnd.nextInt(vertex);
				int c = tmp[x];
				tmp[x] = tmp[y];
				tmp[y] = c;	
			}
			for(int i = 0; i < vertex - 1; i++) {
				graph[tmp[i]][tmp[i + 1]] = true;
				graph[tmp[i + 1]][tmp[i]] = true;
				degree[tmp[i]]++;
				degree[tmp[i + 1]]++;
				edges.add(new Pair(tmp[i] + 1, tmp[i + 1] + 1));
			}
		}

		while (edge > 0) {
			int x = rnd.nextInt(vertex);
			int y = rnd.nextInt(vertex);
			if ((x != y) && (graph[x][y] == false)) {
				graph[x][y] = true;
				graph[y][x] = true;
				degree[x]++;
				degree[y]++;
				edges.add(new Pair(x + 1, y + 1));
				edge--;
			}
		}

		boolean flag = true;
		while (flag) {
			int x = -1, y = -1;
			flag = false;
			for(int i = 0; i < vertex; i++)
				if (degree[i] % 2 != 0) {
					x = i;
					break;
				}
			if (x != -1) {
				flag = true;
				for(int i = 0; i < vertex; i++)
					if ((degree[i] % 2 != 0) && !graph[x][i] && (x != i)) {
						y = i;
						break;
					}	
				if (y == -1)
					do {
						y = rnd.nextInt(vertex);
					} while ((y == x) || graph[x][y]);
				graph[x][y] = true;
				graph[y][x] = true;
				degree[x]++;
				degree[y]++;
				edges.add(new Pair(x + 1, y + 1));
			}
		}

		printer.print(vertex + " " + edges.size() + "\n");
		for(Pair p: edges)
			printer.print(p.x + " " + p.y + "\n");
		
		printer.flush();
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		GraphGenerator tg = new GraphGenerator();
		int vertex = Integer.valueOf(args[0]);
		int edge = Integer.valueOf(args[1]);
		tg.evenDegreeGraph(vertex, edge);
	}
}
