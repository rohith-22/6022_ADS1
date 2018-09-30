import java.util.Scanner;
/**.
 * Queue class for queue implementaion
 */
class Queue {
    /**.
     * size variable
     */
    private int size;
    /**.
     * Node obj creation
     */
    private Node queue;
    /**.
     * Head node creation for referance
     */
    private Node head;
    /**.
     * Node class
     */
    class Node {
        /**.
         * data variable to store the data
         */
        int data;
        /**.
         * Node object to point to the next Node
         */
        Node link;
        /**.
         * Node constructor without arguments
         */
        Node() {
            this.data = 0;
            this.link = null;
        }
        /**.
         * Node constructor with arguments
         *
         * @param      data  The data
         */
        Node(final int data) {
            this.data = data;
            this.link = null;
        }
    }
    /**.
     * Queue constructor
     */
    Queue() {
        queue = new Node();
        size = 0;
    }
    /**.
     * enQueue method to add the element at the head
     *
     * @param      data  The data
     */
    public void enQueue(final int data) {
        if (size == 0) {
            head = new Node(data);
            size++;
            return;
        }
        Node start = new Node(data);
        start.link = head;
        head = start;
        size++;
        return;
    }
    /**.
     * method to remove the element at the end
     *
     * @return     { description_of_the_return_value }
     */
    public int deQueue() {
        Node current = head;
        if (size == 1) {
            size--;
            int n = head.data;
            head = null;
            return current.data;
        }

        int counter = 1;
        while (counter < size - 1) {
            counter++;
            current = current.link;
        }
        int data = current.link.data;
        current.link = null;
        size--;
        return data;
    }
    /**.
     * Checks weather Queue is empty or not
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**.
     * Getter method for sizes
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
}
/**.
 * Solution class
 */
public final class Solution {
    /**.
     * Sollution constructor
     */
    private Solution() {

    }
    /**.
     * main method to handle the testcases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Queue objectQueue = new Queue();
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < input; i++) {
            String[] array = scan.nextLine().split(" ");
            int num = Integer.parseInt(array[0]);
            int pos = Integer.parseInt(array[1]);
            for (int j = 0; j < num; j++) {
                objectQueue.enQueue(j);
            }
            while (!objectQueue.isEmpty() && num != 1) {
                for (int k = 1; k < pos; k++) {
                    objectQueue.enQueue(objectQueue.deQueue());
                }
                System.out.print(objectQueue.deQueue() + " ");
                num--;
            }
            System.out.print(objectQueue.deQueue());
            System.out.println();
        }
    }
}
