import java.util.*;
import java.util.Scanner;
/**
 * Class for is minimum heap.
 *
 * @param      <E> generic.
 */
class MinHeap<E extends Comparable<E>> {
	/**
	 * array of generic type.
	 */
	private E[] array;
	/**
	 * Constructs the object.
	 *
	 * @param  a generic type
	 */
	MinHeap(final E[] a) {
		this.array = a;
	}
	/**
	 * Determines if minimum heap.
	 * time complexity is N.
	 * @return     True if minimum heap, False otherwise.
	 */
	public boolean isMinHeap() {
		for (int i = 0; i < array.length - 1; i++) {
			if (less(i + 1, i)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * checks whether the element is less.
	 *
	 * @param      i  integer.
	 * @param      j  integer.
	 *
	 * @return   True if less, False otherwise.
	 */
	public boolean less(final int i, final int j) {
		return array[i].compareTo(array[j]) < 0;
	}

}


public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String dataType = sc.next();
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			switch (dataType) {
			case "String":
				String[] stringArray = sc.next().split(",");
				MinHeap<String> object1Minheap = new MinHeap<String>(stringArray);
				System.out.println(object1Minheap.isMinHeap());
				break;
			case "Integer":
				String[] tokens1 = sc.nextLine().split(",");
				Integer[] intArray = new Integer[tokens1.length];
				for (int j = 0; j < tokens1.length; j++) {
					intArray[j] = Integer.parseInt(tokens1[j]);
				}
				IsMinHeap<Integer> object2Minheap
				  = new IsMinHeap<Integer>(intArray);
				System.out.println(object2Minheap.isMinHeap());
				break;
			case "Double":
				String[] tokens2 = sc.nextLine().split(",");
				Double[] doubleArray = new Double[tokens2.length];
				for (int j = 0; j < tokens2.length; j++) {
					doubleArray[j] = Double.parseDouble(tokens2[j]);
				}
				IsMinHeap<Double> object3Minheap
				  = new IsMinHeap<Double>(doubleArray);
				System.out.println(object3Minheap.isMinHeap());
				break;
			case "Float":
				String str = sc.nextLine();
				if (str.equals("")) {
					System.out.println("false");
					break;
				} else {
					String[] tokens3 = str.split(",");
					Float[] floatArray = new Float[tokens3.length];
					for (int j = 0; j < tokens3.length; j++) {
						floatArray[j] = Float.parseFloat(tokens3[j]);
					}
					IsMinHeap<Float> object4Minheap
					  = new IsMinHeap<Float>(floatArray);
					System.out.println(object4Minheap.isMinHeap());
				}
				break;
			default:
				break;
			}
		}
	}
}