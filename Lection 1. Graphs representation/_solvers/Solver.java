import java.util.*;
import java.lang.*;
import java.io.*;

class Solver {
	
	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int vertex = in.nextInt(), edge = in.nextInt(), max = 0;
		int[] d = new int[vertex];

		for(int i = 0; i < edge; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1;
			d[x]++;
			if(d[x] > max)
				max = d[x];
			d[y]++;
			if(d[y] > max)
				max = d[y];
		}
		
		out.print(max);
		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver s = new Solver();
		s.solve();
	}
}
