import java.util.Scanner;

// class Students implements Comparable<Students> {
// 	/**
// 	 * name variable.
// 	 */
// 	private String studentName;
// 	/**
// 	 * roll number variable.
// 	 */
// 	private int rollNumber;
// 	/**
// 	 * totalMarks variable.
// 	 */
// 	private Double totalMarks;
// 	/**
// 	 * Constructs the object.
// 	 *
// 	 * @param      roll  The  roll
// 	 * @param      name    The name
// 	 * @param      marks     The marks
// 	 */
// 	Students(final int roll, final String name,
// 	         final Double marks) {
// 		rollNumber = roll;
// 		studentName = name;
// 		totalMarks = marks;
// 	}
// 	/**
// 	 * compares the two students marks objects using name.
// 	 *
// 	 * @param      obj   The object
// 	 *
// 	 * @return     returns int
// 	 */
// 	public int compareTo(final Students obj) {
// 		return totalMarks.compareTo(obj.totalMarks);
// 	}
// 	/**.
// 	   * Returns a string representation of the object.
// 	   *
// 	   * @return     String representation of the object.
// 	   */
// 	// public String toString() {
// 	// 	return this.studentName;
// 	// }
// }
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInputs = Integer.parseInt(sc.nextLine());
		BinarySearchTree<Integer, String> objectOneBST = new BinarySearchTree<>();
		BinarySearchTree<Double, String>objectTwoBST = new BinarySearchTree<>();
		for (int i = 0; i < noOfInputs; i++) {
			String[] tokens = sc.nextLine().split(",");
			objectOneBST.put(Integer.parseInt(tokens[0]), tokens[1]);
			objectTwoBST.put(Double.parseDouble(tokens[2]), tokens[1]);

		}
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[2]) {
			case "1":
				System.out.println(objectOneBST.get(Integer.parseInt(tokens[1])));
				break;
			case "2":
				System.out.println(objectTwoBST.get(Double.parseDouble(tokens[1])));
				break;

			}
		}
	}
}