import java.util.Scanner;//import Scanner

public class InsertPhoneFormat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//import Scanner in method

        //input phone number
        System.out.print("Enter a phone number (only number): ");
        String phone_number = in.next();

        //split up phone number into groups
        String Last = phone_number.substring((phone_number.length()-4));
        String Middle = phone_number.substring(3,(phone_number.length()-4));
        String First = phone_number.substring(0,3);

        //concatenate groups of numbers with essential characters
        phone_number = "("+First+")"+" "+Middle+"-"+Last;

        //print new phone number
        System.out.printf("Your phone number is: %s%n", phone_number);
    }

}
