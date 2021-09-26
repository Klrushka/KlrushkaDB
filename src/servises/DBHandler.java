package servises;

import constants.Configs;
import constants.FieldNames;
import constants.TableNames;
import logger.LogFile;
import models.User;
import userhistory.History;
import enums.userhistory.UserActions;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBHandler extends Configs {


    protected User user;
    private static Connection dbConnection;


    /**
     * Return DB connection
     *
     * @return Connection
     */


    protected static Connection getDbConnection() {

        LogFile.log();

        String connectString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            dbConnection = DriverManager.getConnection(connectString, dbUser, dbPass);


        } catch (InstantiationException | SQLException | ClassNotFoundException |
                NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        return dbConnection;
    }


//    /**
//     * Add new user in DB
//     *
//     * @param userInfo String[]
//     *                 Where [0] - username
//     *                 [1] - firstname
//     *                 [2] - secondnamme
//     *                 [3] - gender
//     *                 [4] - birthday(yyyy-mm-dd)
//     *                 [5] - mail
//     *                 [6] - password
//     */
//    // SIGN UP USERS
//    // -----------------------------------------------------------------------------------------------------------------
//    public User signUpUser(String... userInfo) {
//
//
//        LogFile.log();
//
//        String insert = "INSERT " + TableNames.USER + "(" + FieldNames.USERNAME + "," +
//                FieldNames.FIRSTNAME + "," + FieldNames.SECONDNAME + "," + FieldNames.GENDER +
//                "," + FieldNames.BIRTHDAY + "," + FieldNames.MAIL + "," + FieldNames.PASSWORD + ")" +
//                "VALUES(?,?,?,?,?,?,?)";
//
//
//        PreparedStatement prSt;
//        try {
//
//            Date date = Date.valueOf(userInfo[4]);
//
//            prSt = getDbConnection().prepareStatement(insert);
//
//            prSt.setString(1, userInfo[0]);
//            prSt.setString(2, userInfo[1]);
//            prSt.setString(3, userInfo[2]);
//            prSt.setString(4, userInfo[3]);
//            prSt.setDate(5, date);
//            prSt.setString(6, userInfo[5]);
//            prSt.setString(7, userInfo[6]);
//
//            prSt.executeUpdate();
//
//            user = login(userInfo[5], userInfo[6]);
//
//            return user;
//
//        } catch (SQLIntegrityConstraintViolationException e) {
//            System.out.println("!!!!!!!!! Please check your username !!!!!!!!!");
//            return null;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
//
//    }
//    // -----------------------------------------------------------------------------------------------------------------
//
//
//    /**
//     * Display all fields from table
//     */
//    // DISPLAY DATA BASE
//    // -----------------------------------------------------------------------------------------------------------------
//    public void displayTable() {
//
//
//        LogFile.log();
//
//
//        if (user == null || !user.isLogin()) {
//            System.out.println("Please enter to system");
//            return;
//        }
//
//        user.getHistory().addHistory(UserActions.DISPLAY_TABLE);
//
//        try {
//            Statement statement = getDbConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//
//            while (resultSet.next()) {
//                System.out.println(new User(resultSet.getInt("iduser"), resultSet.getString("firstname"),
//                        resultSet.getString("secondname"), resultSet.getString("username"),
//                        resultSet.getString("gender"), resultSet.getDate("birthday"),
//                        resultSet.getString("mail"), resultSet.getString("password")));
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    // -----------------------------------------------------------------------------------------------------------------
//
//
//    /**
//     * Returns User and set login flag. If User not found returns null
//     * and "Check your login or password"
//     *
//     * @param loginData String[]
//     *                  [0] - login
//     *                  [1] - password
//     * @return User
//     */
//    // LOGIN USER
//    // -----------------------------------------------------------------------------------------------------------------
//    public User login(String... loginData) {
//
//        LogFile.log();
//
//
//        if (user != null && user.isLogin()) {
//            System.out.println("Please exit from current session");
//            return null;
//        }
//
//
//        try {
//            Statement statement = getDbConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users " +
//                    "WHERE ((\"" + loginData[0] + "\"= username) OR" + " (\"" + loginData[0] + "\"= mail)) AND (\"" + loginData[1] + "\"= password)");
//
//            while (resultSet.next()) {
//                user = new User(resultSet.getInt("iduser"), resultSet.getString("firstname"), resultSet.getString("secondname"),
//                        resultSet.getString("username"), resultSet.getString("gender"), resultSet.getDate("birthday"),
//                        resultSet.getString("mail"), resultSet.getString("password"));
//            }
//
//            user.setLogin(true);
//
//
//            if (!user.isHaveHistory()) {
//                user.setHaveHistory(true);
//                History history = new History(user);
//                user.setHistory(history);
//                user.getHistory().createHistoryFile();
//            }
//
//            user.getHistory().addHistory(UserActions.LOGIN);
//
//            System.out.println("**************** You enter to the system **************** \n");
//
//            return user;
//
//        } catch (SQLException e) {
//            System.out.println("Check your login or password");
//
//            return null;
//        }
//
//    }
//    // -----------------------------------------------------------------------------------------------------------------

}
