import java.util.*;
import java.lang.*;
import java.io.*;

class GraphGenerator1 {
	
	Random rnd = new Random();
	
	public void simpleGraph(int vertex, int edge, int v) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + edge + " " + v + "\n");
		
		boolean graph[][] = new boolean[vertex][vertex];
		
		while (edge > 0) {
			int x = rnd.nextInt(vertex), y = rnd.nextInt(vertex), z = rnd.nextInt(500) + 1;
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
		GraphGenerator1 tg = new GraphGenerator1();
		int vertex = Integer.valueOf(args[0]);
		int edge = Integer.valueOf(args[1]);
		int v = Integer.valueOf(args[2]);
		tg.simpleGraph(vertex, edge, v);
	}
}
