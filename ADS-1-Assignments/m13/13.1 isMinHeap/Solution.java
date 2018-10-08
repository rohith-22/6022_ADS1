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
		String dataType = sc.nextLine();
		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testCases; i++) {
			String str = sc.nextLine();
			if (str.length() == 0) {
				System.out.println("false");
				break;
			}
			String[] stringArray = str.split(",");
			switch (dataType) {
			case "String":
				MinHeap<String> object1Minheap = new MinHeap<String>(stringArray);
				System.out.println(object1Minheap.isMinHeap());
				break;
			case "Integer":
				Integer[] intArray = new Integer[stringArray.length];
				for (int j = 0; j < stringArray.length; j++) {
					intArray[j] = Integer.parseInt(stringArray[j]);
				}
				IsMinHeap<Integer> object2Minheap
				  = new IsMinHeap<Integer>(intArray);
				System.out.println(object2Minheap.isMinHeap());
				break;
			case "Double":
				Double[] doubleArray = new Double[stringArray.length];
				for (int j = 0; j < stringArray.length; j++) {
					doubleArray[j] = Double.parseDouble(stringArray[j]);
				}
				IsMinHeap<Double> object3Minheap
				  = new IsMinHeap<Double>(doubleArray);
				System.out.println(object3Minheap.isMinHeap());
				break;
			case "Float":
				Float[] floatArray = new Float[stringArray.length];
				for (int j = 0; j < stringArray.length; j++) {
					floatArray[j] = Float.parseFloat(stringArray[j]);
				}
				IsMinHeap<Float> object4Minheap
				  = new IsMinHeap<Float>(floatArray);
				System.out.println(object4Minheap.isMinHeap());
				break;
			default:
			}
		}
	}
}