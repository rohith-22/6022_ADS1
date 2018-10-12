import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
  /**
   *  variable sum.
   */
  private final int sum;
  /**
   * variable first.
   */
  private final int first;
  /**
   * variable second.
   */
  private final int second;
  /**
   * Constructs the object.
   *
   * @param      firstNumber   The first number
   * @param      secondNumber  The second number
   */
  CubeSum(final int firstNumber, final int secondNumber) {
    sum = firstNumber * firstNumber * firstNumber
          + secondNumber * secondNumber * secondNumber;
    first = firstNumber;
    second = secondNumber;
  }
  /**
   * Gets the sum.
   *
   * @return     The sum.
   */
  public int getSum() {
    return sum;
  }
  /**
   * Gets the first.
   *
   * @return     The first.
   */
  public int getFirst() {
    return first;
  }
  /**
   * Gets the second.
   *
   * @return     The second.
   */
  public int getSecond() {
    return second;
  }
  /**
   * compaers the sum of both objects.
   *Time complexity is O(1)
   * @param      other  The other
   *
   * @return     int
   */
  public int compareTo(final CubeSum other) {
    if (sum < other.sum) {
      return -1;
    }
    if (sum > other.sum) {
      return +1;
    }

    return 0;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return sum + " = " + first + "^3" + " + " + second + "^3";
  }



}
/**
 * class Solution.
 */
final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function to handle testcases.
   *Time complexity of main function is O(2N) because we
   *used one for loop and a while loop.
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] tokens = scan.nextLine().split(" ");
    int counter = 0;
    final int limit = 600;
    int nthNumber = Integer.parseInt(tokens[0]);
    int combinations = Integer.parseInt(tokens[1]);
    int tempSum = -1;

    MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
    for (int i = 0; i <= limit; i++) {
      pq.insert(new CubeSum(i, i));
    }

    while (!pq.isEmpty()) {
      CubeSum s = pq.delMin();
      if (tempSum == s.getSum()) {
        counter++;
      } else {
        counter = 0;
      }
      if (counter == combinations - 1) {
        nthNumber--;
        if (nthNumber == 0) {
          System.out.println(s.getSum());
          break;
        }
      }

      tempSum = s.getSum();
      if (s.getSecond() < limit) {
        pq.insert(new CubeSum(
                    s.getFirst(), s.getSecond() + 1));
      }
    }
  }
}
