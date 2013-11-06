package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.T;

public class Problem189Fail {
	
	private static class Tree {
		int[] right;
		int[] left;
		int[] under;
		
		int size;
		
		private Tree(int size) {
			this.size = size;
			this.right = new int[size];
			this.left = new int[size];
			this.under = new int[size];
		}
		
		public Tree(int root, int middle, int left, int right) {
			this(2);
			this.left [0] = this.right[0] = root;
			this.under[0] = this.left [1] = left;
			this.under[1] = this.right[1] = right;
		}
		
		public Tree(Tree root, Tree middle, Tree left, Tree right) {
			this(4);
			for (int i = 0; i < 2; i++) {
				this.left[i] = root.left[i];
				this.left[2+i] = left.left[i];
				
				this.right[i] = root.right[i];
				this.right[2+i] = right.right[i];
				
				this.under[i] = left.under[i];
				this.under[2+i] = right.under[i];
			}
			if (this.under[0] != this.left[3] || this.right[3] != this.under[3] || this.left[0] != this.right[0])
				throw new RuntimeException("Pelle");
		}
		
		public int hashCode() {
			return toString().hashCode();
		}
		
		public boolean equals(Object o) {
			return toString().equals(o.toString());
		}
		
		public String toString() {
			if (size == 2) 
				return " " + right[0] + "\n"+under[0]+" "+under[1];
			else if (size == 4)
				return  "   "+this.left[0] + "\n" +
						"  "+this.left[1] + " " + this.right[1] + "\n" +
						" "+this.left[2] + "   " + this.right[2] + "\n" + 
						this.under[0] + " " + this.under[1] + " " + this.under[2] + " " +this.under[3] + " ";
			throw new RuntimeException("De skal enten v¾re 2 eller 4 din dass");
		}
		
		public boolean fitsUnder(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (tree.under[size-1-i] == under[i])
					return false;
			}
			return true; 
		}
		
		public boolean fitsTreeToTheLeft(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (tree.right[i] == left[i])
					return false;
			}
			return true; 
		}
		
		public boolean fitsTreeToTheRight(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (tree.left[i] == right[i])
					return false;
			}
			return true; 
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		List<Tree> trees = new ArrayList<Tree>();
		for (int root = 0; root < 3; root++) {
			for (int middle = 0; middle < 3; middle++) {
				if (root == middle)
					continue;
				for (int left = 0; left < 3; left++) {
					if (left == middle)
						continue;
					for (int right = 0; right < 3; right++) {
						if (right == middle)
							continue;
						trees.add(new Tree(root, middle, left, right));
					}
				}
			}
		}
		System.out.println(trees.size());
		
		Map<Tree, Long> map2 = new HashMap<Tree, Long>();
		for (Tree tree : trees) {
			map2.put(tree, (map2.containsKey(tree) ? map2.get(tree) + 1 : 1));
		}
		
		for (Tree tt : map2.keySet()) {
			System.out.println(tt + " ("+map2.get(tt)+")\n");
		}
		
		Map<Tree, Long> map4 = new HashMap<Tree, Long>();
		for (Tree root : map2.keySet()) {
			for (Tree middle : map2.keySet()) {
				if (middle.fitsUnder(root)) {
					for (Tree left : map2.keySet()) {
						if (middle.fitsTreeToTheRight(left)) {
							for (Tree right : map2.keySet()) {
								if (middle.fitsTreeToTheLeft(right)) {
									Tree tree = new Tree(root, middle, left, right);
									map4.put(tree, (map4.containsKey(tree) ? map4.get(tree):0)+map2.get(root)*map2.get(middle)*map2.get(left)*map2.get(right));
								}
							}
						}
					}
				}
			}
		}
		
		long max = 0;
		long sum = 0;
		for (Tree tt : map4.keySet()) {
			sum += map4.get(tt);
			if (map4.get(tt) >= max) {
				max = map4.get(tt);
				System.out.println(tt+ " ("+map4.get(tt)+")\n");
			}
		}
		System.out.println(sum  + " " + map4.size() + " " + t);
//		
//		
//		Map<MiddleTree, Long> middleMap = new HashMap<MiddleTree, Long>();
//		long count = 0;
//		for (Tree root : map4.keySet()) {
//			if (++count % 100 == 0) {
//				System.out.println(count + " / "+ map4.size());
//			}
//			for (Tree middle : map4.keySet()) {
//				if (root.fitsUnder(middle)) {
//					MiddleTree middleTree = new MiddleTree(root, middle);
//					middleMap.put(middleTree, (middleMap.containsKey(middleTree) ? middleMap.get(middleTree) : 0) + map4.get(middle)*map4.get(root));
//				}
//			}
//		}
//		
//		long SUM = 0;
//		int i = 0;
//		for (MiddleTree middle : middleMap.keySet()) {
//			if (++i % 100 == 0)
//				System.out.println(SUM);
//				
//			long leftFits = 0;
//			long rightFits = 0;
//			for (Tree tree : map4.keySet()) {
//				if (middle.fitsTreeToTheLeft(tree)) {
//					leftFits += map4.get(tree);
//				}
//				
//				if (middle.fitsTreeToTheRight(tree)) {
//					rightFits += map4.get(tree);
//				}
//			}
//			
//			if (rightFits == 0 || leftFits == 0) {
//				System.out.println("Fuck dawg not cool");
//				System.exit(0);
//			}
//			
//			SUM += middleMap.get(middle)*leftFits*rightFits;
//		}
//		
//		System.out.println(count + " " + t);
//		System.out.println("31968 3969");
//		System.out.println(SUM);
	}
	
	private static class MiddleTree {
		int[] right;
		int[] left;
		
		int size;
		
		private MiddleTree(int size) {
			this.size = size;
			this.right = new int[size];
			this.left = new int[size];
		}
		
		public MiddleTree(Tree root, Tree middle) {
			this(4);
			
			for (int i = 0; i < size; i++) {
				this.right[i] = middle.left[size-1-i];
				this.left[i] = middle.right[size-1-i];
			}
		}
		
		public int hashCode() {
			return toString().hashCode();
		}
		
		public boolean equals(Object o) {
			return toString().equals(o.toString());
		}
		
		public String toString() {
			return     this.left[0] + "     " + this.right[0]+ "\n" +
					" "+this.left[1] + "   " + this.right[1] + "\n" + 
					"  "+this.left[2] + " " + this.right[2] + "\n" + 
					"   "+this.right[3]; 
		}
		
		public boolean fitsTreeToTheLeft(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (tree.right[i] == left[i])
					return false;
			}
			return true; 
		}
		
		public boolean fitsTreeToTheRight(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (tree.left[i] == right[i])
					return false;
			}
			return true; 
		}
	}
}
