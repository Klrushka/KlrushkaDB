package userhistory;

import models.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class History implements HistoryInterface {

    private User currentUser;
    private static Properties properties;
    private String path;
    private static final File DIRECTORY;
    private String USER_INFORMATION;

    public History(User user) {
        currentUser = user;
        USER_INFORMATION = "#" + currentUser.getId() +
                "_" + currentUser.getUsername();

    }


    static {

        try {
            properties = new Properties();
            properties.load(new FileReader("src\\config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DIRECTORY = new File(properties.getProperty("historyFilesDirectory"));

    }

    @Override
    public void clearHistory() {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void createHistoryFile() {


        File file = new File(properties.getProperty("historyFilesDirectory"), USER_INFORMATION + ".txt");

        path = properties.getProperty("historyFilesDirectory") + "\\" + USER_INFORMATION + ".txt";

    }

    @Override
    public void addHistory(UserActions actions) {

        try {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write(new Date() + ": |" + USER_INFORMATION + ", " + actions.name() + "|\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void displayHistory() {

        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean historyCheckLogin(User user) {
        if (user == null) {
            System.out.println("Please enter to the system...");
            return false;
        }
        return true;
    }
}
