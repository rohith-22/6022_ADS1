import java.util.*;
public class Solution {
	public static int[] intArray(final String s) {
		return Arrays.stream(s.split(","))
		       .mapToInt(Integer::parseInt)
		       .toArray();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[]firstArray = new int[sc.nextInt()];
		int[]secondArray = new int[sc.nextInt()];
		if (firstArray.length != 0) {
			firstArray = intArray(sc.next());
		} if (secondArray.length != 0) {
			secondArray = intArray(sc.next());
		}
		int[] resultArray = new int[firstArray.length + secondArray.length];
		int i = 0, j = 0, k = 0;
		while (i < firstArray.length && j < secondArray.length) {
			if (firstArray[i] < secondArray[j]) {
				resultArray[k++] = firstArray[i];
				i = i + 1;
			} else if (firstArray[i] > secondArray[j]) {
				resultArray[k++] = secondArray[j];
				j = j + 1;
			}
		}
		if (firstArray.length > secondArray.length) {
			while (k < firstArray.length + secondArray.length) {
				resultArray[k++] = firstArray[i++];
			}

		}
		if (secondArray.length > firstArray.length) {
			while (k < firstArray.length + secondArray.length) {
				resultArray[k++] = secondArray[j++];
			}
		}
		System.out.println(Arrays.toString(resultArray).replace("[", "").replace("]", "").replace(" ", ""));

	}
}