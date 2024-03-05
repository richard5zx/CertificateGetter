package richard5zx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthenticationDAO {
    
    public static boolean authenticateUser(String username, String password) {
        try {
            DBconnection dBconnection = new DBconnection();
            Connection connection = dBconnection.connect();
            Statement statement = connection.createStatement();

            // Delete record of user
            String sql = "SELECT * FROM users WHERE username = '" + username + "';";

            ResultSet rset = statement.executeQuery(sql);

            // If no such user found -> return false
            if (!rset.next()) {
                return false;
            }

            dBconnection.disconnect(connection);

        } catch(SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }

        return true;
    }
}
