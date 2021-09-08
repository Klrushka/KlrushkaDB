package userhistory;

import models.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class History implements HistoryInterface {
    private  User currentUser;
    private static Properties properties;
    private String path;
    private static final File DIRECTORY;
    // TODO solve problem with USER_INFORMATION field

    public History(User user) {
        currentUser = user;
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
        String USER_INFORMATION = "#" + currentUser.getId() +
                "_" + currentUser.getUsername();
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

        String USER_INFORMATION = "#" + currentUser.getId() +
                "_" + currentUser.getUsername();

        File file = new File(properties.getProperty("historyFilesDirectory"),  USER_INFORMATION + ".txt");

        path = properties.getProperty("historyFilesDirectory") + "\\" + USER_INFORMATION + ".txt";

    }

    @Override
    public void addHistory() {
        String USER_INFORMATION = "#" + currentUser.getId() +
                "_" + currentUser.getUsername();
        try {
            FileWriter fileWriter = new FileWriter(path,true);
            fileWriter.write(USER_INFORMATION + "     фщпзиьтршуеиплваьмтаиыдшлфжоцбАТмишзгуыфлваошщпгк");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
