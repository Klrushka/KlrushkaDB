package consolehandler;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private final static Scanner SCANNER = new Scanner(System.in);
        //TODO exception handler
    public static String[] signUpData() {
        String[] strings = new String[7];

        strings[0] = username();

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





    private static String username(){
        System.out.println("Please enter your username");
        String s = SCANNER.nextLine();

        while (s.isEmpty()){
            System.out.println("Please enter your username....");
            s = SCANNER.nextLine();
        }

        return s;
    }


    private static String firstname(){
        System.out.println("Please enter your firstname");
        String s = SCANNER.nextLine();

        while (s.isEmpty()){
            System.out.println("Please enter your firstname....");
            s = SCANNER.nextLine();
        }

        return s;
    }




    private static String secondname(){
        System.out.println("Please enter your secondname");
        String s = SCANNER.nextLine();

        while (s.isEmpty()){
            System.out.println("Please enter your secondname....");
            s = SCANNER.nextLine();
        }

        return s;
    }


    private static String gender(){
        System.out.println("Please enter your gender (M/W/A(another))");
        String s = SCANNER.nextLine();

        while (s.length() > 1){
            System.out.println("Please enter your gender (M/W/A(another))");
            s = SCANNER.nextLine();
        }

        return s;
    }


    private static String birthday (){

        String s = SCANNER.nextLine();
        Pattern pattern = Pattern.compile("\\d\\d\\d\\d-[0-12]-[0-31]");
        Matcher matcher = pattern.matcher(s);

        while (!matcher.matches()){
            System.out.println("Please check your date.....");
            s = SCANNER.nextLine();
            matcher.reset(s);
        }
        return s;
    }


    private static String mail(){
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









}
