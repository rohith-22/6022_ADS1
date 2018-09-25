import java.util.*;
// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public void open(int row, int col)       // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public int numberOfOpenSites()      	   // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
class Percolation {
	private boolean[][] grid ;
	private int size;
	private int sizeOfGrid;
	private WeightedQuickUnionUF unionFind;
	private int openSitesNumber;
	public Percolation(int size) {
		grid = new boolean[size][size];
		this.size = size;
		unionFind = new WeightedQuickUnionUF(size * size + 2);
		openSitesNumber = 0;
		sizeOfGrid = size * size;
	}
	public void open(int row, int col) {
		if (grid[row][col]) return;
		grid[row][col] = true;
		openSitesNumber++;
		// System.out.println(row + "and" + col);
		if (row - 1 >= 0 && isOpen(row - 1, col)) {
			unionFind.union(getIndex(row, col), getIndex(row - 1, col));
		}
		if (row + 1 < size && isOpen(row + 1, col)) {
			unionFind.union(getIndex(row, col), getIndex(row + 1, col));
		}
		if (col - 1 >= 0 && isOpen(row , col - 1)) {
			unionFind.union(getIndex(row, col), getIndex(row , col - 1));
		}
		if (col + 1 < size && isOpen(row , col + 1)) {
			unionFind.union(getIndex(row, col), getIndex(row , col + 1));
		}
		if (row == 0) {
			unionFind.union(getIndex(row, col), sizeOfGrid);
		}
		if (row == size - 1) {
			unionFind.union(getIndex(row, col), sizeOfGrid + 1);
		}
	}
	public int getIndex(final int row, final int col) {
		return size * row + col;
	}
	public boolean isOpen(final int row, final int col) {
		return grid[row][col];
	}
	// public boolean isFull(int row, int col) {

	// }
	public int numberOfOpenSites() {
		return openSitesNumber;
	}
	public boolean percolates() {
		return unionFind.connected(sizeOfGrid, sizeOfGrid + 1);
	}
}
public class Solution {
	private Solution() {
	}
	public static void main(final String[] args) {
		Scanner sc =  new Scanner(System.in);
		Percolation objectPercolation = new Percolation(sc.nextInt());
		while (sc.hasNext()) {
			objectPercolation.open(sc.nextInt() - 1, sc.nextInt() - 1);
		}
		System.out.println(objectPercolation.percolates());
	}
}