package servises;

import constants.Configs;
import constants.FieldNames;
import constants.TableNames;
import logger.LogFile;
import models.User;
import userhistory.History;
import userhistory.UserActions;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBHandler extends Configs {

    //TODO write documentation and optimize code

    private User user;
    private Connection dbConnection;


    /**
     * Return DB connection
     * @return Connection
     */


    private Connection getDbConnection() {

        LogFile.log();

        String connectString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.println("Connection successful");

            dbConnection = DriverManager.getConnection(connectString, dbUser, dbPass);


        } catch (InstantiationException | SQLException | ClassNotFoundException |
                NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        return dbConnection;
    }


    /**
     * Add new user in DB
     * @param userInfo  String[]
     * Where [0] - username
     *       [1] - firstname
     *       [2] - secondnamme
     *       [3] - gender
     *       [4] - birthday(yyyy-mm-dd)
     *       [5] - mail
     *       [6] - password
     */
    // SIGN UP USERS
    // -----------------------------------------------------------------------------------------------------------------
    public User signUpUser(String... userInfo) {


        LogFile.log();

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
            prSt.setString(6,userInfo[5]);
            prSt.setString(7,userInfo[6]);

            prSt.executeUpdate();

            user = login(userInfo[5],userInfo[6]);

            return user;

        } catch (SQLException throwables) {
            throwables.printStackTrace();

            return null;
        }

    }
    // -----------------------------------------------------------------------------------------------------------------


    /**
     *Display all fields from table
     */
    // DISPLAY DATA BASE
    // -----------------------------------------------------------------------------------------------------------------
    public void displayTable() {


        LogFile.log();
        user.getHistory().addHistory(UserActions.DISPLAY_TABLE);

        if (!user.isLogin()) return;


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
     * @param login String
     * @param password String
     * @return User
     */
    // LOGIN USER
    // -----------------------------------------------------------------------------------------------------------------
    public User login(String login, String password) {

        LogFile.log();



        if (user != null && user.isLogin()) {
            System.out.println("Please exit from current session");
            return null;
        }


        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users " +
                    "WHERE ((\"" + login + "\"= username) OR" + " (\"" + login + "\"= mail)) AND (\"" + password + "\"= password)");

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


            return user;

        } catch (SQLException e) {
            System.out.println("Check your login or password");

            return null;
        }

    }
    // -----------------------------------------------------------------------------------------------------------------









}
