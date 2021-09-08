import models.User;
import servises.DBHandler;

public class Main {
    public static void main(String[] args) {

        // TODO test other user
        DBHandler dbHandler = new DBHandler();
        User currentUser = dbHandler.login("Kka","password");

        dbHandler.displayTable();






    }
}
