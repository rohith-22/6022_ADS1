import java.util.Scanner;
/**
 * Class for balanced brackets.
 */
class BalancedBrackets {
  /**
   * variable string.
   */
  private String string;
  /**
   * private variable list.
   */
  private char[] list;
  /**
   * variable size.
   */
  private int size;
  /**
   * Constructs the object.
   *
   * @param      str  The String
   */
  BalancedBrackets(final String str) {
    string = str;
    list = new char[string.length()];
    size = 0;

  }
  /**
   * Determines if balanced.
   *
   * @return     True if balanced, False otherwise.
   */
  public String isBalanced() {
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == '('
          || string.charAt(i) == '{' || string.charAt(i) == '[') {
        list[size++] = string.charAt(i);
      }
      if (size != 0) {
        if (string.charAt(i) == ')') {
          if (list[size - 1] == '(') {
            size--;
          }
        } else if (string.charAt(i) == '}') {
          if (list[size - 1] == '{') {
            size--;
          }
        } else if (string.charAt(i) == ']') {
          if (list[size - 1] == '[') {
            size--;
          }
        }
      }
    }
    if (size == 0) {
      return "YES";
    }
    return "NO";
  }
}

/**
 * class for solution this contains main function.
 */
public final class Solution {
  /**
   * Constructs the object.
   * private constructor.
   */
  private Solution() {

  }
  /**
   * main function to handle input and output.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    for (int i = 0; i < size; i++) {
      // System.out.println("hi");
      BalancedBrackets object = new BalancedBrackets(sc.next());
      // System.out.println("bye");
      System.out.println(object.isBalanced());
    }
  }
}
