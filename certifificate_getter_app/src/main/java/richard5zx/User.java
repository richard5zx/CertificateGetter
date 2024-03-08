package richard5zx;

import java.util.List;

public class User {
    // Attributes
    String username;
    // List<Certificate> certificates;

    // Constructor
    public User (String username) {
        this.username = username;
    }

    // Methods
    public void addCert(String cert_name) {
        UserDAO.addCert(cert_name);
    }

    public void deleteCert(int username) {
        UserDAO.deleteCert(username);
    }

    public void deleteCert(String username) {
        UserDAO.deleteCert(username);
    }

    public void deleteAllCert() {
        UserDAO.deleteAllCert();
    }

    public void modifyCert() {

    }

    public int getNumOfCert() {
        return UserDAO.getNumOfCert();
    }

    public List<Certificate> listCert() {
        return null;
    }
}
