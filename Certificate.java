import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Certificate {
        /**
     * @param Scanner
     * @return number of certificates in table 
    */
    public static int getNumberOfCertficates(Scanner scanner) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        // Get database password from user
        String password = Authentication.getPassword(scanner);

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            String sql = "SELECT COUNT(*)";

            Statement statement = connection.createStatement();

            
        } catch(Exception e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
        
        return 1;
    }

    /**
     * Function to add a certificate from user input to a database
     * @param Scanner 
     * @return void
    */
    public static void addCertficates(Scanner scanner) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        // Get database password from user
        String password = Authentication.getPassword(scanner);

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            System.out.print("Enter name of new certificate: ");
            String certificateName = scanner.nextLine();

            String sql = "Insert INTO certificates (name)" + " VALUES('" + certificateName + "')";
            
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0) {
                 System.out.println(certificateName + " certificate added");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }

    /**
    * Function to delete a certificate from user input to a database
    * @param Scanner 
    * @return void
    */
    public static void deleteCertficates(Scanner scanner) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";
        
        String password = Authentication.getPassword(scanner);
        
        // Function to show the lists of certificates

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            System.out.print("Select id of certificate you want to delete: ");
            String id = scanner.nextLine();
            String sql = "DELETE FROM certificates WHERE id=" + id;

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0) {
                System.out.println("Certificate deleted");
            }
            connection.close();

        } catch(SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }

    /**
    * 
    * @return 
    */
    public static void listCertficate(Scanner scanner) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        String password = Authentication.getPassword(scanner);
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");
            String sql = "";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);

            if(rows > 0) {
                System.out.println("listed");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }
}
