package consolehandler;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static String[] signUpData() {
        String[] strings = new String[7];

        strings[0] = username();


        strings[1] = firstname();


        strings[2] = secondname();


        strings[3] = gender();


        strings[4] = birthday();


        strings[5] = mail();


        strings[6] = password();

        return strings;
    }




    public static String[] loginData (){
        String[] strings = new String[2];

        strings[0] = username();

        strings[1] = password();

        return strings;
    }





    private static String username(){
        System.out.println("Please enter your username");
        String s = SCANNER.nextLine();

        while (s.isEmpty()){
            System.out.println("Please check your username....");
            s = SCANNER.nextLine();
        }

        return s;
    }


    private static String firstname(){
        System.out.println("Please enter your firstname");
        String s = SCANNER.nextLine();

        while (s.isEmpty()){
            System.out.println("Please check your firstname....");
            s = SCANNER.nextLine();
        }

        return s;
    }




    private static String secondname(){
        System.out.println("Please enter your secondname");
        String s = SCANNER.nextLine();

        while (s.isEmpty()){
            System.out.println("Please check your secondname....");
            s = SCANNER.nextLine();
        }

        return s;
    }


    private static String gender(){
        System.out.println("Please enter your gender (M/W/A(another))");
        String s = SCANNER.nextLine();

        while (s.length() > 1){
            System.out.println("Please check your gender (M/W/A(another))");
            s = SCANNER.nextLine();
        }

        return s;
    }


    private static String birthday (){
        System.out.println("Please enter your birthday(yyyy-mm-dd).....");
        String s = SCANNER.nextLine();
        Pattern pattern = Pattern.compile("^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(s);

        while (!matcher.matches()){
            System.out.println("Please check(yyyy-mm-dd) your date.....");
            s = SCANNER.nextLine();
            matcher.reset(s);
        }
        return s;
    }


    private static String mail(){
        System.out.println("Please enter your mail.....");
        String s = SCANNER.nextLine();
        Pattern pattern = Pattern.compile(".*@.*\\..*");
        Matcher matcher = pattern.matcher(s);

        while (!matcher.matches()){
            System.out.println("Please check your mail.....");
            s = SCANNER.nextLine();
            matcher.reset(s);
        }
        return s;
    }

    private static String password(){
        System.out.println("Please enter your password");
        String s = SCANNER.nextLine();

        while (s.isEmpty()){
            System.out.println("Please enter your password....");
            s = SCANNER.nextLine();
        }

        return s;
    }









}
