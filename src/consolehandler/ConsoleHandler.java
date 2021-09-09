package consolehandler;

import java.util.Scanner;

public class ConsoleHandler {
    private final static Scanner SCANNER = new Scanner(System.in);
        //TODO exception handler
    public static String[] signUpData() {
        String[] strings = new String[7];
        System.out.println("Please enter your username");
        strings[0] = SCANNER.nextLine();

        System.out.println("Please enter your firstname");
        strings[1] = SCANNER.nextLine();

        System.out.println("Please enter your secondname");
        strings[2] = SCANNER.nextLine();

        System.out.println("Please enter your gender (M/W)");
        strings[3] = SCANNER.nextLine();

        System.out.println("Please enter your birthday(yyyy-mm-dd)");
        strings[4] = SCANNER.nextLine();

        System.out.println("Please enter your mail");
        strings[5] = SCANNER.nextLine();

        System.out.println("Please enter your password");
        strings[6] = SCANNER.nextLine();

        return strings;
    }




    public static String[] loginData (){
        String[] strings = new String[2];

        System.out.println("Please enter your login");
        strings[0] = SCANNER.nextLine();

        System.out.println("Please enter your password");
        strings[1] = SCANNER.nextLine();

        return strings;
    }
}
