package servises;

import constants.Configs;
import constants.FieldNames;
import constants.TableNames;
import logger.LogFile;
import models.User;
import userhistory.History;
import userhistory.HistoryInterface;

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
     * Add users in DB
     * @param firstName String
     * @param secondName String
     * @param username String
     * @param gender String
     * @param birthday String
     * @param mail String
     * @param password String
     */

    // SIGN UP USERS
    // -----------------------------------------------------------------------------------------------------------------
    public void signUpUser(String firstName, String secondName, String username, String gender, String birthday, String mail, String password) {


        LogFile.log();

        String insert = "INSERT " + TableNames.USER + "(" + FieldNames.USERNAME + "," +
                FieldNames.FIRSTNAME + "," + FieldNames.SECONDNAME + "," + FieldNames.GENDER +
                "," + FieldNames.BIRTHDAY + "," + FieldNames.MAIL + "," + FieldNames.PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?,?)";


        PreparedStatement prSt;
        try {

            Date date = Date.valueOf(birthday);

            prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, username);
            prSt.setString(2, firstName);
            prSt.setString(3, secondName);
            prSt.setString(4, gender);
            prSt.setDate(5, date);
            prSt.setString(6,mail);
            prSt.setString(7,password);

            prSt.executeUpdate();

            login(mail,password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        user.getHistory().addHistory();

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
