package help;

import logger.LogFile;

public class Menu {


    public static void displayMainMenu() {

        LogFile.log();

        System.out.println("********************** Menu **********************\n");
        for (int i = 0; i < MenuValues.values().length; i++) {
            System.out.printf("                   %d: %s\n", i + 1, MenuValues.values()[i].getValue());
        }
        System.out.println("                   0: exit\n");
    }


    public static void displayHistoryMenu() {

        LogFile.log();

        System.out.println("********************* History *********************\n");
        for (int i = 0; i < MenuHistoryValues.values().length; i++) {
            System.out.printf("                   %d: %s\n", i + 1, MenuHistoryValues.values()[i].getValue());
        }
        System.out.println("                   0: exit\n");
    }

    public static void displayMyAccountMenu() {

        LogFile.log();

        System.out.println("********************* Account *********************\n");
        for (int i = 0; i < MyAccountValues.values().length; i++) {
            System.out.printf("                   %d: %s\n", i + 1, MyAccountValues.values()[i].getValue());
        }
        System.out.println("                   0: exit\n");
    }

    public static void displayEditMenu() {

        LogFile.log();

        System.out.println("********************* Edit *********************\n");
        for (int i = 0; i < EditAccountValues.values().length; i++) {
            System.out.printf("                   %d: %s\n", i + 1, EditAccountValues.values()[i].getValue());
        }
        System.out.println("                   0: exit\n");
    }
}
