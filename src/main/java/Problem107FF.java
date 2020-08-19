import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class WeightedGraph {
	private final int SIZE = 40;
	
	private int[][] naboer = new int[SIZE][SIZE];
	
	public WeightedGraph() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
		for (int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(),",");
			for (int j = 0; j < SIZE; j++) {
				try {
					naboer[i][j] = Integer.parseInt(st.nextToken());
				} catch (Exception e) {
					naboer[i][j] = Integer.MAX_VALUE;
				} 
			}
		}
//		System.out.println(naboer[0][0]);
	}
	
	public int size() {
		return SIZE;
	}
	
	public void print() {
		int sum = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = i; j < SIZE; j++) {
				if (naboer[i][j] != Integer.MAX_VALUE)
					sum+=naboer[i][j];
			}
		}
		System.out.println(sum-2153);
	}
	
	public int[] neighbors(int next) {
		int teller = 0;
		for (int i = 0; i < SIZE; i++) {
			if (naboer[next][i] != Integer.MAX_VALUE)
				teller++;
		}
		int[] a = new int[teller];
		int j = 0;
		for (int i = 0; i < SIZE; i++) {
			if (naboer[next][i] != Integer.MAX_VALUE) {
				a[j] = i;
				j++;
			}
		}
//		int[]a = new int[SIZE];
//		for (int i = 0; i < a.length; i++) {
//			a[i] = i;
//		}
		return a;
	}
	
	public int getWeight(int next, int v) {
		return naboer[v][next];
	}
}

public class Problem107FF {
	
	
	public static void main(String[] args) throws IOException {
		WeightedGraph a = new WeightedGraph();
		a.print();
		int[] lol = prim(a,0);
		int sum = 0;
		
//		for (int i = 1; i < lol.length; i++) {
//			
//			System.out.println((char)(i+'A') + "->" + (char)('A'+lol[i]) + ": " + a.getWeight(i,lol[i]));
//			sum+=a.getWeight(i,lol[i]);
//		}
//		System.out.println(sum);
	}

	// Prim-Jarnk's algorithm to find MST rooted at s
	public static int[] prim(WeightedGraph G, int s) {
		final int[] dist = new int[G.size()]; // shortest known distance to
												// MST
		final int[] pred = new int[G.size()]; // preceeding node in tree
		final boolean[] visited = new boolean[G.size()]; // all false
															// initially

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;
		
		int sum = 0;

		for (int i = 0; i < dist.length; i++) {
			final int next = minVertex(dist, visited);
			visited[next] = true;
			sum+=dist[next];

			// The edge from pred[next] to next is in the MST (if next!=s)

			final int[] n = G.neighbors(next);
			for (int j = 0; j < n.length; j++) {
				final int v = n[j];
				final int d = G.getWeight(next, v);
				if (dist[v] > d) {
					dist[v] = d;
					pred[v] = next;
				}
			}
		}
		System.out.println(sum);
		return pred; // (ignore pred[s]==0!)
	}

	private static int minVertex(int[] dist, boolean[] v) {
		int x = Integer.MAX_VALUE;
		int y = -1; // graph not connected, or no unvisited vertices
		for (int i = 0; i < dist.length; i++) {
			if (!v[i] && dist[i] < x) {
				y = i;
				x = dist[i];
			}
		}
		return y;
	}
}
