import java.util.*;
import java.lang.*;
import java.io.*;

class GraphsGenerator {
	
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

	public void simpleGraphWithSizeAndQueries(int vertex, int edge, int query, boolean weights) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + edge + "\n");
		
		boolean graph[][] = new boolean[vertex][vertex];
		
		while (edge > 0) {
			int x = rnd.nextInt(vertex), y = rnd.nextInt(vertex);
			if ((x != y) && (graph[x][y] == false)) {
				printer.print((x + 1) + " " + (y + 1));
				if (weights)
					printer.print(" " + (rnd.nextInt(500) + 1));
				printer.print("\n");
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

	public void simpleGraphWithReachability(int vertex, int edge, int v, int k) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + edge + " " + v + " " + k + "\n");
		
		boolean graph[][] = new boolean[vertex][vertex];
		
		while (edge > 0) {
			int x = rnd.nextInt(vertex), y = rnd.nextInt(vertex);
			if ((x != y) && (graph[x][y] == false)) {
				printer.print((x + 1) + " " + (y + 1) + "\n");
				graph[x][y] = true;
				edge--;
			}
		}

		printer.flush();
	}

	public void simpleGraphWithVertex(int vertex, int edge, int v) {
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

	public void simpleGraphWithPairAndNWeights(int vertex, int edge) {
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

	public void simpleGraphWithVWeights(int vertex, double density) {
		PrintWriter printer = new PrintWriter(System.out);
		
		int edge = (int) (density * vertex * (vertex - 1) / 2);
		printer.print(vertex + " " + edge + "\n");

		for(int i = 0; i < vertex; i++)
			printer.print((rnd.nextInt(100) + 1) + " ");
		printer.print("\n");
		
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

	public void spanningTreeGraph(int vertex, int edge) {
		PrintWriter printer = new PrintWriter(System.out);
		
		printer.print(vertex + " " + edge + "\n");

		boolean graph[][] = new boolean[vertex][vertex];
		
		if (edge > vertex) {
			edge = edge - vertex + 1;
			int[] tmp = new int[vertex];
			for(int i = 0; i < vertex; i++)
				tmp[i] = i;
			for(int i = 0; i < 2 * vertex; i++) {
				int x = rnd.nextInt(vertex - 2) + 1;
				int y = rnd.nextInt(vertex - 2) + 1;
				int c = tmp[x];
				tmp[x] = tmp[y];
				tmp[y] = c;	
			}
			for(int i = 0; i < vertex - 1; i++) {
				int z = rnd.nextInt(299) + 1;
				graph[tmp[i]][tmp[i + 1]] = true;
				graph[tmp[i]][tmp[i + 1]] = true;
				printer.print((tmp[i] + 1) + " " + (tmp[i + 1] + 1) + " " + z + "\n");
			}
		}

		while (edge > 0) {
			int x = rnd.nextInt(vertex);
			int y = rnd.nextInt(vertex);
			int z = rnd.nextInt(149) + 1;
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
		GraphsGenerator gg = new GraphsGenerator();
		String program = args[0];
		switch (program.toLowerCase()) {
			case "simplegraph": {
				int vertex = Integer.valueOf(args[1]);
				double destiny = Double.valueOf(args[2]);
				gg.simpleGraph(vertex, destiny);
				break;
			}
			case "simplegraphwsq": {
				int vertex = Integer.valueOf(args[1]);
				int edge = Integer.valueOf(args[2]);
				int query = Integer.valueOf(args[3]);
				gg.simpleGraphWithSizeAndQueries(vertex, edge, query, false);
				break;
			}
			case "simplegraphwvw": {
				int vertex = Integer.valueOf(args[1]);
				double destiny = Double.valueOf(args[2]);
				gg.simpleGraphWithVWeights(vertex, destiny);
				break;
			}
			case "simplegraphreach": {
				int vertex = Integer.valueOf(args[1]);
				int edge = Integer.valueOf(args[2]);
				int v = Integer.valueOf(args[3]);
				int k = Integer.valueOf(args[4]);
				gg.simpleGraphWithReachability(vertex, edge, v, k);
				break;
			}
			case "simplegraphwv": {
				int vertex = Integer.valueOf(args[1]);
				int edge = Integer.valueOf(args[2]);
				int v = Integer.valueOf(args[3]);
				gg.simpleGraphWithVertex(vertex, edge, v);
				break;
			}
			case "simplegraphwsqw": {
				int vertex = Integer.valueOf(args[1]);
				int edge = Integer.valueOf(args[2]);
				int query = Integer.valueOf(args[3]);
				gg.simpleGraphWithSizeAndQueries(vertex, edge, query, true);
				break;
			}
			case "simplegraphwpnw": {
				int vertex = Integer.valueOf(args[1]);
				int edge = Integer.valueOf(args[2]);
				gg.simpleGraphWithPairAndNWeights(vertex, edge);
				break;
			}
			case "spanningtree": {
				int vertex = Integer.valueOf(args[1]);
				int edge = Integer.valueOf(args[2]);
				gg.spanningTreeGraph(vertex, edge);
				break;
			}
		}
	}
}
