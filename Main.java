import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
                    System.out.println(getNumberOfCertficates());
                    break;
                case 2:
                    System.out.println("Option 2 selected");
                    addCertficates();
                    break;
                case 3:
                    System.out.println("Option 3 selected");
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
     * 
     * @return 
    */
    public static int getNumberOfCertficates() {
        return 1;
    }

    /**
     * 
     * @return 
    */
    public static void addCertficates() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        // Get database password from user
        String password = getPassword();

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL");

            String sql = "Insert INTO certificates (name)" + " VALUES('Test')";

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0) {
                System.out.println("added");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }

    /**
    * 
    * @return 
    */
    public static void deleteCertficates() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        String password;
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
    * 
    * @return 
    */
    public static String getPassword() {
        System.out.print("Enter Database password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        return password;
    }
}