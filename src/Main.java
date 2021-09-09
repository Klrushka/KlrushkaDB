import consolehandler.ConsoleHandler;
import help.Menu;
import models.User;
import servises.DBHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();
        User user = null;

        Scanner scanner = new Scanner(System.in);

        Menu.displayMenu();

        System.out.println("Please enter number");
        int choice = scanner.nextInt();

        //TODO FIX bug with history and login user

        while (choice != 0) {
            switch (choice) {
                case 1:
                    user = dbHandler.signUpUser(ConsoleHandler.signUpData());
                    break;
                case 2:
                    user = dbHandler.login(ConsoleHandler.loginData()[0], ConsoleHandler.loginData()[1]);
                    break;
                case 3:
                    dbHandler.displayTable();
                    break;
                case 4:
                    //TODO add history display
                    break;
                case 5:
                    if (user == null) {
                        System.out.println("Please enter to System\n");
                    } else {
                        user.setLogin(false);
                    }
                    break;
                default: {
                    System.out.println("Please check your value\n");
                }
            }
            Menu.displayMenu();
            System.out.println("Please enter number");
             choice = scanner.nextInt();

        }
    }
}
