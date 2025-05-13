
/**
 * InsertComma
 * @author Tim Hsu
 * @version 20240906
 */
import java.util.Scanner;//import Scanner

public class InsertComma {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);// import Scanner in method

        // input number
        System.out.print("Enter a comma-free number: ");
        String number = in.next();

        // split the number in the right place
        String Last = number.substring((number.length() - 3));
        String First = number.substring(0, (number.length() - 3));

        // concatenate the number with commas in the right place
        number = First + ',' + Last;

        // print number with the commas
        System.out.printf("Number with comma is: %s%n", number);
        in.close();
    }

}
