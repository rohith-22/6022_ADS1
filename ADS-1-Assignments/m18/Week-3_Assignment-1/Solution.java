import java.util.Scanner;
// import java.util.Comparator;

/**
 * Class for stock exchange.
 */
class StockExchange implements Comparable<StockExchange> {
  /**
   * variable nameofcompany.
   */
  private String nameOfCompany;
  /**
   * variable percentage.
   */
  private Double percentChange;
  /**
   * Constructs the object.
   *
   * @param      name        The name
   * @param      percentage  The percentage
   */
  StockExchange(final String name, final Double percentage) {
    nameOfCompany = name;
    percentChange = percentage;
  }
  /**
   * compare to method.
   *
   * @param      that  The that
   *
   * @return     int
   */
  public int compareTo(final StockExchange that) {
    if (percentChange > that.percentChange) {
      return 1;
    }
    if (percentChange < that.percentChange) {
      return -1;
    }
    if (nameOfCompany.compareTo(that.nameOfCompany) > 0) {
      return 1;
    }
    if (nameOfCompany.compareTo(that.nameOfCompany) < 0) {
      return -1;
    } else {
      return 0;
    }
  }

  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return nameOfCompany + " " + percentChange;
  }
}
/**
 * main solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function to handle input and output testcases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);

    int numberOfInputs = Integer.parseInt(sc.nextLine());
    final int five = 5;
    /**
     * 9 o clock
     */
    MinPQ<StockExchange> minPqObj1 = new MinPQ<>();
    MaxPQ<StockExchange> maxPqObj1 = new MaxPQ<>();
    for (int j = 0; j < numberOfInputs; j++) {
      String[] tokens = sc.nextLine().split(",");
      minPqObj1.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
      maxPqObj1.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));

    }
    printObjectMin(minPqObj1);
    for (int i = 0; i < five; i++) {
      System.out.println(minPqObj1.delMin());
    }
    System.out.println();

    MinPQ<StockExchange> minPqObj2 = new MinPQ<>();
    MaxPQ<StockExchange> maxPqObj2 = new MaxPQ<>();

    /**
     * 10 o clock
     */
    for (int j = 0; j < numberOfInputs; j++) {
      String[] tokens = sc.nextLine().split(",");
      minPqObj2.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
      maxPqObj2.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
    }
    printObjectMin(minPqObj2);
    for (int i = 0; i < five; i++) {
      System.out.println(minPqObj2.delMin());
    }
    System.out.println();
    /**
     * 11 o clock
     */
    MinPQ<StockExchange> minPqObj3 = new MinPQ<>();
    MaxPQ<StockExchange> maxPqObj3 = new MaxPQ<>();
    for (int j = 0; j < numberOfInputs; j++) {
      String[] tokens = sc.nextLine().split(",");
      minPqObj3.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
      maxPqObj3.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
    }
    for (int i = 0; i < five; i++) {
      System.out.println(maxPqObj3.delMax());
    }
    System.out.println();
    for (int i = 0; i < five; i++) {
      System.out.println(minPqObj3.delMin());
    }
    System.out.println();
    /**
     * 12 o clock
     */
    MinPQ<StockExchange> minPqObj4 = new MinPQ<>();
    MaxPQ<StockExchange> maxPqObj4 = new MaxPQ<>();
    for (int j = 0; j < numberOfInputs; j++) {
      String[] tokens = sc.nextLine().split(",");
      minPqObj4.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
      maxPqObj4.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
    }
    for (int i = 0; i < five; i++) {
      System.out.println(maxPqObj4.delMax());
    }
    System.out.println();
    for (int i = 0; i < five; i++) {
      System.out.println(minPqObj4.delMin());
    }
    System.out.println();
    /**
         * 13 o clock
         */
    MinPQ<StockExchange> minPqObj5 = new MinPQ<>();
    MaxPQ<StockExchange> maxPqObj5 = new MaxPQ<>();
    for (int j = 0; j < numberOfInputs; j++) {
      String[] tokens = sc.nextLine().split(",");
      minPqObj5.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
      maxPqObj5.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
    }
    for (int i = 0; i < five; i++) {
      System.out.println(maxPqObj5.delMax());
    }
    System.out.println();
    for (int i = 0; i < five; i++) {
      System.out.println(minPqObj5.delMin());
    }
    System.out.println();
    /**
     * 14 o clock
     */
    MinPQ<StockExchange> minPqObj6 = new MinPQ<>();
    MaxPQ<StockExchange> maxPqObj6 = new MaxPQ<>();
    for (int j = 0; j < numberOfInputs; j++) {
      String[] tokens = sc.nextLine().split(",");
      minPqObj6.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
      maxPqObj6.insert(new StockExchange(tokens[0],
                                         Double.parseDouble(tokens[1])));
    }
    for (int i = 0; i < five; i++) {
      System.out.println(maxPqObj6.delMax());
    }
    System.out.println();
    for (int i = 0; i < five; i++) {
      System.out.println(minPqObj6.delMin());
    }
    System.out.println();

  }
  public static void printObjectMin(MinPQ<StockExchange> object) {
    final int five = 5;
    for (int i = 0; i < five; i++) {
      System.out.println(object.delMin());
    }
    System.out.println();
  }
}
