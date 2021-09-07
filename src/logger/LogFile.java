package logger;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class LogFile {
    public static void log (){
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src\\config.properties"));
            FileWriter fileWriter = new FileWriter(properties.getProperty("logFile"),true);
            fileWriter.write(new Date() + " " + Thread.currentThread().getStackTrace()[2] + "\n");
            fileWriter.flush();
            fileWriter.close();


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
