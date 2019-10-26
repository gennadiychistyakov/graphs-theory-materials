import java.util.*;
import java.lang.*;
import java.io.*;

class Solver3 {
	
	private int inf = 1000000000;

	public void solve() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int vertex = in.nextInt(), edge = in.nextInt(), v = in.nextInt(), u = in.nextInt(), tmp = 0;
		int[][] m = new int[3][edge];
		
		for(int i = 0; i < edge; i++)
			for(int j = 0; j < 3; j++)
				m[j][i] = in.nextInt();

		int[] d = new int[vertex + 1], p = new int[vertex + 1];

		Arrays.fill(d, inf);
		Arrays.fill(p, -1);
		d[v] = 0;
		p[v] = 0;

		for(int i = 1; i < 2 * vertex; i++) {
			for(int j = 0; j < edge; j++) {
				if((d[m[0][j]] != inf) && (d[m[1][j]] > d[m[0][j]] + m[2][j])) {
					d[m[1][j]] = d[m[0][j]] + m[2][j];
					p[m[1][j]] = m[0][j];
				}
			}
			if(i == vertex) 
				tmp = d[u];
		}

		if(d[u] == inf)
			out.print("-1");
		else
			if(tmp != d[u])
				out.print("-2");
			else {
				out.println(d[u]);
				tmp = 0;
				while(u != 0) {
					d[tmp++] = u;
					u = p[u];
				}
				out.println(tmp);
				for(int i = tmp - 1; i >= 0; i--)
					out.print(d[i] + " ");
			}


		out.flush();
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Solver3 s = new Solver3();
		s.solve();
	}
}
