import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for node.
 */
class Node {
	/**.
     * word.
     */
	String word;
	/**.
	 * link of node
	 */
	Node link = null;
	/**.
	 * Constructs the object.
	 *
	 * @param      d     String
	 */
	public Node (final String d) {
		word = d;
	}
}
/**.
 * Class for linkedlist.
 */
class Linkedlist {
	/**.
	 * head node
	 */
	Node head = null;
	/**.
	 * inasert method
	 *
	 * @param      word  The word
	 */
	public void insert(final String word) {
		Node newnode = new Node(word);
		if (head == null) {
			head = newnode;
		} else {
			Node temp = head;
			head = newnode;
			newnode.link = temp;
		}
	}
}
/**.
 * hashing class
 */
class Hashing {
	/**.
	 * hash  linked list
	 */
	Linkedlist[] hash;
	/**.
	 * size variable
	 */
	int size;
	/**.
	 * method for hashing
	 *
	 * @param      s     { of type int }
	 */
	public Hashing(int s) {
		size = s;
		hash = new Linkedlist[s];
	}
	/**.
	 * key method
	 *
	 * @param      value  The value
	 *
	 * @return     { int }
	 */
	public int key(String value) {
		return Math.abs(value.hashCode() % size);
	}
	/**.
	 * insert method with word ans position
	 *
	 * @param      word  The word
	 * @param      pos   The position
	 */
	public void insert(String word, int pos) {

		if (hash[pos] == null) {
			Linkedlist l = new Linkedlist();
			l.insert(word);
			hash[pos] = l;
		} else {
			hash[pos].insert(word);
		}
	}
	/**.
	 * Gets the hash.
	 *
	 * @return     The hash.
	 */
	public Linkedlist[] getHash() {
		return hash;
	}
}
/**.
 * class for ransom note
 */
class RansomNote {
	/**.
	 * variable for msize
	 */
	int msize;
	/**.
	 * vairable for note size
	 */
	int nsize;
	/**.
	 * array for mag words
	 */
	String[] mag;
	/**.
	 * array for note words
	 */
	String[] note;
	/**.
	 * variable for hasing
	 */
	Hashing h;
	/**.
	 * constructor
	 *
	 * @param      ms    mag size
	 * @param      ns    { note size }
	 * @param      m     { mag words }
	 * @param      n     { note words }
	 */
	public RansomNote(final int ms, final int ns, final String[] m, final String[] n) {
		msize = ms;
		nsize = ns;
		mag = m;
		note = n;
		h = new Hashing(msize);
	}
	/**.
	 * method to create the hash Map
	 */
	public void creatingHashmap() {
		for (int i = 0; i < msize; i++) {
			int pos = h.key(mag[i]);
			h.insert(mag[i], pos);
		}
	}
	/**.
	 * method to check
	 */
	public void checking() {
		for (int i = 0; i < nsize; i++) {
			int pos = h.key(note[i]);
			Linkedlist[] hashtable = h.getHash();
			if (hashtable[pos] == null) {
				System.out.println("No");
				return;
			} else {
				Node temp = hashtable[pos].head;
				int f = 1;
				if (temp.word.equals(note[i])) {
					f = 0;
					temp = temp.link;
					continue;
				} else {
					while (temp.link != null) {
						if (temp.link.word.equals(note[i])) {
							f = 0;
							temp.link = temp.link.link;
							break;
						} else {
							temp = temp.link;
						}
					}
				}
				if (f == 1) {
					System.out.println("No");
					return;
				}
			}
		}
		System.out.println("Yes");
	}

}
/**
 * Solution class
 */
class Solution {
	/**
	 * main method
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int msize = sc.nextInt();
		int nsize = sc.nextInt();
		sc.nextLine();
		String[] mag = sc.nextLine().split(" ");
		String[] note = sc.nextLine().split(" ");
		RansomNote r = new RansomNote(msize, nsize, mag, note);
		r.creatingHashmap();
		r.checking();
	}
}