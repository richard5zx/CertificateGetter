package richard5zx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SystemManagerDAOTest {

    // ------------------- User DAO test -------------------
    /**
     * Add and delete repeated user
     */
    @Test
    public void registeringReapeatedUserTest() {
        // Add users
        // Todo
    }
    /**
     * Add and delete user
     */
    @Test
    public void getNumOfUserTest() {
        // Add users
        SystemManagerDAO.registerUser("user1", "password");
        SystemManagerDAO.registerUser("user2", "password");

        assertTrue(SystemManagerDAO.getNumOfUser() == 2);

        SystemManagerDAO.deleteUser("user1");

        assertTrue(SystemManagerDAO.getNumOfUser() == 1);

        SystemManagerDAO.registerUser("user3", "password");
        SystemManagerDAO.registerUser("user4", "password");
        SystemManagerDAO.registerUser("user5", "password");
        SystemManagerDAO.registerUser("user6", "password");
        
        assertTrue(SystemManagerDAO.getNumOfUser() == 5);

        SystemManagerDAO.deleteUser("user4");
        SystemManagerDAO.deleteUser("user6");

        assertTrue(SystemManagerDAO.getNumOfUser() == 3);

    
        SystemManagerDAO.deleteAllUsers();
        assertTrue(SystemManagerDAO.getNumOfUser() == 0);

    }

    /**
     * Add and delete user
     */
    @Test
    public void checkifUserRegisteredTest() {
        // Add users
        SystemManagerDAO.registerUser("user1", "password");
        SystemManagerDAO.registerUser("user2", "password");
        SystemManagerDAO.registerUser("user3", "password");
        SystemManagerDAO.registerUser("user4", "password");
        SystemManagerDAO.registerUser("user5", "password");
        SystemManagerDAO.registerUser("user6", "password");
        
        assertTrue(SystemManagerDAO.getNumOfUser() == 6);
        
        // Delete users
        SystemManagerDAO.deleteUser("user1");
        SystemManagerDAO.deleteUser("user4");
        SystemManagerDAO.deleteUser("user6");
        assertTrue(SystemManagerDAO.getNumOfUser() == 3);

        SystemManagerDAO.deleteAllUsers();
    }

    /**
     * Check if the user successfully registered
     */
    @Test
    public void registerUserTest() {
        String username = "user1";
        String password = "pass1";

        SystemManagerDAO.registerUser(username, password);
        
        assertTrue(SystemManagerDAO.getNumOfUser() == 1);

        // Register again
        SystemManagerDAO.registerUser(username, password);
        assertTrue(SystemManagerDAO.getNumOfUser() == 1);

        SystemManagerDAO.deleteAllUsers();
    }

    /**
     * Check if the user sucesfully registered
     */
    @Test
    public void deleteAllUserTest() {

        SystemManagerDAO.deleteAllUsers();

        assertTrue(SystemManagerDAO.getNumOfUser() == 0);
    }

    // ------------------- Certificate DAO test -------------------
    
    /**
     * Check no certificates before adding anything
     */
    @Test
    public void getNumOfCertTest() {

        assertTrue(SystemManager.getNumOfCert() == 0);
    }

    /**
     * Check no certificates before adding anything
     */
    @Test
    public void add_delete_test() {

        Certificate.addCertficate("javaocp");
        Certificate.addCertficate("javaEE");
        Certificate.addCertficate("dp900");
        Certificate.addCertficate("az900");
        Certificate.addCertficate("sc900");
        Certificate.addCertficate("ai900");

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert() == 6);

        // Reset database: Delete all from table
        Certificate.deleteAllCertificates();
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert() == 0);

        
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteAllCertTest() {
        
        String password = "111";
        Authentication authenticator = new Authentication(password);
        Token token = authenticator.authenticate();

        // Delete all from table
        Certificate.deleteAllCertificates(token);

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(token) == 0);
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteCertTest() {
        
        String password = "111";
        Authentication authenticator = new Authentication(password);
        Token token = authenticator.authenticate();

        // Add Certificate
        Certificate.addCertficate("javaocp", token);
        Certificate.addCertficate("javaEE", token);
        Certificate.addCertficate("dp900", token);
        Certificate.addCertficate("az900", token);
        Certificate.addCertficate("sc900", token);
        Certificate.addCertficate("ai900", token);

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(token) == 6);

        // Delete 3 certifications
        Certificate.deleteCertficate("javaocp", token);
        Certificate.deleteCertficate("javaEE", token);
        Certificate.deleteCertficate("dp900", token);
        
        // Test getNumOfCert() Function
        int bug = Certificate.getNumOfCert(token);
        System.out.println(bug);
        assertTrue(Certificate.getNumOfCert(token) == 3);
    
        // Delete rest of the certifications
        Certificate.deleteCertficate("az900", token);
        Certificate.deleteCertficate("sc900", token);
        Certificate.deleteCertficate("ai900", token);
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(token) == 0);

        // Make sure everything is deleted from certificate table
        Certificate.deleteAllCertificates(token);
    }
}