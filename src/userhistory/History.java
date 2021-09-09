package userhistory;

import models.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PrivilegedAction;
import java.util.Date;
import java.util.Properties;

public class History implements HistoryInterface {
    private  User currentUser;
    private static Properties properties;
    private String path;
    private static final File DIRECTORY;
    private String USER_INFORMATION;
    // TODO solve problem with USER_INFORMATION field

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
    public long findHistoryFile() {

        long isFind = -1;

        for (File file : DIRECTORY.listFiles()){
            if (file.getName().equals(USER_INFORMATION)){
                isFind = currentUser.getId();
                return isFind;
            }
        }
        return isFind;
    }

    @Override
    public void createHistoryFile() {


        File file = new File(properties.getProperty("historyFilesDirectory"),  USER_INFORMATION + ".txt");

        path = properties.getProperty("historyFilesDirectory") + "\\" + USER_INFORMATION + ".txt";

    }

    @Override
    public void addHistory(UserActions actions) {

        try {
            FileWriter fileWriter = new FileWriter(path,true);
            fileWriter.write(new Date() + ": |" + USER_INFORMATION + ", " + actions.name() + "|\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
