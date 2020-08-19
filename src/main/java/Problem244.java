import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import utils.T;

public class Problem244 {
	
	public static void main(String[] args) {
		T t = new T();
		Node x = bestFirstSearch();
		System.out.println(x.sequence);
		System.out.println(checksum(x.sequence) + " " + t);
	}
	
	private static long checksum(String string) {
		long checksum = 0;
		for (int c : string.toCharArray()) {
			checksum = (checksum*243+c)%100000007;
		}
		return checksum;
	}

	public static class Node implements Comparable<Node> {
		static char[][] GOAL;
		private char[][] state;
		private Node parent;
		private List<Node> children = new ArrayList<Node>();

		private int h;
		private String sequence;
		
		public Node(char[][] state, Node parent, String sequence) {
			this.state = state;
			this.parent = parent;
			this.sequence = sequence;

			this.h = h();
		}
		
		public List<Node> getChildren() {
			return children;
		}

		private int h() {
			int diff = 0;
			for (int i = 0; i < state.length; i++) {
				for (int j = 0; j < state.length; j++) {
					if (state[i][j] != GOAL[i][j])
						diff++;
				}
			}
			return diff;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		private int f() {
			return g() + h;
		}
		
		public String toString() {
			return new String(state[0])+'\n'
					+ new String(state[1])+'\n' 
					+ new String(state[2])+'\n' 
					+ new String(state[3])+'\n';
		}
		
		public Node getParent() {
			return parent;
		}

		public int g() {
			if (parent == null)
				return 0;
			return parent.g() + 1;
		}

		public List<Node> getSuccessors() {
			List<Node> valids = new ArrayList<Node>();
			for (int i = 0; i < state.length; i++) {
				for (int j = 0; j < state.length; j++) {
					if (state[i][j] == ' ') {
						if (i != 0) {
							char[][] newState = {state[0].clone(),state[1].clone(),state[2].clone(),state[3].clone()};
							newState[i-1][j] = state[i][j];
							newState[i][j] = state[i-1][j];
							valids.add(new Node(newState, this,sequence+"D"));
						}
						if (i+1 != state.length) {
							char[][] newState = {state[0].clone(),state[1].clone(),state[2].clone(),state[3].clone()};
							newState[i+1][j] = state[i][j];
							newState[i][j] = state[i+1][j];
							valids.add(new Node(newState, this, sequence+"U"));
						}
						if (j != 0) {
							char[][] newState = {state[0].clone(),state[1].clone(),state[2].clone(),state[3].clone()};
							newState[i][j-1] = state[i][j];
							newState[i][j] = state[i][j-1];
							valids.add(new Node(newState, this, sequence+"R"));
						}
						if (j+1 != state.length) {
							char[][] newState = {state[0].clone(),state[1].clone(),state[2].clone(),state[3].clone()};
							newState[i][j+1] = state[i][j];
							newState[i][j] = state[i][j+1];
							valids.add(new Node(newState, this, sequence+"L"));
						}
					}
				}
			}
			return valids;
		}

		public int hashCode() {
			return toString().hashCode();
		}

		public boolean equals(Object o) {
			Node other = (Node) o;
			return toString().equals(other.toString());
		}

		public boolean isSolution() {
			return h == 0;
		}

		public void addChild(Node child) {
			children.add(child);
		}

		public int compareTo(Node o1) {
			return f() - o1.f();
		}
	}
	
	private static Node bestFirstSearch() {
		char[][] initialState = {
				{' ','r','b','b'},
				{'r','r','b','b'},
				{'r','r','b','b'},
				{'r','r','b','b'}
			};
		Node.GOAL = new char[][] {
				{' ','b','r','b'},
				{'b','r','b','r'},
				{'r','b','r','b'},
				{'b','r','b','r'}
			};

		//step 1
		Map<String, Node> closed = new HashMap<String,Node>();
		Queue<Node> open = new PriorityQueue<Node>();
		Map<String, Node> openMap = new HashMap<String,Node>();
		
		Node n0 = new Node(initialState, null,"");
		open.add(n0);
		openMap.put(n0.toString(), n0);

		int i = 0;
		while(!open.isEmpty()) {
			if (i++ % 1000 == 0)
				System.out.println(i + " " + open.size() + " " + closed.size());
			
			Node x = open.poll();
			openMap.remove(x.toString());
			
			closed.put(x.toString(), x);
			
			if (x.isSolution()) {
				System.out.println("fuckyeah");
				System.out.println(x);
				Node from = x;
				int count = 0;
				while((from = from.parent) != null) {
					System.out.println(from);
					count++;
				}
				System.out.println(count);
				return x;
			}
			
			List<Node> successors = x.getSuccessors();
			
			for (Node s : successors) {
				if(closed.containsKey(s.toString())) {
					s = closed.get(s.toString());
				}
				
				if (openMap.containsKey(s.toString())) {
					s = openMap.get(s.toString());
				}
			
				if (!openMap.containsKey(s.toString()) && !closed.containsKey(s.toString())) {
					open.add(s);
					openMap.put(s.toString(), s);
				} else if (x.g()+1 < s.g()) {
					open.remove(s);
					s.setParent(x);
					open.add(s);
					if (closed.containsKey(s.toString())) {
						propagatePathImprovements(s, open);
					}
				}
			}
		}
		throw new RuntimeException("No solution was found");
	}

	private static void propagatePathImprovements(Node p, Queue<Node> open) {
		for (Node c : p.getChildren()) {
			if (p.g()+1 < c.g()) {
				open.remove(c);
				c.setParent(p);
				open.add(c);
				propagatePathImprovements(c, open);
			}
		}
		
	}

}
