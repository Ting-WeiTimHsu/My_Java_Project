
/**
 * SubstitutionCipher
 * @author Tim Hsu
 * @version 11/24/2024
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class SubstitutionCipher {

    /**
     * Private constants used to shift characters for the substitution cipher.
     */
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constructs a new String where each letter in the String input is shifted
     * by the amount shift to the right, preserving whether the original
     * character was uppercase or lowercase. For example, the String "ABC" with
     * shift 3 would cause this method to return "DEF". A negative value should
     * shift to the left. For example, the String "ABC" with shift -3 would
     * cause this method to return "XYZ". Punctuation, numbers, whitespace and
     * other non-letter characters should be left unchanged. NOTE: For full
     * credit you are REQUIRED to use a StringBuilder to build the String in
     * this method rather than using String concatenation.
     *
     * @param input
     *              String to be encrypted
     * @param shift
     *              Amount to shift each character of input to the right
     * @return the encrypted String as outlined above
     */
    public static String shift(String input, int shift) { // shifting method using upper case and lower case set
        StringBuilder sb = new StringBuilder();
        char encode;
        int original;
        for (int i = 0; i < input.length(); i++) // within the input length, decide whether it is upper case
        { // or lower case and shift with the input value
            if (!Character.isLetter(input.charAt(i))) {
                sb.append(input.charAt(i));
            } else {
                if (Character.isUpperCase(input.charAt(i))) {
                    original = UPPERCASE.indexOf(input.charAt(i));
                    encode = UPPERCASE.charAt((original + shift + 26) % 26); // keep the value to the positive
                    sb.append(encode);
                } else {
                    original = LOWERCASE.indexOf(input.charAt(i));
                    encode = LOWERCASE.charAt((original + shift + 26) % 26);
                    sb.append(encode);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Displays the message "promptMsg" to the user and reads the next full line
     * that the user enters. If the user enters an empty string, reports the
     * error message "ERROR! Empty Input Not Allowed!" and then loops,
     * repeatedly prompting them with "promptMsg" to enter a new string until
     * the user enters a non-empty String
     *
     * @param in
     *                  Scanner to read user input from
     * @param promptMsg
     *                  Message to display to user to prompt them for input
     * @return the String entered by the user
     */
    public static String promptForString(Scanner in, String promptMsg) { // prompt the user until they enter
        String userInput = ""; // the value that isn't empty
        boolean haveinput = false;
        while (!haveinput) {
            System.out.print(promptMsg);
            userInput = in.nextLine();
            if (!userInput.trim().isEmpty()) {
                haveinput = true;
            } else {
                System.out.println("ERROR! Empty Input Not Allowed!");
            }
        }
        return userInput;
    }

    /**
     * Opens the file inFile for reading and the file outFile for writing,
     * reading one line at a time from inFile, shifting it the number of
     * characters given by "shift" and writing that line to outFile. If an
     * exception occurs, must report the error message: "ERROR! File inFile not
     * found or cannot write to outFile" where "inFile" and "outFile" are the
     * filenames given as parameters.
     *
     * @param inFile
     *                the file to be transformed
     * @param outFile
     *                the file to write the transformed output to
     * @param shift
     *                the amount to shift the characters from inFile by
     * @return false if an exception occurs and the error message is written,
     *         otherwise true
     */
    public static boolean transformFile(String inFile, String outFile, int shift) { // transform the file
        try { // whether it is decode or encode and then catch the errors
            Scanner reader = new Scanner(new File(inFile));
            PrintWriter writer = new PrintWriter(new FileWriter(outFile));

            while (reader.hasNext()) {
                String line = reader.nextLine();
                String transformedLine = shift(line, shift);
                writer.println(transformedLine);
            }
            reader.close(); // close the scanner and writer
            writer.close();
            return true;
        } catch (FileNotFoundException e) { // catch the exception
            System.out.println("ERROR! File inFile not found");
        } catch (IOException i) {
            System.out.println("ERROR! Cannot write to outFile");
        }
        return false;
    }

    /**
     * Prompts the user to enter a single character choice. The only allowable
     * values are 'E', 'D' or 'Q'. All other values are invalid, including all
     * values longer than one character in length, however the user is allowed
     * to enter values in either lower or upper case. If the user enters an
     * invalid value, the method displays the error message "ERROR! Enter a
     * valid value!" and then prompts the user repeatedly until a valid value is
     * entered. Returns a single uppercase character representing the user's
     * choice.
     *
     * @param in
     *           Scanner to read user choices from
     * @return the user's choice as an uppercase character
     */
    public static char getChoice(Scanner in) { // get the choice from the user whether they want to encode or decode or
                                               // quit the file
        boolean validinput = false;
        String choice = "";
        while (!validinput) {
            System.out.print("Enter your choice: ");
            choice = in.nextLine().trim().toUpperCase();
            if (choice.equals("E") || choice.equals("D") || choice.equals("Q")) {
                validinput = true;
            }
        }
        return choice.charAt(0);
    }

    /**
     * Displays the menu of choices to the user.
     */
    public static void displayMenu() {
        System.out.println("[E]ncode a file");
        System.out.println("[D]ecode a file");
        System.out.println("[Q]uit");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) { // keep prompting until the user type Q
            displayMenu();
            char choice = getChoice(in);

            if (choice == 'Q') {
                System.out.println();
                System.out.println("Goodbye!");
                break;
            }

            String inFile = promptForString(in, "Enter an input file: "); // ask for input and output file name
            String outFile = promptForString(in, "Enter an output file: ");
            int shift = 0;

            if (choice == 'E') { // decide whether it is encode or decode and then do the action
                shift = Integer.parseInt(promptForString(in, "Enter a shift amount: "));
            } else if (choice == 'D') {
                shift = -Integer.parseInt(promptForString(in, "Enter a shift amount: "));
            }

            if (transformFile(inFile, outFile, shift)) { // print the prompt when the file is succesfully encode or
                                                         // decode
                System.out.println("Finished writing to file.");
                System.out.println();
            }

        }
        in.close();
    }

}
