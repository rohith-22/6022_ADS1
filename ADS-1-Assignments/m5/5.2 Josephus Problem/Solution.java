import java.util.Scanner;
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
            int number = Integer.parseInt(scan.nextLine().split(" ")[0]);
            int position = Integer.parseInt(scan.nextLine().split(" ")[1]);
            for (int j = 0; j < number; j++) {
                objectQueue.enQueue(j);
            }
            while (!objectQueue.isEmpty() && number != 1) {
                for (int k = 1; k < position; k++) {
                    objectQueue.enQueue(objectQueue.deQueue());
                }
                System.out.print(objectQueue.deQueue() + " ");
                number--;
            }
            System.out.print(objectQueue.deQueue());
            System.out.println();
        }
    }
}
