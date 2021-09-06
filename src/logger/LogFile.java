package logger;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class LogFile {
    public static void log (){
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src\\config.properties"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(properties.getProperty("logFile")));

            //TODO logger
            bufferedWriter.append(String.valueOf(new Date())).append("in progress: ").append(Thread.currentThread().getStackTrace()[1].getMethodName());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
