import java.util.Scanner;
/**.
 * Class for median finding.
 */
class MedianFinding {
  /**.
   *  an object for MinPQ class
   */
  private MinPQ<Double> minPqObj;
  /**.
   *  an object for MaxPQ class
   */
  private MaxPQ<Double> maxPqObj;
  /**.
   * Constructs the object.
   */
  MedianFinding() {
    minPqObj = new MinPQ<Double>();
    maxPqObj = new MaxPQ<Double>();
  }
  /**.
   * this method inserts element into minheap.
   *
   * @param      item  The item
   */
  public void minInsert(final Double item) {
    minPqObj.insert(item);
  }
  /**.
   * this method inserts element into maxheap.
   *
   * @param      item  The item
   */
  public void maxInsert(final Double item) {
    maxPqObj.insert(item);
  }
  /**.
   * Gets the minimum element from minheap.
   *
   * @return     The minimum element from minheap.
   */
  public Double getMin() {
    return minPqObj.min();
  }
  /**.
   * Gets the maximum element from maxheap.
   *
   * @return     The maximum element from maxheap.
   */
  public Double getMax() {
    return maxPqObj.max();
  }
  /**.
   * this method deletes the min element from minheap
   *
   * @return     returns the deleted element from minheap
   */
  public Double delMin() {
    return minPqObj.delMin();
  }
  /**.
   * this method deletes the max element from maxheap
   *
   * @return     returns the deleted element from maxheap
   */
  public Double delMax() {
    return maxPqObj.delMax();
  }
  /**.
   * Gets the size of maxheap.
   *
   * @return     the size of maxheap.
   */
  public int getMaxSize() {
    return maxPqObj.size();
  }
  /**.
   * the size of minheap
   *
   * @return     the size of minheap.
   */
  public int getMinSize() {
    return minPqObj.size();
  }
}
/**.
 * Class for solution.
 */
final class Solution {
  /**.
   * Constructs the object.
   */
  private Solution() {

  }
  /**.
   * main method is used to handle testcases
   * Time complexity of this method is O(NlogN).
   * N is the number of inputs.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    MedianFinding objectMedian = new MedianFinding();
    int inputs = Integer.parseInt(sc.nextLine());
    Double  number = Double.parseDouble(sc.nextLine());
    Double median = number;
    objectMedian.minInsert(number);
    System.out.println(median);
    for (int i = 1; i < inputs; i++) {
      number = Double.parseDouble(sc.nextLine());
      if (number >= median) {
        objectMedian.minInsert(number);
      } else {
        objectMedian.maxInsert(number);
      }
      if (objectMedian.getMinSize() - objectMedian.getMaxSize() > 1) {
        objectMedian.maxInsert(objectMedian.delMin());
      }
      if (objectMedian.getMaxSize() - objectMedian.getMinSize() > 1) {
        objectMedian.minInsert(objectMedian.delMax());
      }
      if (Math.abs(objectMedian.getMaxSize()
                   - objectMedian.getMinSize()) == 1) {
        if (objectMedian.getMinSize() > objectMedian.getMaxSize()) {
          median = objectMedian.getMin();
          System.out.println(median);
        } else {
          median = objectMedian.getMax();
          System.out.println(median);
        }
      }
      if (objectMedian.getMinSize() == objectMedian.getMaxSize()) {
        median = (objectMedian.getMin() + objectMedian.getMax()) / 2.0;
        System.out.println(median);
      }
    }
  }
}
