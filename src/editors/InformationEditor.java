package editors;

import consolehandler.ConsoleHandler;
import enums.help.EditAccountValues;
import logger.LogFile;
import models.User;
import servises.DBHandler;
import servises.HistoryService;
import userhistory.History;
import enums.userhistory.UserActions;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


public class InformationEditor extends DBHandler implements InformationEditorInterface {
    private User user;
    private boolean confirmChanges = false;
    private StringBuffer sqlRequest = new StringBuffer("UPDATE users SET ");
    private boolean cut = false;

    public InformationEditor(User user) {
        this.user = user;
    }

    @Override
    public void changeUsername() {

        LogFile.log();
        HistoryService.addActionToHistory(user, EditAccountValues.CHANGE_USERNAME.getValue());

        if (isNull(user)) {
            System.out.println("Please enter to System...\n");
            return;
        }

        addParameterToSqlRequest("username", ConsoleHandler.username());

        addHist(UserActions.CHANGE_USERNAME);

        confirmChanges = true;
    }

    @Override
    public void changeFirstname() {

        LogFile.log();
        HistoryService.addActionToHistory(user, EditAccountValues.CHANGE_FIRSTNAME.getValue());

        if (isNull(user)) {
            System.out.println("Please enter to System...\n");
            return;
        }


        addParameterToSqlRequest("firstname", ConsoleHandler.firstname());

        addHist(UserActions.CHANGE_FIRSTNAME);

        confirmChanges = true;
    }

    @Override
    public void changeSecondname() {

        LogFile.log();
        HistoryService.addActionToHistory(user, EditAccountValues.CHANGE_SECONDNAME.getValue());

        if (isNull(user)) {
            System.out.println("Please enter to System...\n");
            return;
        }


        addParameterToSqlRequest("secondname", ConsoleHandler.secondname());

        addHist(UserActions.CHANGE_SECONDNAME);

        confirmChanges = true;
    }

    @Override
    public void changeGender() {

        LogFile.log();
        HistoryService.addActionToHistory(user, EditAccountValues.CHANGE_GENDER.getValue());

        if (isNull(user)) {
            System.out.println("Please enter to System...\n");
            return;
        }


        addParameterToSqlRequest("gender", ConsoleHandler.gender());

        addHist(UserActions.CHANGE_GENDER);

        confirmChanges = true;
    }

    @Override
    public void changeBirthday() {

        LogFile.log();
        HistoryService.addActionToHistory(user, EditAccountValues.CHANGE_BIRTHDAY.getValue());

        if (isNull(user)) {
            System.out.println("Please enter to System...\n");
            return;
        }


        addParameterToSqlRequest("birthday", ConsoleHandler.birthday());


        addHist(UserActions.CHANGE_BIRTHDAY);

        confirmChanges = true;
    }


    @Override
    public void changeMail() {

        LogFile.log();
        HistoryService.addActionToHistory(user, EditAccountValues.CHANGE_MAIL.getValue());


        if (isNull(user)) {
            System.out.println("Please enter to System...\n");
            return;
        }


        addParameterToSqlRequest("mail", ConsoleHandler.mail());


        addHist(UserActions.CHANGE_MAIL);


        confirmChanges = true;
    }

    @Override
    public void changePassword() {

        LogFile.log();
        HistoryService.addActionToHistory(user, EditAccountValues.CHANGE_PASSWORD.getValue());

        if (isNull(user)) {
            System.out.println("Please enter to System...\n");
            return;
        }


        addParameterToSqlRequest("password", ConsoleHandler.password());

        addHist(UserActions.CHANGE_PASSWORD);


        confirmChanges = true;
    }


    /**
     * add field to SQLRequest
     *
     * @param field
     * @param value
     */
    private void addParameterToSqlRequest(String field, String value) {
        if (confirmChanges){
            sqlRequest.append(", ");
            cut = true;
        }

        sqlRequest.append(field).append(" = ").append("\"").append(value).append("\"").append(" ");


    }


    /**
     * adding user history
     *
     * @param actions
     */
    private void addHist(UserActions actions) {
        if (History.historyCheckLogin(user)) {
            user.getHistory().addHistory(actions);
        }
    }

    private boolean isNull(User user) {
        return user == null;
    }


    public void confirmAllChanges() {

        if (cut){
            sqlRequest.setLength(sqlRequest.length() - 1);
        }

        if (confirmChanges) {
            sqlRequest.append(" WHERE \"").append(user.getId()).append("\" = iduser");


            try {
                Statement statement = getDbConnection().createStatement();

                statement.execute(sqlRequest.toString());

            } catch (SQLIntegrityConstraintViolationException exception) {
                System.out.println("Please change value");
                exception.printStackTrace();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        } else {
            System.out.println("Sorry we've some problems");
        }

        sqlRequest.setLength(0);

        sqlRequest.append("UPDATE users SET ");
    }

}
