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
  /**.
  * This method is to add a key and value to BST.
  * Time Complexity is O(1).
  *
  * @param      key    The key
  * @param      value  The value
  */
  public void put(final Key key, final Value value) {
    if (key == null) {
      return;
    }
    root = put(root, key, value);
  }
  /**
   * This method is to add element to Binary Search Tree.
   * Time Complexity is O(N) for worst case.
   * iterates till the end.
   * position it should added at.
   * @param      node   The node
   * @param      key    The key
   * @param      value  The value
   *
   * @return     The Node
   */
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
  /**
   * This method is to return the value of that key.
   * Time Complexity is O(N)
   * @param      key   The key
   *
   * @return     the value
   */
  public Value get(final Key key) {
    return get(root, key);
  }
  /**.
   * This method is to return the value of that key
   * Time Complexity is O(N)
   * @param      node  The node
   * @param      key   The key
   *
   * @return     the value
   */
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
/**
 * Solution class.
 */
public final class Solution {
  /**
   * unused constructor.
   */
  private Solution() {

  }
  /**
   * main funciton to handle input and output testcases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    BinarySearchTree<Books, Integer> object = new BinarySearchTree<>();
    final int three = 3, four = 4;
    while (sc.hasNext()) {
      String[] tokens = sc.nextLine().split(",");
      switch (tokens[0]) {
      case "put":
        object.put(new Books(tokens[1], tokens[2], tokens[three]),
                   Integer.parseInt(tokens[four]));
        break;
      case "get":
        System.out.println(object.
                           get(new Books(tokens[1],
                                         tokens[2], tokens[three])));
        break;
      default:
      }
    }
  }
}
