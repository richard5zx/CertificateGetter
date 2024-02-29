package richard5zx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CertificateDAO {

    // Attributes
    private DBconnection connectionManager;

    // Constructor
    public CertificateDAO(Token token) {
        this.connectionManager = new DBconnection(token);
    }

    // Methods
    public int getNumOfCert(Certificate certificate, Token token) {
        try {
            Connection connection = connectionManager.connect(token);

            String sql = "SELECT COUNT(*) AS numOfCert FROM public.certificates";

            Statement statement = connection.createStatement();

            ResultSet rset = statement.executeQuery(sql);

            rset.next();

            int numOfCert = rset.getInt("numOfCert");

            connectionManager.disconnect(connection);

            return numOfCert;
            
        } catch(Exception e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }

        return -1;
    }

    public void deleteCertficate(Certificate certificate) {

    }
}
