import java.util.*;
import java.lang.*;
import java.io.*;

class GraphGenerator {
	
	Random rnd = new Random();
	
	public void simpleGraph(int vertex, int edge, int query) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + edge + "\n");
		
		boolean graph[][] = new boolean[vertex][vertex];
		
		while (edge > 0) {
			int x = rnd.nextInt(vertex), y = rnd.nextInt(vertex);
			if ((x != y) && (graph[x][y] == false)) {
				printer.print((x + 1) + " " + (y + 1) + "\n");
				graph[x][y] = true;
				graph[y][x] = true;
				edge--;
			}
		}

		printer.print(query + "\n");
		for(int i = 0; i < query; i++) {
			int x = rnd.nextInt(vertex), y = rnd.nextInt(vertex);
			printer.print((x + 1) + " " + (y + 1) + "\n");
		}
		
		printer.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		GraphGenerator tg = new GraphGenerator();
		int vertex = Integer.valueOf(args[0]);
		int edge = Integer.valueOf(args[1]);
		int query = Integer.valueOf(args[2]);
		tg.simpleGraph(vertex, edge, query);
	}
}
