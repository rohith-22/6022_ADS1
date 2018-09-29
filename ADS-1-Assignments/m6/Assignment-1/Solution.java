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
    if (head == null) {
      // System.out.println("entered");
      node.data = e;
      node.next = null;
      head = node;
      size++;
      return;
    } else {
      // System.out.println("bye");
      node.data = e;
      node.next = head;
      head = node;
      size++;
    }
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
      str += list.pop();
    }
    return str;
  }

  public  LinkedList addLargeNumbers(LinkedList list1,
                                     LinkedList list2) {
    return null;
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
