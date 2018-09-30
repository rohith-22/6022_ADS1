/**.
 * Queue class for queue implementaion
 */
public class Queue {
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
	public int deQueue(){
		Node current = head;
		if (size == 1) {
			size--;
			int n = head.data;
			head = null;
			return current.data;
		}
		
		int counter = 1;
		while (counter<size-1) {
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
	public int getSize(){
		return size;
	}
}