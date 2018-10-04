import java.util.Scanner;
class LinkedList {

  private class Node {

    int data;
    Node next;

    Node() {}


    Node(int data) {
      this.data = data;
      this.next = next;
    }
  }

  private Node head;
  private Node tail;
  private int size;
  LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  public void insertAt(int index, int value) throws Exception {

    if (index < 0 || index >= size) {
      throw new Exception ("Can't insert at this position.");
    }
    head = insertAt(head, new Node(value), index, 0);
    size++;
  }
  private Node insertAt(Node curr, Node newNode, int index, int currIndex) {
    if (curr == null) {
      return newNode;
    } else if (currIndex == index) {
      newNode.next = curr;
      return newNode;
    }

    curr.next = insertAt(curr.next, newNode, index, currIndex + 1);
    return curr;

  }

  public void reverse() throws Exception {
    if (size == 0) {
      throw new Exception("No elements to reverse.");
    }
    reverse(head, null);

  }
  private Node reverse(Node curr, Node prev) {



    if (curr.next == null) {
      head = curr;
      head.next = prev;
      return null;
    }

    Node temp = curr.next;
    curr.next = prev;

    reverse(temp, curr);
    return head;
  }
  public void display(){
    Node curr = head;
    String result = "";
    while(curr!=null){
      if(curr.next == null){
        result += curr.data;
      }
      else{
        result += curr.data+", ";
      }
      curr = curr.next;
    }

    System.out.println(result);
  }
}
public class Solution {

  public static void main(String[] args) {
    LinkedList object = new LinkedList();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String[] tokens = sc.nextLine().split(" ");
      switch (tokens[0]) {
      case "insertAt" :
        try {
          object.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
          object.display();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      case "reverse":
        try {
          object.reverse();
          object.display();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
