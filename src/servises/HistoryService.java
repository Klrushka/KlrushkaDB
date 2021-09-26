package servises;

import constants.FieldNames;
import constants.TableNames;
import logger.LogFile;
import models.User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoryService extends DBHandler {


    public static void addActionToHistory(User user, String action){


        LogFile.log();

        String insert = "INSERT " + TableNames.USER_ACTIONS + "(" + FieldNames.USERNAME + "," +
                FieldNames.FIRSTNAME + "," + FieldNames.SECONDNAME + ", " + FieldNames.ACTION + ")" +
                "VALUES(?,?,?,?)";

        PreparedStatement statement;

        try{

            statement = getDbConnection().prepareStatement(insert);

            statement.setString(1, user.getUsername());
            statement.setString(2,user.getFirstname());
            statement.setString(3,user.getSecondname());
            statement.setString(4,action);


            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
