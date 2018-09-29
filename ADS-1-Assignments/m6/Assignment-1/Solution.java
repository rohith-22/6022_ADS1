import java.util.Scanner;
class LinkedList {

  private class Node {

    int data;
    Node next;

    Node() {}

    Node(int data) {
      this(data, null);
    }

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node head;
  int size = 0;

  public void push(int e) {
    Node node = new Node();
    node.data = e;
    node.next = head;
    size++;

    if (head == node) {
      head = node;

    }

    head = node;
  }

  public int pop() {
    int data = head.data;
    head = head.next;
    // size --;
    return data;
  }
  public int size() {
    return size;
  }

}
class AddLargeNumbers {

  public  LinkedList numberToDigits(String number) {
    LinkedList object = new LinkedList();
    for (int i = 0; i < number.length(); i++) {
      object.push(Character.getNumericValue(number.charAt(i)));
      // System.out.println(i);
    }
    return object;
  }

  public  String digitsToNumber(LinkedList list) {
    String str = "";
    // System.out.println(list.size());
    for (int i = 0; i < list.size(); i++) {
      // System.out.println(list.pop());
      str = list.pop() + str;
    }
    return str;
  }

  public  LinkedList addLargeNumbers(LinkedList list1,
                                     LinkedList list2) {
    
    LinkedList result = new LinkedList();
    for (int i = 0; i < list1.size(); i++) {
      int sum = 0;
      sum = list1.pop() + list2.pop();

      // if(sum > 10) {
      //   String string = "" + sum;
      //   result.push(Character.getNumericValue(string.charAt(1)));
      //   sum = Character.getNumericValue(string.charAt(0));
      // }
      // else {
      //   sum = 0;
      // }
      result.push(sum);
      // digitsToNumber(result);
    }
    return result;
  }
}

public class Solution {
  public static void main(String[] args) {
    AddLargeNumbers objectAdd = new AddLargeNumbers();
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String p = sc.nextLine();
    String q = sc.nextLine();
    switch (input) {
    case "numberToDigits":
      LinkedList pDigits = objectAdd.numberToDigits(p);
      LinkedList qDigits = objectAdd.numberToDigits(q);
      System.out.println(objectAdd.digitsToNumber(pDigits));
      System.out.println(objectAdd.digitsToNumber(qDigits));
      break;

    case "addLargeNumbers":
      pDigits = objectAdd.numberToDigits(p);
      qDigits = objectAdd.numberToDigits(q);
      LinkedList result = objectAdd.addLargeNumbers(pDigits, qDigits);
      System.out.println(objectAdd.digitsToNumber(result));
      break;
    }
  }

}
