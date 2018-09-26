import java.util.*;
public class Solution {
  public static int[] intArray(final String s) {
    if (s.equals("")) {
      return new int[0];
    }
    return Arrays.stream(s.split(","))
           .mapToInt(Integer::parseInt)
           .toArray();
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[]firstArray = new int[sc.nextInt()];
    int[]secondArray = new int[sc.nextInt()];
    firstArray = intArray(sc.next());
    secondArray = intArray(sc.next());
    // System.out.println(Arrays.toString(firstArray));
    // System.out.println(Arrays.toString(secondArray));
    int[] resultArray = new int[firstArray.length + secondArray.length];
    System.arraycopy(firstArray, 0, resultArray, 0, firstArray.length);
    System.arraycopy(secondArray, 0, resultArray, firstArray.length, secondArray.length);
    Arrays.sort(resultArray);
    System.out.println(Arrays.toString(resultArray).replace("[","").replace("]","").replace(" ",""));
  }
}