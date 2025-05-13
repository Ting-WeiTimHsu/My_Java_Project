
/**
 * BarChartScoreboard
 *
 * @author Tim Hsu
 * @version October 18, 2024
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BarChartScoreboard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // create list
        ArrayList<Integer> score = new ArrayList<Integer>();
        ArrayList<String> player_name = new ArrayList<String>();

        System.out.print("Enter the number of players: "); // prompt the payer numbers from the user
        int num_players = Integer.parseInt(in.nextLine());

        if (num_players == 0) // determine if player numbers is 0
        {
            System.out.println("No players to display?  Goodbye!");
        } else {
            for (int i = 1; i <= num_players; i++) {
                System.out.printf("Enter a player name: ");
                player_name.add(in.nextLine());
                System.out.printf("Enter the score for %s: %n", player_name.get(i - 1));
                score.add(Integer.parseInt(in.nextLine()));
            }
        }

        int max = score.get(0); // get the max scores
        for (int k = 1; k < score.size(); k++) {
            if (score.get(k) > max) {
                max = score.get(k);
            }
        }

        int maxLength = 0; // find the max length of the object in playername arraylist for formatting
        for (String item : player_name) {
            if (item.length() > maxLength) {
                maxLength = item.length();
            }
        }

        System.out.println("Current Scoreboard"); // print the result
        System.out.println("------------------");
        for (int m = 0; m < num_players; m++) {
            if (player_name.get(m).length() >= 0) {
                System.out.printf("%-" + (maxLength + 1) + "s", player_name.get(m));
            }

            if (score.get(m) > 0) {
                int numStars = (int) ((double) score.get(m) / max * 50);
                for (int n = 0; n < numStars; n++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }
}
