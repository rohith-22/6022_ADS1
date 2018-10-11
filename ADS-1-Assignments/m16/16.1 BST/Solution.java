import java.util.*;
class Books implements Comparable<Books>{
	private String authorOfBook;
	private String nameOfBook;
	private String price;
	Books(final String b, final String a, final String p) {
		nameOfBook = b;
		authorOfBook = a;
		price = p;
	}
	public int compareTo(final Books obj) {
		return nameOfBook.compareTo(obj.nameOfBook);
	}
}
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;


		public Node(Key key, Value val) {
			this.key = key;
			this.value = val;

		}
	}
	public void put(final Key key, final Value value) {
		if (key == null) {
			return;
		}
		root = put(root, key, value);
	}
	
	public Node put(final Node node, final Key key,
	                final Value value) {
		if (node == null) {
			return new Node(key, value);
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else if (cmp > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		return node;
	}
	
	public Value get(final Key key) {
		return get(root, key);
	}
	
	private Value get(final Node node, final Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return get(node.left, key);
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			return node.value;
		}
	}
}
public final class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree <Books, Integer> object = new BinarySearchTree<>();
		final int three = 3, four = 4;
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			switch (tokens[0]) {
			case "put":
				object.put(new Books(tokens[1], tokens[2], tokens[three]), Integer.parseInt(tokens[four]));
				break;
			case "get":
				object.get(new Books(tokens[1], tokens[2], tokens[three]));
				break;
			default:
			}
		}
	}
}