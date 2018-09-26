import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numArray =  Arrays.stream(sc.next().split(","))
           .mapToInt(Integer::parseInt)
           .toArray();
		Arrays.sort(numArray);
		int i = 0;
		int count = 0;
		int totalCount = 0;
		while (i < numArray.length - 1) {
			if (numArray[i] == numArray[i + 1]) {
				count += 1;
			}
			if (numArray[i] != numArray[i + 1] || i == numArray.length-2) {
				totalCount += ((count + 1) * (count)) / 2;
				count = 0;
			}
			i++;
		}
		System.out.println(totalCount);
	}
}