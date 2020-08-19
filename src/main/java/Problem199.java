import java.util.ArrayList;
import java.util.List;

import utils.T;

public class Problem199 {
	
	private static class Connection {
		private int a, b, c;
		public Connection(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	private static final double K = 2.15470053837925;
	private static final int ITERATIONS = 10;
	
	public static void main(String[] args) {
		/**
		 * Det blir 3 nye hull per hull per iterasjon.
		 */
		T t = new T(); 
		double r = 1/K;
		System.out.println(r);
		double[] k = new double[100000];
		k[0] = 3*K-2*Math.sqrt(3*K*K);
		k[1] = K;
		k[2] = K;
		k[3] = K;
		
		
		k[4] = getK(k[1], k[2], k[3]);
		k[5] = getK(k[0], k[2], k[3]);
		
		int count = 5;
		
		List<Connection> connections = new ArrayList<Connection>();
		connections.add(new Connection(0,2,5));
		connections.add(new Connection(0,3,5));
		connections.add(new Connection(2,3,4));
		connections.add(new Connection(2,3,5));
		
		
		for (int i = 2; i <= ITERATIONS; i++) {
			List<Connection> newConnections = new ArrayList<Connection>();

			for (Connection c : connections) {
				k[++count] = getK(k[c.a], k[c.b], k[c.c]);
				newConnections.add(new Connection(count, c.a, c.b));
				newConnections.add(new Connection(count, c.a, c.c));
				newConnections.add(new Connection(count, c.b, c.c));
			}
			
			connections = newConnections;
		}
		
		
		
		
		double area = area(k[1])+area(k[2])+area(k[3])+area(k[4]);
		for (int i = 5; k[i] != 0; i++) {
			area += 3*area(k[i]);
		}
		System.out.println("Area covered: "+area);
		System.out.println("Total area: "+Math.PI);
		System.out.println((""+(Math.PI-area)/Math.PI).substring(0,11) + " " + t);
		
	}

	private static double area(double k) {
		double r = 1.0/k;
		return Math.PI*r*r;
	}

	private static double getK(double k1, double k2, double k3) {
		return k1+k2+k3+2*Math.sqrt(k1*k2+k2*k3+k3*k1);
	}
}
