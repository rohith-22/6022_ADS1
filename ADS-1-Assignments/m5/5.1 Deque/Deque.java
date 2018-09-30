/**
 * Dequeue class for the implimentaion of dequeue
 *
 * @param      <E>   { Generic }
 */
public class Deque<E>{
	/**.
	 * Size variable
	 */
	int size;
	/**.
	 * Object for linked list 
	 */
	LinkedList<E> linkedQueue;
	Deque(){
		linkedQueue = new LinkedList<E>();
		size =0;
	}
	/**.
	 * is empty method to check weather dequeqe is empty or not
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	/**.
	 * Size method to know the size
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size(){
		return size;
	}
	/**.
	 * Push left method to put the element at the left end
	 *
	 * @param      item  The item
	 */
	public void pushLeft(final E item){
		linkedQueue.addAtStart(item);
		size++;
		linkedQueue.print();
	}
	/**.
	 * push right method to push the element in right end
	 *
	 * @param      item  The item
	 */
	public void pushRight(final E item){
		linkedQueue.addAtEnd(item);
		size++;
		linkedQueue.print();
	}
	/**.
	 * remove the elemenet from left end
	 */
	public void popLeft(){
		if(size==0){
			System.out.println("Deck is empty");
			return;
		}
		size--;
		linkedQueue.removeAtStart();
		if(linkedQueue.getSize()==0) {
			System.out.println("[]");
			return;
		}
		linkedQueue.print();
	}
	/**.
	 * removing from right end;
	 */
	public void popRight(){
		if(size==0){
			System.out.println("Deck is empty");
			return;
		}
		size--;
		linkedQueue.removeAtEnd();
		if(linkedQueue.getSize()==0) {
			System.out.println("[]");
			return;
		}
		linkedQueue.print();
	}



}