import servises.DBHandler;

public class Main {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();

        dbHandler.signUpUser("Kiryl", "Sleptsou", "Klrushka", "M", "2003-08-12","co@gmail.com","password");

        dbHandler.displayTable();


        dbHandler.login("Klrushka","password");







    }
}
