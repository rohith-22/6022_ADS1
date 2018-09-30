import java.util.Scanner;
/**
 * Dequeue class for the implimentaion of dequeue using linked list.
 *
 * @param      <E>   generic Deque
 */
class Deque<E> {
  /**.
   *  variable Size.
   */
  int size;
  /**.
   * Object for linked list.
   */
  LinkedList<E> queue;
  /**
   * Constructs the object for deque.
   */
  Deque() {
    queue = new LinkedList<E>();
    size = 0;
  }
  /**.
   * this method checks whether linked list is empty or not.
   *
   * @return     True if empty, False otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  }
  /**.
   * Size method to know the size
   *
   * @return     returns size.
   */
  public int size() {
    return size;
  }
  /**.
   * this method to put the element at the left end.
   *
   * @param      item  The item
   */
  public void pushLeft(final E item) {
    queue.addAtStart(item);
    size++;
    queue.print();
  }
  /**.
   * this method to push the element in right end.
   *
   * @param      item  The item
   */
  public void pushRight(final E item) {
    queue.addAtEnd(item);
    size++;
    queue.print();
  }
  /**.
   * remove the elemenet from left end.
   */
  public void popLeft() {
    if (size == 0) {
      System.out.println("Deck is empty");
      return;
    }
    size--;
    queue.removeAtStart();
    if (queue.getSize() == 0) {
      System.out.println("[]");
      return;
    }
    queue.print();
  }
  /**.
   * this method removes from right end.
   */
  public void popRight() {
    if (size == 0) {
      System.out.println("Deck is empty");
      return;
    }
    size--;
    queue.removeAtEnd();
    if (queue.getSize() == 0) {
      System.out.println("[]");
      return;
    }
    queue.print();
  }

}
/**.
 * Solution class
 */
public final class Solution {
  /**.
   * Constructor.
   */
  private Solution() {
  }
  /**.
   * Main method to handle input.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Deque<Integer> d = new Deque<Integer>();
    Scanner scan = new Scanner(System.in);
    while (scan.hasNext()) {
      String[] tokens = scan.nextLine().split(" ");
      switch (tokens[0]) {
      case "pushLeft":
        d.pushLeft(Integer.parseInt(tokens[1]));
        break;
      case "pushRight":
        d.pushRight(Integer.parseInt(tokens[1]));
        break;
      case "size":
        System.out.println(d.size());
        break;
      case "isEmpty":
        System.out.println(d.isEmpty());
        break;
      case "popLeft":
        d.popLeft();
        break;
      case "popRight":
        d.popRight();
        break;
      default:
        break;
      }
    }
  }
}
