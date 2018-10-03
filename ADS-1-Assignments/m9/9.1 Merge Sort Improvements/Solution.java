import java.util.Scanner;
/**
 * Class for insertion sort.
 */
class InsertionSort {
  /**
   * Constructs the object.
   */
  InsertionSort() {

  }
  /**
   * sorts the given array using insertion sort.
   * Time complexity of this method is O(N^2) because of.
   * nested for loops.
   *
   * @param      list  The list
   * @param      low    The low
   * @param      hi     The higher
   */
  public void insertionSort(final Comparable[] list,
                            final int low, final int hi) {
    Sorting objectSort = new Sorting();
    for (int i = low; i <= hi; i++) {
      for (int j = i; j > low && objectSort.less(list[j],
           list[j - 1]); j--) {
        exchange(list, j, j - 1);
      }
    }
  }
  /**
   * exchange function swaps the elements using the index.
   *
   * @param      array  The array
   * @param      indexOne      indices
   * @param      indexTwo      indices
   */
  public void exchange(final Comparable[] array,
                       final int indexOne, final int indexTwo) {
    Comparable swap = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = swap;
  }

}
/**
 * Class for merge sort.
 */
class MergeSort {
  /**
   * Constructs the object.
   */
  MergeSort() {

  }
  /**
   * this function is used to merge two lists.
   * Time complexity of this function is N because this.
   * function combines two arrays or lists.
   *
   * @param      list     The list
   * @param      newlist  The newlist
   * @param      low      The low
   * @param      mid      The middle
   * @param      hi       The higher
   */
  public void merge(final Comparable[] list,
                    final Comparable[] newlist, final int low,
                    final int mid, final int hi) {
    Sorting objectSort = new Sorting();
    assert objectSort.isSorted(list, low, mid);
    assert objectSort.isSorted(list, mid + 1, hi);

    int i = low, j = mid + 1;
    for (int k = low; k <= hi; k++) {
      if (i > mid) {
        newlist[k] = list[j++];
      } else if (j > hi) {
        newlist[k] = list[i++];
      } else if (objectSort.less(list[j], list[i])) {
        newlist[k] = list[j++];
      } else {
        newlist[k] = list[i++];
      }
    }
    assert objectSort.isSorted(newlist, low, hi);
  }

}
/**
 * Class for sorting.
 */
class Sorting {
  /**
   * This function creats a auxilary array and calls the below.
   * overloaded sort function.
   *
   * @param      array  The array
   */
  public void sort(final Comparable[] array) {
    Comparable[] auxilaryArray = array.clone();
    sort(auxilaryArray, array, 0, array.length - 1);
    assert isSorted(array);
  }
  /**
   * this is a overloaded function.
   * Time complexity of this function is O(NlogN).
   * as this calls
   * merge function and
   * performs reccursion.
   *
   * @param      list     The list
   * @param      newlist  The newlist
   * @param      low      The low
   * @param      hi       The higher
   */
  public void sort(final Comparable[] list,
                   final Comparable[] newlist, final int low, final int hi) {
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
      System.out.println("Array is already sorted. "
                         + "So, skipped the call to merge...");
      return;
    }
    MergeSort objectMergeSort = new MergeSort();
    objectMergeSort.merge(list, newlist, low, mid, hi);
  }
  /**
   * less function gives out the comparisn of given elements.
   *
   * @param      array     The array
   * @param      arrayTwo  The array two
   *
   * @return     returns true or false
   */
  public boolean less(final Comparable array, final Comparable arrayTwo) {
    return array.compareTo(arrayTwo) < 0;
  }
  /**
   * Determines if sorted.
   *
   * @param      array  The array
   *
   * @return     True if sorted, False otherwise.
   */
  public boolean isSorted(final Comparable[] array) {
    return isSorted(array, 0, array.length - 1);
  }
  /**
   * Determines if sorted.
   *
   * @param      array  The array
   * @param      low    The low
   * @param      hi     The higher
   *
   * @return     True if sorted, False otherwise.
   */
  public boolean isSorted(final Comparable[] array,
                          final int low, final int hi) {
    for (int i = low + 1; i <= hi; i++) {
      if (less(array[i], array[i - 1])) {
        return false;
      }
    }
    return true;
  }
  /**
   * Returns a string representation of the object.
   *
   * @param      array  The array
   *
   * @return     String representation of the object.
   */
  public Object toString(final Object[] array) {
    String s = "[";
    int i;
    for (i = 0; i < array.length - 1; i++) {
      s += array[i] + ", ";
    }
    s = s + array[array.length - 1] + "]";
    return s;
  }
}
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function to handle input and output.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
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
