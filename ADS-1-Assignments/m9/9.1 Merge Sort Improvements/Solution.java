import java.util.Scanner;
class InsertionSort {
	InsertionSort() {

	}
	public void insertionSort(Comparable[] array, int low, int hi) {
		Sorting objectSort = new Sorting();
		for (int i = low; i <= hi; i++)
			for (int j = i; j > low && objectSort.less(array[j], array[j - 1]); j--)
				objectSort.exchange(array, j, j - 1);
	}

}
class MergeSort {
	MergeSort() {

	}
	public void merge(Comparable[] list, Comparable[] newlist, int low, int mid, int hi) {
		Sorting objectSort = new Sorting();
		assert objectSort.isSorted(list, low, mid);
		assert objectSort.isSorted(list, mid + 1, hi);

		int i = low, j = mid + 1;
		for (int k = low; k <= hi; k++) {
			if (i > mid) {
				newlist[k] = list[j++];
			}

			else if (j > hi) {
				newlist[k] = list[i++];
			}

			else if (objectSort.less(list[j], list[i])) {
				newlist[k] = list[j++];
			} else {
				newlist[k] = list[i++];
			}
		}
		assert objectSort.isSorted(newlist, low, hi);
	}

}
class Sorting {
	public void sort(Comparable[] array) {
		Comparable[] auxilaryArray = array.clone();
		sort(auxilaryArray, array, 0, array.length - 1);
		assert isSorted(array);
	}

	public void sort(Comparable[] list, Comparable[] newlist, int low, int hi) {
		final int seven = 7;
		if (hi <= low + seven) {
			InsertionSort objectInsertionSort = new InsertionSort();
			objectInsertionSort.insertionSort(newlist, low, hi);
			System.out.println("Insertion sort method invoked...");
			return;
		}
		int mid = low + (hi - low) / 2;
		sort(newlist, list, low, mid);
		sort(newlist, list, mid + 1, hi);

		if (!less(list[mid + 1], list[mid])) {
			for (int i = low; i <= hi; i++) {
				newlist[i] = list[i];
			}
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}
		MergeSort objectMergeSort = new MergeSort();
		objectMergeSort.merge(list, newlist, low, mid, hi);
	}

	public boolean less(Comparable array, Comparable arrayTwo) {
		return array.compareTo(arrayTwo) < 0;
	}

	public boolean isSorted(Comparable[] array) {
		return isSorted(array, 0, array.length - 1);
	}

	public boolean isSorted(Comparable[] array, int low, int hi) {
		for (int i = low + 1; i <= hi; i++)
			if (less(array[i], array[i - 1])) {
				return false;
			}
		return true;
	}
	public void exchange(Comparable[] array, int i, int j) {
		Comparable swap = array[i];
		array[i] = array[j];
		array[j] = swap;
	}
	public Object toString(Object[] array) {
		String s = "[";
		int i;
		for (i = 0; i < array.length - 1; i++) {
			s += array[i] + ", ";
		}
		s = s + array[array.length - 1] + "]";
		return s;
	}
}
public class Solution {
	public static void main(String[] args) {
		Sorting object = new Sorting();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			object.sort(tokens);
			System.out.println(object.toString(tokens));
			System.out.println();
		}
	}
}