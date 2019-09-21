import java.util.*;
import java.lang.*;
import java.io.*;

class GraphGenerator {
	
	Random rnd = new Random();
	
	public void simpleGraph(int vertex, double density) {
		PrintWriter printer = new PrintWriter(System.out);
		
		int edge = (int) (density * vertex * (vertex - 1) / 2);
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
		
		printer.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		GraphGenerator gg = new GraphGenerator();
		int vertex = Integer.valueOf(args[0]);
		double destiny = Double.valueOf(args[1]);
		gg.simpleGraph(vertex, destiny);
	}
}
