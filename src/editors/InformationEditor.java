package editors;

import logger.LogFile;
import models.User;
import servises.DBHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

//TODO users history information editor, add to menu
public class InformationEditor extends DBHandler implements InformationEditorInterface{
    private User user;
    private String sql;
    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void changeUsername() {

        LogFile.log();


        sql = "SELECT username FROM users WHERE " + user.getId() + " = iduser";


        try {
            PreparedStatement statement = dbConnection.prepareStatement(sql);

            System.out.println("Please enter your new username....");


        } catch (SQLIntegrityConstraintViolationException exception){
            System.out.println("This username engaged\n");
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void changeFirstname() {

        LogFile.log();

    }

    @Override
    public void changeSecondname() {

        LogFile.log();

    }

    @Override
    public void changeGender() {

        LogFile.log();

    }

    @Override
    public void changeBirthday() {

        LogFile.log();

    }

    @Override
    public void changePassword() {

        LogFile.log();

    }
}
