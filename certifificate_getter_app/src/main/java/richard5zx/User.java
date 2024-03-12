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
    public String addCert(String cert_name) {
        return UserDAO.addCert(cert_name);
    }

    public int deleteCert(int username) {
        return UserDAO.deleteCert(username);
    }

    public String deleteCert(String username) {
        return UserDAO.deleteCert(username);
    }

    public void deleteAllCert() {
        UserDAO.deleteAllCert();
    }

    public int getNumOfCert() {
        return UserDAO.getNumOfCert();
    }

    public List<Certificate> getCert() {
        return UserDAO.getCert();
    }
}
