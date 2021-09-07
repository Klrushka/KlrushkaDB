package servises;

import constants.Configs;
import constants.FieldNames;
import constants.TableNames;
import logger.LogFile;
import models.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBHandler extends Configs {

    private Connection dbConnection;

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

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------------------------


    // DISPLAY DATA BASE
    // -----------------------------------------------------------------------------------------------------------------
    public void displayTable() {


        LogFile.log();

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


        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users " +
                    "WHERE ((\"" + login + "\"= username) OR" + " (\"" + login + "\"= mail)) AND (\"" + password + "\"= password)");

            User user = new User(resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("secondname"),
                    resultSet.getString("username"), resultSet.getString("gender"), resultSet.getDate("birthday"),
                    resultSet.getString("mail"), resultSet.getString("password"));

            user.setLogin(true);

            return user;

        } catch (SQLException e) {
            System.out.println("Check your login or password");

            return null;
        }

    }
    // -----------------------------------------------------------------------------------------------------------------


}
