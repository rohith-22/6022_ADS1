import java.util.Scanner;


/**
 * Class for Sort.
 */
class Sort {

    /**.
     * Constructs the object.
     */
    Sort() {

    }
    /**
     *insertion sort function.
     * time complexity for this method is O(N^2).
     * In first for loop and second loop it iterates through the size of array
     *
     * @param      arr  The arguments
     * @param      low  The arguments
     * @param      high  The arguments
     */
    public void insertion(final Comparable[] arr, final int low,
                          final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
    }
    /**
     * swaps the given elements.
     * time complexity of this method is O(1). It swaps the elements only once.
     *
     * @param      arr  The arguments
     * @param      j    The arguments
     * @param      min  The arguments
     */
    public void swap(final Comparable[] arr, final int j, final int min) {
        Comparable temp = arr[j];
        arr[j] = arr[min];
        arr[min] = temp;
    }


    /**.
     * Returns a string representation of the object.
     * time complexity of this method is O(N). It iterates through
     * the array to print all the objects in array.
     *
     * @param      arr   The arr
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[arr.length - 1] + "]";
        return str;
    }
        /**
         * sorts the given data using insertion sort and quick sort.
         * time complexity is O(log N)
         * @param      arr  The arguments
         * @param      low  The arguments
         * @param      high  The arguments
         * @param      cutOff  The arguments
         */
    public void sort(final Comparable[] arr, final int low,
                     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertion(arr, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(arr, low, high);
        System.out.println(toString(arr));
        sort(arr, low, k - 1, cutOff);
        sort(arr, k + 1, high, cutOff);
    }


    /**
     * sort function overloaded.
     * time complexity is O(1)
     * @param      array   The array
     * @param      cutOff  The cut off
     */
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
// time complexity is O(N)

    /**.
     * partition of the given array is done here using the pivot.
     *
     * @param      arr   The arr
     * @param      low   The low
     * @param      high  The high
     *
     * @return     int
     */
    public int partition(final Comparable[] arr,
                         final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(arr[low], arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }


    /**
     * checks the less element and returns boolean.
     * time complexity is O(1)
     *
     * @param      a     comaprable array
     * @param      b     comaprable array
     *
     * @return     true or false.
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}

/**.
 * class Solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**.
     *  main function to handle input and output testcases.
     *
     * @param      args  The arguments
     *
     * time complexity for the main method is N
     * Because there is one for loop.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort objectSort = new Sort();
        int input = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < input; i++) {
            int j = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                objectSort.sort(tokens, j);
                System.out.println(objectSort.toString(tokens));
            }
        }
    }
}
