import java.util.Scanner;
/**
 * Class for books.
 */
class Books implements Comparable<Books> {
  /**
   * authorOfbooks variable.
   */
  private String authorOfBook;
  /**
   * nameofbooks variable.
   */
  private String nameOfBook;
  /**
   * price variable.
   */
  private String priceOfBook;
  /**
   * Constructs the object.
   *
   * @param      bookName  The book name
   * @param      author    The author
   * @param      price     The price
   */
  Books(final String bookName, final String author,
        final String price) {
    nameOfBook = bookName;
    authorOfBook = author;
    priceOfBook = price;
  }
  /**
   * compares the two book objects using name.
   *
   * @param      obj   The object
   *
   * @return     returns int
   */
  public int compareTo(final Books obj) {
    return nameOfBook.compareTo(obj.nameOfBook);
  }
}
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
  /**
   * Node variable root.
   */
  private Node root;
  /**
   * Class for node.
   */
  private class Node {
    /**
     * key variable.
     */
    private Key key;
    /**
     * value variable.
     */
    private Value value;
    /**
     * lef node and right rode.
     */
    private Node left, right;
    /**
     * Constructs the object.
     *
     * @param      key1   The key
     * @param      val   The value
     */
    Node(final Key key1, final Value val) {
      this.key = key1;
      this.value = val;

    }
  }
  /**
   * Constructs the object.
   */
  BinarySearchTree() {

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
  public Key min() {
    return min(root).key;
  }

  private Node min(Node x) {
    if (x.left == null) return x;
    else                return min(x.left);
  }
  public Key max() {
    return max(root).key;
  }

  private Node max(Node x) {
    if (x.right == null) return x;
    else                 return max(x.right);
  }
  public Key floor(Key key) {
    Node x = floor(root, key);
    if (x == null) return null;
    else return x.key;
  }

  private Node floor(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x;
    if (cmp <  0) return floor(x.left, key);
    Node t = floor(x.right, key);
    if (t != null) return t;
    else return x;
  }
  public Key ceiling(Key key) {
    Node x = ceiling(root, key);
    if (x == null) return null;
    else return x.key;
  }

  private Node ceiling(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x;
    if (cmp < 0) {
      Node t = ceiling(x.left, key);
      if (t != null) return t;
      else return x;
    }
    return ceiling(x.right, key);
  }

}

/**
 * Class for solution.
 */
public class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    //empty constructor.
  }
  /**
   * main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    BinarySearchTree<Books, Integer> objectBST = new BinarySearchTree<>();
    while (sc.hasNext()) {
      String[] tokens = sc.nextLine().split(",");
      switch (tokens[0]) {
      case "put":
        objectBST.put(new Books(tokens[1], tokens[2],
                                tokens[2 + 1]), Integer.parseInt(tokens[2 + 2]));
        break;
      case "get":
        System.out.println(objectBST.get(new Books(
                                           tokens[1], tokens[2],

                                           tokens[2 + 1])));
        break;
      case "max":
        System.out.println(objectBST.max());
        break;
      case "min":
        System.out.println(objectBST.min());
        break;
      case "floor":
        System.out.println(objectBST.floor(
                             new Books(tokens[1], tokens[2],

                                       tokens[2 + 1])));
        break;
      case "ceiling":
        System.out.println(objectBST.ceiling(
                             new Books(tokens[1], tokens[2],

                                       tokens[2 + 1])));
        break;
      default:
        break;
      }
    }
  }
}
