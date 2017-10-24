
public class BSTree {
	
	private class Node {
		public Comparable data;
		public Node left;
		public Node right;
		
		public Node(Comparable data) {
			this.data = data;
		}
	}
	
	private Node root;
	
	public void insert(Comparable node) {
		root = insert(root, node);
	}
	
	public boolean find(Comparable node) {
		return find(root, node);
	}
	
	public void delete(Comparable node) {
		root = delete(root, node);
	}
	
	private Node insert(Node tree, Comparable node) {
		if (tree == null) {
			return new Node(node);
		}
		if (node.compareTo(tree.data) < 0) {
			tree.left = insert(tree.left, node);
			return tree;
		} else {
			tree.right = insert(tree.right, node);
			return tree;
		}
	}
	
	private boolean find(Node tree, Comparable node) {
		if (tree == null)
			return false;
		if (node.compareTo(tree.data) == 0)
			return true;
		if (node.compareTo(tree.data) < 0)
			return find(tree.left, node);
		else
			return find(tree.right, node);
	}
	
	private Node delete(Node tree, Comparable node) {
		if (tree == null)
			return null;
		if (tree.data.compareTo(node) == 0) { 
			if (tree.left == null) 
				return tree.right;
			else if (tree.right == null) 
				return tree.left;
			else { 
				if (tree.right.left == null) { 
					tree.data = tree.right.data;
					tree.right = tree.right.right;
					return tree;
				} else {
					tree.data = removeSmallest(tree.right);
					return tree;
				}
			}
		} else if (node.compareTo(tree.data) < 0) { // find and delete in left subtree
			tree.left = delete(tree.left, node);
			return tree;
		} else {
			tree.right = delete(tree.right, node); // find and delete in right subtree
			return tree;
		}
	}
	
	private Comparable removeSmallest(Node tree) {
		if (tree.left.left == null) {
			Comparable smallest = tree.left.data;
			tree.left = tree.left.right;
			return smallest;
		} else {
			return removeSmallest(tree.left);
		}
	}
	
	public String toStringPreOrder() {
		StringBuilder a = new StringBuilder();
		printPre(root, a);
		return a.toString().trim();
	}
	
	public String toStringInOrder() {
		StringBuilder b = new StringBuilder();
		printIn(root, b);
		return b.toString().trim();
	}	
	
	private void printIn(Node tree, StringBuilder b) {
		if (tree != null) {
			printIn(tree.left, b);
			b.append(tree.data + " ");
			printIn(tree.right, b);
		}
	}
	
	private void printPre(Node tree, StringBuilder a) {
		if(tree != null) {
			a.append(tree.data + " ");
			printPre(tree.left, a);
			printPre(tree.right, a);
		}
	}
	
 }
