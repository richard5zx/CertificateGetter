package richard5zx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SystemManagerDAO {
    
    // Methods
    public static boolean isRegistered(String username, String password) {
        try {
            DBconnection dBconnection = new DBconnection();
            Connection connection = dBconnection.connect();
            Statement statement = connection.createStatement();

            String sql = "SELECT 1 AS username_count FROM users where username = '" + username + "';";
            ResultSet rset = statement.executeQuery(sql);

            // If no such user found -> return false
            if (!rset.next()) {
                return false;
            }

            dBconnection.disconnect(connection);

        } catch (Exception e) {
            System.out.println("Error connecting to server");
            e.printStackTrace();
        }

        return true;
    }

    public static void registerUser(String username, String password) {
        
        // Check if user is registered
        try {
            DBconnection dBconnection = new DBconnection();
            Connection connection = dBconnection.connect();
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "');";

            statement.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println("Error connecting to server");
            e.printStackTrace();
        }
    }

    public static boolean deleteUser(String username) {
        try {
            DBconnection dBconnection = new DBconnection();
            Connection connection = dBconnection.connect();
            Statement statement = connection.createStatement();

            
            // Delete record of user
            String sql = "DELETE FROM users WHERE username = '" + username + "';";

            statement.executeUpdate(sql);

            dBconnection.disconnect(connection);
            
            return true;

        } catch(SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }

        return false;
    }

    public static boolean deleteAllUsers() {
        try {
            DBconnection dBconnection = new DBconnection();
            Connection connection = dBconnection.connect();
            Statement statement = connection.createStatement();

            String sql = "TRUNCATE TABLE users;";
            statement.execute(sql);

            dBconnection.disconnect(connection);

            // Return true if successfully deleted all users
            return true;

        } catch (Exception e) {
            System.out.println("Error connecting to server");
            e.printStackTrace();
        }

        // Return false if not successfully deleted all users
        return true;
    }

    public static int getNumOfUser() {
        try {
            DBconnection dBconnection = new DBconnection();
            Connection connection = dBconnection.connect();
            Statement statement = connection.createStatement();

            String sql = "SELECT COUNT(*) AS num_of_users FROM users;";
            
            ResultSet rset = statement.executeQuery(sql);

            rset.next();
            int num_of_users = rset.getInt("num_of_users");

            dBconnection.disconnect(connection);

            return num_of_users;

        } catch (Exception e) {
            System.out.println("Error connecting to server");
            e.printStackTrace();
        }
        return 0;
    }
}
