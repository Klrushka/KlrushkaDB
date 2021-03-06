import consolehandler.ConsoleHandler;
import editors.InformationEditor;
import enums.help.EditAccountValues;
import enums.help.MenuValues;
import help.Menu;
import models.User;
import servises.HistoryService;
import servises.UserServices;
import userhistory.History;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserServices userServices = new UserServices();
        User user = null;


        Scanner scanner = new Scanner(System.in);

        Menu.displayMainMenu();

        System.out.println("Please enter number");
        int choice = scanner.nextInt();


        while (choice != 0) {
            switch (choice) {
                case 1: // sing up
                    user = userServices.signUpUser(ConsoleHandler.signUpData());
                    break;
                case 2: // sing in
                    user = userServices.login(ConsoleHandler.loginData());
                    break;
                case 3: // display table
                    userServices.displayTable();
                    break;
                case 4: // history
                    Menu.displayHistoryMenu();
                    System.out.println("Please enter number: ");
                    int ch = scanner.nextInt();
                    while (ch != 0) {

                        switch (ch) {
                            case 1: // display user history
                                if (History.historyCheckLogin(user)) {
                                    user.getHistory().displayHistory();
                                }
                                break;
                            case 2: // clean user
                                if (History.historyCheckLogin(user)) {
                                    user.getHistory().clearHistory();
                                }
                                break;
                            default:
                                System.out.println("Please check your choice...");
                                break;
                        }


                        Menu.displayHistoryMenu();
                        System.out.println("Please enter number: ");
                        ch = scanner.nextInt();
                    }
                    break;
                case 5: // logout user
                    if (user == null) {
                        System.out.println("Please enter to System\n");
                    } else {
                        HistoryService.addActionToHistory(user, MenuValues.LOGOUT.getValue());
                        user.setLogin(false);
                    }
                    break;

                case 6: // account menu
                    Menu.displayMyAccountMenu();
                    System.out.println("Please enter number: \n");
                    ch = scanner.nextInt();

                    while (ch != 0) {

                        switch (ch) {
                            case 1: //information
                                if (user != null) {
                                    user.userInformation();
                                } else {
                                    System.out.println("Please enter to System");
                                }
                                break;
                            case 2: // edit account
                                Menu.displayEditMenu();
                                System.out.println("Please enter number: \n");
                                ch = scanner.nextInt();
                                InformationEditor informationEditor = new InformationEditor(user);


                                while (ch != 0) {

                                    switch (ch) {
                                        case 1: // change username
                                            informationEditor.changeUsername();
                                            break;
                                        case 2: // change firstname
                                            informationEditor.changeFirstname();
                                            break;
                                        case 3: // change secondname
                                            informationEditor.changeSecondname();
                                            break;
                                        case 4: // change gender
                                            informationEditor.changeGender();
                                            break;
                                        case 5: // change birthday
                                            informationEditor.changeBirthday();
                                            break;
                                        case 6: // change mail
                                            informationEditor.changeMail();
                                            break;
                                        case 7: // change password
                                            informationEditor.changePassword();
                                            break;
                                        case 8:
                                            informationEditor.confirmAllChanges();
                                            user = userServices.findUser(user.getId());
                                            break;
                                        default:
                                            System.out.println("Please check your choice...");
                                            break;

                                    }


                                    Menu.displayEditMenu();
                                    System.out.println("Please enter number: ");
                                    ch = scanner.nextInt();
                                }

                                break;
                            default:
                                System.out.println("Please check your choice...");
                                break;
                        }


                        Menu.displayMyAccountMenu();
                        System.out.println("Please enter number: ");
                        ch = scanner.nextInt();
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
