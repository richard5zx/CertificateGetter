import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.postgresql.Driver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to Certificate Getter!");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running) {
            System.out.println();
            System.out.println("List of options");
            System.out.println("1) List Certificates");
            System.out.println("2) Add New Certificates");
            System.out.println("3) Delete existing Certificates");
            System.out.println("4) Exit application");
            System.out.println();
            System.out.print("Option: ");

            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            System.out.println("Selected input: " + option);

            switch(option) {
                case 1:
                    System.out.println("Option 1 selected");
                    System.out.println(getNumberOfCertficates(scanner));
                    break;
                case 2:
                    System.out.println("Option 2 selected");
                    addCertficates(scanner);
                    break;
                case 3:
                    System.out.println("Option 3 selected");
                    deleteCertficates(scanner);
                    break;
                case 4:
                    System.out.println("Option 4 selected, Bye!");
                    return;
                default:
                    System.out.println("Enter a valid selction");
            }
        }

        System.out.println();
        scanner.close();
    }

    /**
     * @param Scanner
     * @return number of certificates in table 
    */
    public static int getNumberOfCertficates(Scanner scanner) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        // Get database password from user
        String password = getPassword(scanner);

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
        String password = getPassword(scanner);

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
        
        String password = getPassword(scanner);
        
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

        String password = getPassword(scanner);
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

    /**
    * 
    * @return 
    */
    public static void addDataToCertficate() {
    }

    /**
    * 
    * @return 
    */
    public static void deleteDataFromCertficate() {
    }

    /**
    * Function to retrieve password of database from user 
    * @param Scanner
    * @return String
    */
    public static String getPassword(Scanner scanner) {
        System.out.print("Enter Database password: ");
        String password = scanner.nextLine();
        return password;
    }
}