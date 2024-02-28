package richard5zx;

// import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Certificate {
    
    /**
     * @param Scanner
     * @return number of certificates in table or -1 if there is an error
     */
    public static int getNumOfCert(String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            String sql = "SELECT COUNT(*) AS numOfCert FROM public.certificates";

            Statement statement = connection.createStatement();

            ResultSet rset = statement.executeQuery(sql);

            rset.next();
            int numOfCert = rset.getInt("numOfCert");

            return numOfCert; 
            
        } catch(Exception e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * @param Scanner
     * @return prints out the certificates id and name of certificate
     */
    public static void listCertficates(String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            Statement statement = connection.createStatement();

            // Execute query and return result to rset
            String sql = "SELECT * FROM certificates";
            ResultSet rset = statement.executeQuery(sql);

            // Print the data from the database
            while(rset.next()) {
                int cert_id = rset.getInt("cert_id");
                String cert_name = rset.getString("cert_name");
                System.out.println(cert_id + " - " + cert_name);
            }
            
            connection.close();
        } catch (Exception e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }

    /**
     * Function to add a certificate from user input to a database
     * @param Scanner 
     * @return void
     */
    public static void addCertficate(String cert_name, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            String sql = "INSERT INTO certificates (\"cert_name\")" + " VALUES('" + cert_name + "')";
            
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0) {
                 System.out.println(cert_name + " certificate added");
            }

            // Add new table for question bank of the certificate
            createQuestionTable(cert_name, password);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }

    public static void createQuestionTable(String cert_name, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");
            
            String sql = "CREATE TABLE IF NOT EXISTS " + cert_name + " (\n"
                 + "    CertificateID int PRIMARY KEY,\n"
                 + "    QuestionID int UNIQUE, \n"
                 + "    Question varchar(255) NOT NULL, \n"
                 + "    Mistakes int DEFAULT 0, \n"
                 + "    DateAdded TIMESTAMP NOT NULL \n"
                 + ");";

            Statement statement = connection.createStatement();
            statement.execute(sql);

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
    public static void deleteCertficate(String cert_name, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            // Drop table (question bank) from the database
            deleteQuestionTable(cert_name, password);
            
            // Drop the data from the certificates table
            String sql = "DELETE FROM certificates WHERE cert_name = '" + cert_name + "';";

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
     * Function to delete a certificate from user input to a database
     * @param Scanner 
     * @return void
     */
    public static void deleteCertficate(int id, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            // Drop table (question bank) from the database
            System.out.println("-----------Im over here: " + id);
            deleteQuestionTable(id, password);
            
            // Drop the data from the certificates table
            String sql = "DELETE FROM certificates WHERE cert_id = " + id + ";";

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
     * Function to delete table related to the certificate chosen
     * @param Scanner 
     * @return void
     */
    public static void deleteQuestionTable(String cert_name, String password) {
        
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            System.out.println(cert_name);
            String sql = "DROP TABLE " + cert_name + ";";
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

            connection.close();
            System.out.println("Table Dropped");
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }

    /**
     * Function to delete table related to the certificate chosen
     * @param Scanner 
     * @return void
     */
    public static void deleteQuestionTable(int id, String password) {
        
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";
        
        // Query name of certificate from certificate id given
        String cert_name = getCertNamefromId(id, password);
        
        // Drop the table with the name queried above
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            System.out.println(cert_name);
            String sql = "DROP TABLE " + cert_name + ";";
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

            connection.close();
            System.out.println("Table Dropped");
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }
    
    /**
     * Function to query name of certificate from the id given
     * @param Scanner, id of certificate, password of database
     * @return String of certificate name or null if not found
     */
    public static String getCertNamefromId(int cert_id, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        // Drop the table with name queried
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            Statement statement = connection.createStatement();

            // Execute query to find the name of certificate from id
            String sql = "SELECT * FROM certificates WHERE cert_id = " + cert_id + ";";

            ResultSet rset = statement.executeQuery(sql);
            while(rset.next()) {
                String cert_name = rset.getString("cert_name");
                return cert_name;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }

        return null;
    }   

    /**
     * Function to wipe/reset all certificates
     * @param Scanner 
     * @return void
     */
    public static void deleteAllCertificates(String password) {
        // remove tables related to the certificate
        String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
        String username = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");
            
            Statement statement = connection.createStatement();

            // 1) Remove each table
            String sql = "SELECT * FROM certificates";
            
            ResultSet rset = statement.executeQuery(sql);
            while(rset.next()) {
                String cert_id_string = rset.getString("cert_id");
                int cert_id_int = Integer.parseInt(cert_id_string);
                deleteQuestionTable(cert_id_int, password);
            }

            // 2) Remove all contents of certificate table
            sql = "TRUNCATE TABLE certificates;";
            statement.execute(sql);

        } catch (Exception e) {

        }
    }
}