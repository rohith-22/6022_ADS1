import java.util.Scanner;
public class Solution {
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfInputs = Integer.parseInt(scan.nextLine());
		LinearProbingHashST<Integer, String> object = new LinearProbingHashST<Integer, String>();
		for (int i = 0; i < numberOfInputs; i++) {
			String[] tokens = scan.nextLine().split(",");
			String string = tokens[1] + "&&" + tokens[2];
			object.put(Integer.parseInt(tokens[0]), string);
		}
		int queries = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < queries; i++) {
			String[] tokens = scan.nextLine().split(" ");
			String studentInfo = object.get(Integer.parseInt(tokens[1]));
			switch (tokens[2]) {
			case "1":
				if (studentInfo != null) {
					String[] tokensOne = studentInfo.split("&&");
					System.out.println(tokensOne[0]);
				} else {
					System.out.println("Student doesn't exists...");
				}
				break;
			case "2":
				if (studentInfo != null) {
					String[] tokensOne = studentInfo.split("&&");
					System.out.println(tokensOne[1]);
				} else {
					System.out.println("Student doesn't exists...");
				}
				break;
			}


		}
	}
}