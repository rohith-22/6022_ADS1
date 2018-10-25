import java.util.Scanner;
import java.util.Arrays;
class Node {
	String word;
	Node link = null;
	public Node (String d) {
		word = d;
	}
}
class Linkedlist {
	Node head = null;
	public void insert(String word) {
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
class Hashing {
	Linkedlist[] hash;
	int size;
	public Hashing(int s) {
		size = s;
		hash = new Linkedlist[s];
	}
	public int key(String value) {
		return Math.abs(value.hashCode() % size);
	}
	public void insert(String word, int pos) {

		if (hash[pos] == null) {
			Linkedlist l = new Linkedlist();
			l.insert(word);
			hash[pos] = l;
		} else {
			hash[pos].insert(word);
		}
	}
	public Linkedlist[] getHash() {
		return hash;
	}
}
class RansomNote {
	int msize;
	int nsize;
	String[] magazine;
	String[] note;
	Hashing h;
	public RansomNote(int ms, int ns, String[] m, String[] n) {
		msize = ms;
		nsize = ns;
		magazine = m;
		note = n;
		h = new Hashing(msize);
	}
	 
	public void creatingHashmap() {
		for (int i = 0; i < msize; i++) {
			int pos = h.key(magazine[i]);
			h.insert(magazine[i], pos);
		}
	}
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
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int msize = sc.nextInt();
		int nsize = sc.nextInt();
		sc.nextLine();
		String[] magazine = sc.nextLine().split(" ");
		String[] note = sc.nextLine().split(" ");
		RansomNote r = new RansomNote(msize, nsize, magazine, note);
		r.creatingHashmap();
		r.checking();
	}
}