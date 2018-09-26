import java.util.Scanner;
import java.util.Arrays;
/**
 * Class to calculate three sum.
 */
class ThreeSum {
  /**
   * count function givs the count of the threesum pairs
   *
   * @param      arrayOfNumbers  The array of numbers
   *
   * @return     returns the threesum count in the array
   */
  public int  count(final int[] arrayOfNumbers) {
    int countOfThreeSums = 0, j = 0, k = 0;
    for (int i = 0; i < arrayOfNumbers.length; i++) {
      j = i + 1;
      k = arrayOfNumbers.length - 1;
      while (j < k) {
        if (arrayOfNumbers[i] + arrayOfNumbers[j] + arrayOfNumbers[k] < 0) {
          j++;
        } else if (arrayOfNumbers[i] + arrayOfNumbers[j] + arrayOfNumbers[k] > 0) {
          k--;
        } else {
          j++;
          k--;
          countOfThreeSums += 1;
        }
      }
    }
    return countOfThreeSums;
  }
}
/**
 * Class for solution.
 */
public class Solution {
  /**
   * main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    ThreeSum objectThreeSum = new ThreeSum();
    int[] arrayOfNumbers = new int[sc.nextInt()];
    for (int i = 0; i < arrayOfNumbers.length; i++) {
      arrayOfNumbers[i] = sc.nextInt();
    }
    Arrays.sort(arrayOfNumbers);
    System.out.println(objectThreeSum.count(arrayOfNumbers));
  }
}
