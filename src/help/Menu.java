package help;

public class Menu {
    public static void displayMainMenu() {
        System.out.println("********************** Menu **********************\n");
        for (int i = 0; i < MenuValues.values().length; i++) {
            System.out.printf("                   %d: %s\n", i + 1, MenuValues.values()[i].getValue());
        }
        System.out.println("                   0: exit\n");
    }


    public static void displayHistoryMenu() {
        System.out.println("********************* History *********************\n");
        for (int i = 0; i < MenuHistoryValues.values().length; i++) {
            System.out.printf("                   %d: %s\n", i + 1, MenuHistoryValues.values()[i].getValue());
        }
        System.out.println("                   0: exit\n");
    }
}
