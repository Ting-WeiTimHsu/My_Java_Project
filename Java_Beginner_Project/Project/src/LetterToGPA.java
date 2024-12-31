import java.util.Scanner;

public class LetterToGPA
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int Credit_Hours;
        double Sum = 0.0;
        double GPA = 0.0;
        int Total_Credit_Hours = 0;
        double Final_GPA = 0.0;
        int i = 0;
        boolean End = false;

        System.out.println("Please insert the letter grades and credit hours for your four classes below once prompted.");
        String gpatable = "";

        while(!End)
        {
            System.out.print("Enter a letter grade (Capitalized): ");
            String Letter_Grade = in.nextLine();

            System.out.print("Enter the associated credit hours (Integer type): ");
            Credit_Hours = Integer.parseInt(in.nextLine());
            double Credit = Credit_Hours;

            if (!(Letter_Grade.equals("A") || Letter_Grade.equals("A-") || Letter_Grade.equals("B+") || Letter_Grade.equals("B") || Letter_Grade.equals("B-") || Letter_Grade.equals("C+") || Letter_Grade.equals("C") || Letter_Grade.equals("C-") || Letter_Grade.equals("D+") || Letter_Grade.equals("D") || Letter_Grade.equals("E")))
            {
                System.out.println("Invalid input of letter grade. Please try again.");
                End = true;
                break;
            }
            else if(Credit_Hours % 1 != 0)
            {
                System.out.println("Invalid input of credit hours. Please try again.");
                End = true;
                break;
            }
            else
            {
                switch (Letter_Grade)
                {
                    case "A":
                        GPA = 4.0;
                        break;
                    case "A-":
                        GPA = 3.7;
                        break;
                    case "B+":
                        GPA = 3.3;
                        break;
                    case "B":
                        GPA = 3.0;
                        break;
                    case "B-":
                        GPA = 2.7;
                        break;
                    case "C+":
                        GPA = 2.3;
                        break;
                    case "C":
                        GPA = 2.0;
                        break;
                    case "C-":
                        GPA = 1.7;
                        break;
                    case "D+":
                        GPA = 1.3;
                        break;
                    case "D":
                        GPA = 1.0;
                        break;
                    default:
                        GPA = 0.0;
                        break;
                }
                Sum += GPA * Credit;
                Total_Credit_Hours += Credit_Hours;
                gpatable += String.format("%.1f\t|\t%.1f%n", GPA, Credit);
            }
            System.out.println();
            System.out.println("GPA\t|\tCredit");
            System.out.println("-------------------");
            System.out.println(gpatable);
            Final_GPA = Sum / Total_Credit_Hours;
            System.out.println("Your Final GPA is: " + Final_GPA);
            System.out.println("Goodbye!");
            break;
        }
    }

}