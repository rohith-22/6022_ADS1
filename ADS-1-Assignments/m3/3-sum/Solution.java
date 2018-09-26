import java.util.Scanner;
import java.util.Arrays;
class ThreeSum {
	public int  count(int[] arrayOfNumbers) {
		int countOfThreeSums = 0, j = 0, k = 0;
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			j = i + 1;
			k = arrayOfNumbers.length - 1;
			while (j < k) {
				if (arrayOfNumbers[i] + arrayOfNumbers[j] + arrayOfNumbers[k] < 0) {
					j += 1;
				} else if (arrayOfNumbers[i] + arrayOfNumbers[j] + arrayOfNumbers[k] > 0) {
					k -= 1;
				} else {
					j = 1;
					k = 1;
					countOfThreeSums += 1;
				}
			}
		}
		return countOfThreeSums;
	}
}
public class Solution {
	public static void main(String[] args) {
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