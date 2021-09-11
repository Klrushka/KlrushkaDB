import consolehandler.ConsoleHandler;
import help.Menu;
import models.User;
import servises.DBHandler;
import userhistory.History;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();
        User user = null;

        Scanner scanner = new Scanner(System.in);

        Menu.displayMainMenu();

        System.out.println("Please enter number");
        int choice = scanner.nextInt();

        //TODO FIX bug with history and login user

        while (choice != 0) {
            switch (choice) {
                case 1: // sing up
                    user = dbHandler.signUpUser(ConsoleHandler.signUpData());
                    break;
                case 2: // sing in
                    user = dbHandler.login(ConsoleHandler.loginData());
                    break;
                case 3: // display table
                    dbHandler.displayTable();
                    break;
                case 4: // history
                    Menu.displayHistoryMenu();
                    System.out.println("Please enter number: ");
                    int ch = scanner.nextInt();
                    while (ch != 0) {

                        switch (ch) {
                            case 1:
                                if(History.historyCheckLogin(user)){
                                    user.getHistory().displayHistory();
                                }
                                break;
                            case 2:
                                if (History.historyCheckLogin(user)) {
                                    user.getHistory().clearHistory();
                                }
                                break;
                        }


                        Menu.displayHistoryMenu();
                        System.out.println("Please enter number: ");
                        ch = scanner.nextInt();
                    }
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
            Menu.displayMainMenu();
            System.out.println("Please enter number");
            choice = scanner.nextInt();

        }
    }
}
