import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for team information.
 */
class Team {
    /**
     *   variable name.
     */
    private String name;
    /**
     *   variable wins.
     */
    private int wins;
    /**
     *   variable losses.
     */
    private int losses;
    /**
     *   variable draws.
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      n   string type
     * @param      w   int type
     * @param      l  int type
     * @param      d  int type
     */
    Team(final String n, final int w,
         final int l, final int d) {
        this.name = n;
        this.wins = w;
        this.losses = l;
        this.draws = d;
    }
    /**
     * Gets the team name.
     * complexity O(1)
     * because we are just returing the name.
     * @return     string team name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the no. of team wins.
     * complexity O(1)
     * because we are just returing the no of wins.
     * @return     int
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the no of team losses.
     * complexity O(1)
     * because we are just returing the no of losses.
     * @return     int
     */
    public int getLosses() {
        return this.losses;
    }
    /**
     * Gets the no of draws.
     * complexity O(1)
     * because we are just returing the no of draws.
     * @return     int
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * compare two Team objects
     * respective of their individual parameters.
     * complexity O(1)
     * because just comparing the two element parameters
     * @param      other  Team object
     *
     * @return     boolean
     */
    public boolean compareTo(final Team other) {
        if (this.wins > other.wins) {
            return true;
        }
        if (this.wins == other.wins) {
            if (this.losses < other.losses) {
                return true;
            }
        }
        if (this.wins == other.wins) {
            if (this.losses == other.losses) {
                if (this.draws > other.draws) {
                    return true;
                }
            }
        }
        return false;
    }

}
/**
 * Class for leader object.
 */
class ScoreCard {
    /**
     *  array of Team class objects.
     */
    private Team[] team;
    /**
     *  inr variable size.
     */
    private int size;
    /**
     *  InsertionSort class object objectSort.
     */
    private InsertionSort objectSort;
    /**
     * Constructs the object.
     */
    ScoreCard() {
        final int ten = 10;
        objectSort = new InsertionSort();
        team = new Team[ten];
        size = 0;
    }
    /**
     * adding a object to the Team array.
     * complexity O(1)
     * because we are just adding a element.
     * @param      teamdata  Team object
     */
    public void add(final Team teamdata) {
        team[size] = teamdata;
        size += 1;
    }
    /**
     * size of Team array.
     * complexity O(1)
     * because we are returning the size.
     * @return     int size
     */
    public int size() {
        return size;
    }
    /**
     * sorting the array according the parameters.
     *
     */
    public void teamRanking() {
        team = Arrays.copyOf(team, size);
        team = objectSort.teamSorting(team);
    }
    /**
     * Returns a string representation
     * of the array objects in form of team names.
     * complexity O(N)
     * beacuse we are iterating throughout the array.
     * @return     String
     */
    public String toString() {
        String str = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str += team[i].getName() + ",";
        }
        str += team[i].getName();
        return str;
    }
}
/**
 * Class for sorting.
 */
class InsertionSort {
    /**
     * Constructs the object.
     */
    InsertionSort() {

    }
    /**
     * sorting of the Team array using insertion sort.
     * complexity O(N^2/4)
     * because we are using two lopps, one for and anpther while loop.
     * @param      team  Team objects array.
     *
     * @return     Team objects array.
     */
    public Team[] teamSorting(final Team[] team) {
        for (int i = 1; i < team.length; i++) {
            Team key = team[i];
            int j = i - 1;
            while (j >= 0 && key.compareTo(team[j])) {
                team[j + 1] = team[j];
                j = j - 1;

            }
            team[j + 1] = key;
        }
        return team;
    }
}
/**
 * class Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main program.
     * complexity O(N)
     * because we are taking the input using for loop
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        ScoreCard object = new ScoreCard();
        while (scan.hasNext()) {
            String[] teams = scan.nextLine().split(",");
            object.add(new Team(teams[0],
                                Integer.parseInt(teams[1]),
                                Integer.parseInt(teams[2]),
                                Integer.parseInt(teams[2 + 1])));
        }
        object.teamRanking();
        System.out.println(object.toString());
    }
}
