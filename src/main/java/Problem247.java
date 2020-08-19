import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import utils.T;

public class Problem247 {
	
	public static class Graph implements Comparable<Graph> {
		double length;
		double x;
		double y;
		int xIndex;
		int yIndex;
		public Graph(double x, double y, int i, int j) {
			this.xIndex = i;
			this.yIndex = j;
			this.x = x;
			this.y = y;
			this.length = findLength(x, y, 0, 1);
		}
		
		public String toString() {
			return "("+x+","+y+")" + " "+length; 
		}
		
		public List<Graph> getChildren() {
			return Arrays.asList(new Graph(x, y+length, xIndex, yIndex+1), new Graph(x+length, y, xIndex+1, yIndex));
		}

		@Override
		public int compareTo(Graph arg0) {
			return Double.valueOf(arg0.length).compareTo(length);
		}
		
	}
	
	public static void main(String[] args) {
		
		T t = new T();

		Queue<Graph> queue = new PriorityQueue<Graph>();
		queue.add(new Graph(1,0, 0,0));
		int count = 0;
		int i = 1;
		for (; count != (6*5*4)/(3*2*1); i++) {
			Graph graph = queue.poll();
			if (graph.xIndex == 3 && graph.yIndex == 3) {
				count++;
				System.out.println(i + ": " + graph);
			}
			queue.addAll(graph.getChildren());
		}
		System.out.println("answer: " + (i-1) + " " + t);
	}
	
	private static double findLength(double offsetX, double offsetY, double minLength, double maxLength) {
		double mid = (minLength+maxLength)/2;
		if (maxLength - minLength < 1e-15)
			return mid;
		if (f(mid + offsetX)-offsetY < mid) {
			return findLength(offsetX, offsetY, minLength, mid);
		} else {
			return findLength(offsetX, offsetY, mid, maxLength);
		}
	}

	public static double f(double x) {
		return 1/x;
	}
}
