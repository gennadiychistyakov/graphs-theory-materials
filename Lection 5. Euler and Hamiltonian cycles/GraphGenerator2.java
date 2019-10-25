import java.util.*;
import java.lang.*;
import java.io.*;

class GraphGenerator2 {
	
	Random rnd = new Random();
	
	public void simpleTask(int vertex, int edge) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + edge + "\n");

		boolean graph[][] = new boolean[vertex][vertex];
		
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
				int z = rnd.nextInt(120) + 1;
				graph[tmp[i]][tmp[i + 1]] = true;
				graph[tmp[i + 1]][tmp[i]] = true;
				printer.print((tmp[i] + 1) + " " + (tmp[i + 1] + 1) + " " + z + "\n");
			}
		}

		while (edge > 0) {
			int x = rnd.nextInt(vertex);
			int y = rnd.nextInt(vertex);
			int z = rnd.nextInt(80) + 1;
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
		GraphGenerator2 tg = new GraphGenerator2();
		int vertex = Integer.valueOf(args[0]);
		int edge = Integer.valueOf(args[1]);
		tg.simpleTask(vertex, edge);
	}
}
