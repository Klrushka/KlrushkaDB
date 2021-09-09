package help;

public class Menu {
    public static void displayMenu() {
        System.out.println("********************** Menu **********************\n");
        for (int i = 0; i < MenuValues.values().length; i++) {
            System.out.printf("                   %d: %s\n",i + 1,MenuValues.values()[i].getValue());
        }
        System.out.printf("                   0: exit\n");
    }
}
