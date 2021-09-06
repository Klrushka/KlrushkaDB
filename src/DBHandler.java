import com.mysql.cj.jdbc.result.ResultSetImpl;
import constants.Configs;
import constants.FieldNames;
import constants.TableNames;
import models.People;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBHandler extends Configs {

    private Connection dbConnection;

    private Connection getDbConnection() {
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
    public void signUpUser(String firstName, String secondName, String username, String gender, String birthday) {

        String insert = "INSERT " + TableNames.PEOPLE + "(" + FieldNames.USERNAME + "," +
                FieldNames.FIRSTNAME + "," + FieldNames.SECONDNAME + "," + FieldNames.GENDER +
                "," + FieldNames.BIRTHDAY + ")" +
                "VALUES(?,?,?,?,?)";


        PreparedStatement prSt;
        try {

            Date date = Date.valueOf(birthday);

            prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, username);
            prSt.setString(2, firstName);
            prSt.setString(3, secondName);
            prSt.setString(4, gender);
            prSt.setDate(5, date);

            prSt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------------------------


    // DISPLAY DATA BASE
    // -----------------------------------------------------------------------------------------------------------------
    public void displayTable (){

        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");

            while (resultSet.next()) {
                System.out.println(new People(resultSet.getInt("idpeople"), resultSet.getString("firstname"), resultSet.getString("secondname"),
                        resultSet.getString("username"), resultSet.getString("gender"), resultSet.getDate("birthday")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }









    // -----------------------------------------------------------------------------------------------------------------




}
