package richard5zx;

public class CertificateDAO {

    // Attributes
    private DBconnection connectionManager;

    // Constructor
    public CertificateDAO(Token token) {
        this.connectionManager = new DBconnection(token);
    }

}