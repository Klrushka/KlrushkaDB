package editors;

import consolehandler.ConsoleHandler;
import logger.LogFile;
import models.User;
import servises.DBHandler;
import userhistory.History;
import userhistory.UserActions;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

//TODO check null
public class InformationEditor extends DBHandler implements InformationEditorInterface {
    private User user;

    public InformationEditor(User user) {
        this.user = user;
    }

    @Override
    public void changeUsername() {

        LogFile.log();

        sqlRequest("users","username", ConsoleHandler.username());

        addHist(UserActions.CHANGE_USERNAME);
    }

    @Override
    public void changeFirstname() {

        LogFile.log();

        sqlRequest("users","firstname", ConsoleHandler.firstname());

        addHist(UserActions.CHANGE_FIRSTNAME);
    }

    @Override
    public void changeSecondname() {

        LogFile.log();

        sqlRequest("users","secondname", ConsoleHandler.secondname());

        addHist(UserActions.CHANGE_SECONDNAME);
    }

    @Override
    public void changeGender() {

        LogFile.log();

        sqlRequest("users","gender", ConsoleHandler.gender());

        addHist(UserActions.CHANGE_GENDER);
    }
////////////////////////////////////////////////
    @Override
    public void changeBirthday() {

        LogFile.log();

        sqlRequest("users","birthday", ConsoleHandler.birthday());


        addHist(UserActions.CHANGE_BIRTHDAY);
    }


    @Override
    public void changeMail() {

        LogFile.log();

        sqlRequest("users","mail", ConsoleHandler.mail());


        addHist(UserActions.CHANGE_MAIL);
    }

    @Override
    public void changePassword() {

        LogFile.log();


        sqlRequest("users","password", ConsoleHandler.password());

        addHist(UserActions.CHANGE_PASSWORD);

    }


    private void sqlRequest(String table, String field, String newValue) {
        String sqlRequest = "UPDATE " + table + " SET "+  field + " = \"" + newValue + "\" WHERE \"" + user.getId() + "\" = iduser";

        try {
            Statement statement = getDbConnection().createStatement();

            statement.execute(sqlRequest);

        } catch (SQLIntegrityConstraintViolationException exception){
            System.out.println("Please change value");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }





    private void addHist(UserActions actions){
        if(History.historyCheckLogin(user)){
            user.getHistory().addHistory(actions);
        }
    }
}
