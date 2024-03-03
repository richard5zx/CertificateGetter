package richard5zx;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBconnection {
    // Atributes
    final private String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
    final private String db_username = "postgres";
    final private String db_password = "111";

    // Methods
    public Connection connect() {

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, db_username, db_password);
            return connection;
        } catch(Exception e) {
            System.out.println("Error in connecting to server");
            e.printStackTrace();
        }
        return null;
    }

    
    public void disconnect(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Problem disconnecting to server");
            e.printStackTrace();
        }
    }
    
    public void getConnectionObject() {

    }
}
