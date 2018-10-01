import java.util.Scanner;

/**
 * Class for steque.
 *
 * @param      <E>   { parameter_description }
 */
class Steque<E> {

  /**
   * Class for node.
   */
  private final class Node {

    /**
     * Declaration.
     */
    private E data;
    /**
     * Declaration.
     */
    private Node next;

    /**
     * Constructs the object.
     *
     * @param      data1  The data
     * @param      next1  The next
     */
    Node(final E data1, final Node next1) {
      this.data = data1;
      this.next = next1;
    }

    /**
     * Gets the data.
     *
     * @return     The data.
     */
    public E getData() {
      return data;
    }

    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNext() {
      return next;
    }

  }

  /**
   * Deaclaration of variables.
   */
  private Node head, tail;


  /**
   * Adds an element at head.
   * Best case: O(1)
   * Worst case: O(1)
   * Average case: O(1)
   *
   * @param      data  The data
   */
  public void push(final E data) {

    Node node = new Node(data, head);
    node.data = data;
    node.next = head;
    if (head == null) {
      tail = node;
      head  = node;
      return;
    }
    head = node;

  }

  /**
   * Adds an element at tail.
   * Best Case: O(1)
   * Worst Case: O(1)
   * Average Case: O(1)
   *
   * @param      data  The data
   */
  public void enqueue(final E data) {

    Node node = new Node(data, null);
    node.data = data;
    if (head == null) {
      tail = node;
      head  = node;
      return;
    }
    tail.next = node;
    tail = tail.next;

  }

  /**
   * Pops the element at head.
   * Best case: O(1)
   * Worst case: O(1)
   * Average case: O(1)
   *
   * @return     { description_of_the_return_value }
   */
  public E pop() {
    if (head != null) {
      E data = head.data;
      head = head.next;
      return data;
    } else {
      return null;
    }

  }

  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {

    if (head != null) {
      Node printHead = head;
      String s = "";
      while (printHead.next != null) {
        s += printHead.data + ", ";
        printHead = printHead.next;
      }
      s += printHead.data;
      return s;
    } else {
      return "Steque is empty.";
    }

  }

}

/**
 * Class for Solution.
 */
public final class Solution {

  /**
   * Constructs the object.
   */

  private Solution() {
    /**
     * Unused.
     */
  }

  /**
   * Main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {

    Scanner sc = new Scanner(System.in);
    // int n = Integer.parseInt(sc.next());
    Steque<Integer> steque = new Steque<>();
    sc.nextLine();
    while (sc.hasNext()) {
      String[] tokens = sc.nextLine().split(" ");

      switch (tokens[0]) {
      case "push":
        steque.push(Integer.parseInt(tokens[1]));
        System.out.println(steque);
        break;
      case "enqueue":
        steque.enqueue(Integer.parseInt(tokens[1]));
        System.out.println(steque);
        break;
      case "pop":
        // steque.pop();
        // System.out.println(steque);
        if (steque.pop() == null) {
          System.out.println(steque);
        } else {
          System.out.println(steque);
        }
        break;
      default:
        steque = new Steque<>();
        System.out.println();
        break;
      }

    }

  }

}
