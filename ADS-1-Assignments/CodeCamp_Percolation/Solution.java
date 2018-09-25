import java.util.Scanner;
/**
// public class Percolation {.
//    public Percolation(int n)
// create n-by-n grid, with all sites blocked
//    public void open(int row, int col)
// open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)
// is site (row, col) open?
//    public boolean isFull(int row, int col)
// is site (row, col) full?
//    public int numberOfOpenSites()
// number of open sites
//    public boolean percolates()
// does the system percolate?
// }
*/
/**
 * Class for percolation.
 */
class Percolation {
  /**
   * its a boolean grid.
   */
  private boolean[][] grid;
  /**
   * int size variable.
   */
  private int size;
  /**
   * size of the grid.
   */
  private int sizeOfGrid;
  /**
   * union find is object of WeightedQuickUnionUF.
   */
  private WeightedQuickUnionUF unionFind;
  /**
   * variable to store open counts.
   */
  private int openSitesNumber;
  /**
   * Constructs the object for class percolation.
   *
   * @param      siz  The size
   */
  Percolation(final int siz) {
    grid = new boolean[siz][siz];
    this.size = siz;
    unionFind = new WeightedQuickUnionUF(size * size + 2);
    openSitesNumber = 0;
    sizeOfGrid = size * size;
  }
  /**
   * this function opens the site using the index value.
   *
   * @param      row   The row
   * @param      col   The col
   */
  public void open(final int row, final int col) {
    if (grid[row][col]) {
      return;
    }
    grid[row][col] = true;
    openSitesNumber++;
    // System.out.println(row + "and" + col);
    if (row - 1 >= 0 && isOpen(row - 1, col)) {
      unionFind.union(getIndex(row, col), getIndex(row - 1, col));
    }
    if (row + 1 < size && isOpen(row + 1, col)) {
      unionFind.union(getIndex(row, col), getIndex(row + 1, col));
    }
    if (col - 1 >= 0 && isOpen(row, col - 1)) {
      unionFind.union(getIndex(row, col), getIndex(row, col - 1));
    }
    if (col + 1 < size && isOpen(row, col + 1)) {
      unionFind.union(getIndex(row, col), getIndex(row, col + 1));
    }
    if (row == 0) {
      unionFind.union(getIndex(row, col), sizeOfGrid);
    }
    if (row == size - 1) {
      unionFind.union(getIndex(row, col), sizeOfGrid + 1);
    }
  }
  /**
   * Gets the index of the site.
   *
   * @param      row   The row
   * @param      col   The col
   *
   * @return     returns (int)The index.
   */
  public int getIndex(final int row, final int col) {
    return size * row + col;
  }
  /**
   * Determines if the site is open or not.
   *
   * @param      row   The row
   * @param      col   The col
   *
   * @return     returns True if open, False otherwise.
   */
  public boolean isOpen(final int row, final int col) {
    return grid[row][col];
  }
  /**
   * this function gives the count of open sites.
   *
   * @return     returns the int value.
   */
  public int numberOfOpenSites() {
    return openSitesNumber;
  }
  /**
   * this function checks whether the grid is perculating or not.
   *
   * @return     returns true if grid perculates.
   */
  public boolean percolates() {
    return unionFind.connected(sizeOfGrid, sizeOfGrid + 1);
  }
}
/**
 * Class for solution.
 * contains main function.
 */
public final class Solution {
  /**
   * empty constructor.
   */
  private Solution() {
  }
  /**
   * main function to handle input.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc =  new Scanner(System.in);
    Percolation objectPercolation = new Percolation(sc.nextInt());
    while (sc.hasNext()) {
      objectPercolation.open(sc.nextInt() - 1, sc.nextInt() - 1);
    }
    System.out.println(objectPercolation.percolates());
  }
}
