
/**
 * TrajectoryModeling
 *
 * @author Tim Hsu
 * @version 10/06/2024
 **/

import java.util.Scanner;

public class TrajectoryModeling {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a distance to target: "); // Prompt the user for the target distance and declare the
                                                          // essential variables
        double Target_Distance = Double.parseDouble(in.nextLine());
        double g = 9.8;
        double time;
        double distance;
        double velocity;
        double guess = 1000.0;
        double Best_angle = 0;
        double Best_speed = 0;
        double missed = 0;

        System.out.println();

        for (velocity = 1; velocity <= 30; velocity++) // comparing the calculated distance to the target distance
        {
            for (double angle = 25; angle <= 90; angle += 5) {
                double cos = Math.cos(Math.toRadians(angle));
                double sin = Math.sin(Math.toRadians(angle));

                time = (2 * velocity * sin) / g;
                distance = velocity * time * cos;

                if (Math.abs(distance - Target_Distance) < Math.abs(guess - Target_Distance)) // find the closest
                                                                                              // distance to the target
                                                                                              // distance
                {
                    guess = distance;
                    Best_angle = angle;
                    Best_speed = velocity;
                    missed = Math.abs(guess - Target_Distance);
                }
            }
        }
        System.out.format("Best angle: %.2f%n", Best_angle); // print out the information tht is closest to the target
                                                             // distance
        System.out.format("Best speed: %.2f%n", Best_speed);
        System.out.format("Distance travelled: %.2f%n", guess);
        System.out.format("Missed the target center by: %.2f%n", missed);
    }

}
