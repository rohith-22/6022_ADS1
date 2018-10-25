import java.util.Scanner;
/**.
 * Class for node.
 */
class Node {
    /**
     * word.
     */
    private String word;
    /**.
     * link of node
     */
    private Node link = null;
    /**
     * count of words.
     */
    private int count = 1;
    /**.
     * Constructs the object.
     *
     * @param      d     String
     */
    Node(final String d) {
        word = d;
    }
    /**
     * Gets the word.
     *
     * @return     The word.
     */
    public String getWord() {
        return this.word;
    }
    /**
     * Gets the link.
     *
     * @return     The link.
     */
    public Node getLink() {
        return this.link;
    }
    /**
     * Sets the link.
     *
     * @param      n     new link
     */
    public void setLink(final Node n) {
        this.link = n;
    }
    /**
     * Gets the count.
     *
     * @return     The count.
     */
    public int getCount() {
        return this.count;
    }
    /**
     * Sets the count.
     *
     * @param      c     new count
     */
    public void setCount(final int c) {
        this.count = c;
    }
}
/**.
 * Class for linkedlist.
 */
class Linkedlist {
    /**.
     * head node
     */
    private Node head = null;
    /**
     * Gets the head.
     *
     * @return     The head.
     */
    public Node getHead() {
        return head;
    }
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
            int f = 0;
            while (temp != null) {
                if (temp.getWord().equals(word)) {
                    f = 1;
                    temp.setCount(temp.getCount() + 1);
                    break;
                } else {
                    temp = temp.getLink();
                }
            }
            if (f == 0) {
                newnode.setLink(head);
                head = newnode;
            }
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
    private Linkedlist[] hash;
    /**.
     * size variable
     */
    private int size;
    /**.
     * method for hashing
     *
     * @param      s     size
     */
    Hashing(final int s) {
        size = s;
        hash = new Linkedlist[s];
    }
    /**.
     * key method
     *
     * @param      value  The value
     *
     * @return     int
     */
    public int key(final String value) {
        return Math.abs(value.hashCode() % size);
    }
    /**.
     * insert method with word ans position
     *
     * @param      word  The word
     * @param      pos   The position
     */
    public void insert(final String word, final int pos) {

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
    private int msize;
    /**.
     * vairable for note size
     */
    private int nsize;
    /**.
     * array for mag words
     */
    private String[] mag;
    /**.
     * array for note words
     */
    private String[] note;
    /**.
     * variable for hasing
     */
    private Hashing h;
    /**.
     * constructor
     *
     * @param      ms    mag size
     * @param      ns    { note size }
     * @param      m     { mag words }
     * @param      n     { note words }
     */
    RansomNote(final int ms, final int ns,
        final String[] m, final String[] n) {
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
                Node temp = hashtable[pos].getHead();
                int f = 1;
                if (temp.getWord().equals(note[i])) {
                    f = 0;
                    temp = temp.getLink();
                    continue;
                } else {
                    while (temp.getLink() != null) {
                        if (temp.getLink().getWord(
                            ).equals(
                            note[i])) {
                            f = 0;
                            temp.setLink(
                                temp.getLink(
                                    ).getLink());
                            break;
                        } else {
                            temp = temp.getLink();
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
/**.
 * Solution class
 */
final class Solution {
    /**.
     * constructor
     */
    private Solution() {
        //Constructor
    }
    /**.
     * main method
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
