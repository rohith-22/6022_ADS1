import java.util.Scanner;

class CubeSum implements Comparable<CubeSum> {

    private final int sum;

    private final int first;
    private final int second;
    CubeSum(final int firstNumber, final int secondNumber) {
        sum = firstNumber * firstNumber * firstNumber
                   + secondNumber * secondNumber * secondNumber;
        first = firstNumber;
        second = secondNumber;
    }
    public int getSum() {
        return sum;
    }
    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int compareTo(final CubeSum other) {
        if (sum < other.sum) {
            return -1;
        }
        if (sum > other.sum) {
            return +1;
        }

        return 0;
    }

    public String toString() {
        return sum + " = " + first + "^3" + " + " + second + "^3";
    }



}

final class Solution {



    private Solution() {

    }

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        int counter = 0;
        final int limit = 600;
        int nthNumber = Integer.parseInt(tokens[0]);
        int combinations = Integer.parseInt(tokens[1]);
        int tempSum = -1;

        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= limit; i++) {
            pq.insert(new CubeSum(i, i));
        }

        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (tempSum == s.getSum()) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == combinations - 1) {
                nthNumber--;
                if (nthNumber == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }

            tempSum = s.getSum();
            if (s.getSecond() < limit) {
                pq.insert(new CubeSum(
                              s.getFirst(), s.getSecond() + 1));
            }
        }
    }

}