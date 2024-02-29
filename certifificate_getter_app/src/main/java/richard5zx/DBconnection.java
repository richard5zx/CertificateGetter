package richard5zx;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    // Atributes
    private Token token;

    // Constuctor
    public DBconnection(Token token) {
        this.token = token;
    }

    // Methods
    public Connection connect() {
        String jdbcURL = token.getJdbcURL();
        String username = token.getUsername();
        String password = token.getPassword();

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            return connection;
        } catch(Exception e) {
    
            System.out.println("Error in connecting to PostgreSQL server");
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
