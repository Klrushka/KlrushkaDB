package servises;

import constants.Configs;
import constants.FieldNames;
import constants.TableNames;
import enums.help.EditAccountValues;
import enums.help.MenuValues;
import enums.userhistory.UserActions;
import help.Menu;
import logger.LogFile;
import models.User;
import userhistory.History;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class UserServices extends DBHandler {




    /**
     * Add new user in DB
     *
     * @param userInfo String[]
     *                 Where [0] - username
     *                 [1] - firstname
     *                 [2] - secondnamme
     *                 [3] - gender
     *                 [4] - birthday(yyyy-mm-dd)
     *                 [5] - mail
     *                 [6] - password
     */
    // SIGN UP USERS
    // -----------------------------------------------------------------------------------------------------------------
    public User signUpUser(String... userInfo) {


        LogFile.log();
        HistoryService.addActionToHistory(user, MenuValues.SIGN_UP.getValue());

        String insert = "INSERT " + TableNames.USER + "(" + FieldNames.USERNAME + "," +
                FieldNames.FIRSTNAME + "," + FieldNames.SECONDNAME + "," + FieldNames.GENDER +
                "," + FieldNames.BIRTHDAY + "," + FieldNames.MAIL + "," + FieldNames.PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?,?)";


        PreparedStatement prSt;
        try {

            Date date = Date.valueOf(userInfo[4]);

            prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, userInfo[0]);
            prSt.setString(2, userInfo[1]);
            prSt.setString(3, userInfo[2]);
            prSt.setString(4, userInfo[3]);
            prSt.setDate(5, date);
            prSt.setString(6, userInfo[5]);
            prSt.setString(7, userInfo[6]);

            prSt.executeUpdate();

            user = login(userInfo[5], userInfo[6]);

            return user;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("!!!!!!!!! Please check your username !!!!!!!!!");
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
    // -----------------------------------------------------------------------------------------------------------------


    /**
     * Display all fields from table
     */
    // DISPLAY DATA BASE
    // -----------------------------------------------------------------------------------------------------------------
    public void displayTable() {


        LogFile.log();
        HistoryService.addActionToHistory(user, MenuValues.DISPLAY_TABLE.getValue());


        if (user == null || !user.isLogin()) {
            System.out.println("Please enter to system");
            return;
        }

        user.getHistory().addHistory(UserActions.DISPLAY_TABLE);

        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(new User(resultSet.getInt("iduser"), resultSet.getString("firstname"),
                        resultSet.getString("secondname"), resultSet.getString("username"),
                        resultSet.getString("gender"), resultSet.getDate("birthday"),
                        resultSet.getString("mail"), resultSet.getString("password")));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    // -----------------------------------------------------------------------------------------------------------------


    /**
     * Returns User and set login flag. If User not found returns null
     * and "Check your login or password"
     *
     * @param loginData String[]
     *                  [0] - login
     *                  [1] - password
     * @return User
     */
    // LOGIN USER
    // -----------------------------------------------------------------------------------------------------------------
    public User login(String... loginData) {

        LogFile.log();



        if (user != null && user.isLogin()) {
            System.out.println("Please exit from current session");
            return null;
        }


        try {
            String sqlString = "SELECT * FROM users WHERE (" + loginData[0] + " = username" + " OR " + loginData[1] + " = password";
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users " +
                    "WHERE ((\"" + loginData[0] + "\"= username) OR" + " (\"" + loginData[0] + "\"= mail)) AND (\"" + loginData[1] + "\"= password)");

            while (resultSet.next()) {
                user = new User(resultSet.getInt("iduser"), resultSet.getString("firstname"), resultSet.getString("secondname"),
                        resultSet.getString("username"), resultSet.getString("gender"), resultSet.getDate("birthday"),
                        resultSet.getString("mail"), resultSet.getString("password"));
            }

            user.setLogin(true);


            if (!user.isHaveHistory()) {
                user.setHaveHistory(true);
                History history = new History(user);
                user.setHistory(history);
                user.getHistory().createHistoryFile();
            }

            user.getHistory().addHistory(UserActions.LOGIN);

            System.out.println("**************** You enter to the system **************** \n");

          //  HistoryService.addActionToHistory(user, "login");

            return user;

        } catch (SQLException e) {
            System.out.println("Check your login or password");

            return null;
        }

    }
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns User
     * @param id long
     * @return User
     */
    // -----------------------------------------------------------------------------------------------------------------
    public User findUser(long id) {

        LogFile.log();



        try {
            String sqlString = "SELECT * FROM users WHERE (\"" + id + "\" = iduser)";
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);

            while (resultSet.next()) {
                user = new User(resultSet.getInt("iduser"), resultSet.getString("firstname"), resultSet.getString("secondname"),
                        resultSet.getString("username"), resultSet.getString("gender"), resultSet.getDate("birthday"),
                        resultSet.getString("mail"), resultSet.getString("password"));
            }


            return user;

        } catch (SQLException e) {
            System.out.println("User not found");

            return null;
        }
    }
    // -----------------------------------------------------------------------------------------------------------------
}
