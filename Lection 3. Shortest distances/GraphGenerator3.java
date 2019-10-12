import java.util.*;
import java.lang.*;
import java.io.*;

class GraphGenerator3 {
	
	Random rnd = new Random();
	
	public void simpleGraph(int vertex, int edge) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + edge + " ");

		int x, y;
		do {
			x = rnd.nextInt(vertex);
			y = rnd.nextInt(vertex);
		} while (x == y);
		
		printer.print((x + 1) + " " + (y + 1) + "\n");

		boolean graph[][] = new boolean[vertex][vertex];
		
		if (edge > vertex) {
			edge = edge - vertex + 1;
			int[] tmp = new int[vertex];
			for(int i = 0; i < vertex; i++)
				tmp[i] = i;
			tmp[x] = 0;
			tmp[0] = x;
			tmp[y] = vertex - 1;
			tmp[vertex - 1] = y;
			for(int i = 0; i < 2 * vertex; i++) {
				x = rnd.nextInt(vertex - 2) + 1;
				y = rnd.nextInt(vertex - 2) + 1;
				int c = tmp[x];
				tmp[x] = tmp[y];
				tmp[y] = c;	
			}
			for(int i = 0; i < vertex - 1; i++) {
				int z = rnd.nextInt(1001) - 100;
				graph[tmp[i]][tmp[i + 1]] = true;
				graph[tmp[i]][tmp[i + 1]] = true;
				printer.print((tmp[i] + 1) + " " + (tmp[i + 1] + 1) + " " + z + "\n");
			}
		}

		while (edge > 0) {
			x = rnd.nextInt(vertex);
			y = rnd.nextInt(vertex);
			int z = rnd.nextInt(1001) - 100;
			if ((x != y) && (graph[x][y] == false)) {
				printer.print((x + 1) + " " + (y + 1) + " " + z + "\n");
				graph[x][y] = true;
				graph[y][x] = true;
				edge--;
			}
		}
		
		printer.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		GraphGenerator3 tg = new GraphGenerator3();
		int vertex = Integer.valueOf(args[0]);
		int edge = Integer.valueOf(args[1]);
		tg.simpleGraph(vertex, edge);
	}
}
