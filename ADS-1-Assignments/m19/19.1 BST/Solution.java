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
  private Double priceOfBook;
  /**
   * Constructs the object.
   *
   * @param      bookName  The book name
   * @param      author    The author
   * @param      price     The price
   */
  Books(final String bookName, final String author,
        final Double price) {
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
  /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
  public String toString() {
    return this.nameOfBook + ", " + this.authorOfBook + ", "
           + this.priceOfBook;
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
     * varibale size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      key1   The key
     * @param      val   The value
     */
    Node(final Key key1, final Value val, final int sizeOne) {
      this.key = key1;
      this.value = val;
      this.size = sizeOne;

    }

  }
  /**
   * Constructs the object.
   */
  BinarySearchTree() {

  }
  /**.
  * This method is to add a key and value to BST.
  * Time Complexity is O(N).
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
    * This method is to add element to BST
    * Time Complexity is O(N) for worst case.
    * element is added until it reaches to the
    * position it should added at.
    *
    * @param      node   The node
    * @param      key    The key
    * @param      value  The value
    *
    * @return     returns node
    */
  public Node put(final Node node, final Key key,
                  final Value value) {
    if (node == null) {
      return new Node(key, value, 1);
    }
    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      node.left = put(node.left, key, value);
    } else if (cmp > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    node.size = 1 + size(node.left) + size(node.right);
    return node;
  }
  /**.
   * This method is to return the value of that key
   * Time Complexity is O(N)
   *
   * @param      key   The key
   *
   * @return     returns the value.
   */
  public Value get(final Key key) {
    return get(root, key);
  }
  /**.
   * This method is to return the value of that key
   * Time Complexity is O(N)
   *
   * @param      node  the node where the book details and
   *                   value.
   * @param      key   The key
   *
   * @return     returns the value of that key.
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
  /**.
     * this method returns minimum element in the tree
     * Time complexity is O(logN)
     *
     * @return     returns minimum book details in the tree
     */
  public Key min() {
    return min(root).key;
  }
  /**.
     * this method returns minimum element in the tree
     * Time complexity is O(logN)
     * it checks only left side of tree to find minimum
     * element.
     *
     * @param      x     node it starts the checkong
     *
     * @return     returns minimum book details in the tree
     */
  private Node min(final Node x) {
    if (x.left == null) {
      return x;
    } else {
      return min(x.left);
    }
  }
  /**.
     * this method returns maximum element in the tree
     * Time complexity is O(logN)
     *
     * @return     returns maximum element in the tree
     */
  public Key max() {
    return max(root).key;
  }
  /**.
     * this method returns maximum element in the tree
     * Time complexity is O(logN)
     * it checks only right side of tree to find max element
     *
     * @param      x  The node
     *
     * @return     eturns maximum element in the tree
     */
  private Node max(final Node x) {
    if (x.right == null) {
      return x;
    } else {
      return max(x.right);
    }
  }
  /**.
     * this method returns the value of the given
     * book data else returns null.
     * Time complexity is O(logN)
     *
     * @param      key   The key
     *
     * @return     this method returns the value of the given
     *             book data else returns null.
     */
  public Key floor(final Key key) {
    Node x = floor(root, key);
    if (x == null) {
      return null;
    } else {
      return x.key;
    }
  }
  /**
     * this method returns the value of the given
     * book data else returns null.
     * Time complexity is O(logN)
     * it checks the element from root node to desired node
     *
     * @param      node     node with bookdetails
     * @param      key   The key
     *
     * @return     this method returns the value of the given
     *             book data else returns null.
    */
  private Node floor(final Node x, final Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    }
    if (cmp <  0) {
      return floor(x.left, key);
    }
    Node t = floor(x.right, key);
    if (t != null) {
      return t;
    } else {
      return x;
    }
  }
  /**.
     * this method returns the value of the given
     * book data else returns null.
     * Time complexity is O(logN)
     *
     * @param      key   The key
     *
     * @return     this method returns the value of the given
     *             book data else returns null.
     */

  public Key ceiling(final Key key) {
    Node x = ceiling(root, key);
    if (x == null) {
      return null;
    } else {
      return x.key;
    }
  }
  /**.
     * this method returns the value of the given
     * book data else returns null.
     * Time complexity is O(logN)
     * it checks the element from root node to desired node
     *
     * @param      x  The node
     * @param      key   The key
     *
     * @return     this method returns the value of the given
     *             book data else returns null.
     */
  private Node ceiling(final Node x, final Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    }
    if (cmp < 0) {
      Node t = ceiling(x.left, key);
      if (t != null) {
        return t;
      } else {
        return x;
      }
    }
    return ceiling(x.right, key);
  }
  /**.
     * this method returns the element in that position
     * Time complexity is O(logN)
     *
     * @param      k     position given as input
     *
     * @return     returns the element in that position
     */
  public Key select(final int k) {
    Node node = select(root, k);
    return node.key;
  }
  /**.
     * size of tree
     *
     * @return     returns size of tree
     */
  public int size() {
    return size(root);
  }
  /**
     * returns size of tree
     * Time Complexity is O(1).
     * it returns the size of that node.
     *
     * @param      node  The node
     *
     * @return     returns size of tree.
     */
  private int size(final Node node) {
    if (node == null) {
      return 0;
    } else {
      return node.size;
    }
  }
  /**.
     * this method returns the element in that position
     * Time complexity is O(logN)
     * it checks from root node to desired position
     *
     * @param      node  The node
     * @param      k     position of node
     *
     * @return     returns node of the that position
     */
  private Node select(final Node node, final int k) {
    if (node == null) {
      return null;
    }
    int t = size(node.left);
    if (t > k) {
      return select(node.left,  k);
    } else if (t < k) {
      return select(node.right, k - t - 1);
    } else {
      return node;
    }
  }


}
/**
 * Class for solution.
 */
public final class Solution {
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
        objectBST.put(new Books(tokens[1], tokens[2], Double.parseDouble(
                                  tokens[2 + 1])),
                      Integer.parseInt(tokens[2 + 2]));
        break;
      case "get":
        System.out.println(objectBST.get(new Books(
                                           tokens[1], tokens[2],
                                           Double.parseDouble(
                                             tokens[2 + 1]))));
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
                                       Double.parseDouble(
                                         tokens[2 + 1]))));
        break;
      case "ceiling":
        System.out.println(objectBST.ceiling(
                             new Books(tokens[1], tokens[2],
                                       Double.parseDouble(
                                         tokens[2 + 1]))));
        break;
      case "select":
        System.out.println(objectBST.select(Integer.parseInt(tokens[1])));
        break;
      default:
        break;
      }
    }
  }
}
