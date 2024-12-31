import java.util.Scanner; //import Scanner

public class RemovePhoneFormat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//import Scanner in method

        //input phone number
        System.out.print("Enter a phone number: ");
        String phone_number = in.next();

        //replace all characters except digital digits
        String new_phone_number = phone_number.replaceAll("\\D", "");

        //print new phone number
        System.out.printf("Your phone number is: %s", new_phone_number);
        in.close();
    }

}
