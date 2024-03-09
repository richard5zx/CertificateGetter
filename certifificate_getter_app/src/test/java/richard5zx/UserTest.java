package richard5zx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserTest {


    /**
     * Check no certificates before adding anything
     */
    @Test
    public void getCertsTest() {
        User user = new User("user1");
        
        assertTrue(user.getNumOfCert() == 0);
    }

    /**
     * Check no certificates before adding anything
     */
    @Test
    public void getNumOfCertTest() {
        User user = new User("user1");
        assertTrue(user.getNumOfCert() == 0);
    }

    /**
     * Check no certificates before adding anything
     */
    @Test
    public void add_delete_test() {
        User user = new User("user1");
        user.addCert("javaocp");
        user.addCert("javaEE");
        user.addCert("dp900");
        user.addCert("az900");
        user.addCert("sc900");
        user.addCert("ai900");

        // Test getNumOfCert() Function
        assertTrue(user.getNumOfCert() == 6);

        // Reset database: Delete all from table
        user.deleteAllCert();
        
        // Test getNumOfCert() Function
        assertTrue(user.getNumOfCert() == 0); 
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteAllCertTest() {

        User user = new User("user1");

        // Delete all from table
        user.deleteAllCert();

        // Test getNumOfCert() Function
        assertTrue(user.getNumOfCert() == 0);
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteCertTest() {
        
        User user = new User("user1");

        // Add Certificate
        user.addCert("javaocp");
        user.addCert("javaEE");
        user.addCert("dp900");
        user.addCert("az900");
        user.addCert("sc900");
        user.addCert("ai900");

        // Test getNumOfCert() Function
        assertTrue(user.getNumOfCert() == 6);

        // Delete 3 certifications
        user.deleteCert("javaocp");
        user.deleteCert("javaEE");
        user.deleteCert("dp900");
        
        // Test getNumOfCert() Function
        assertTrue(user.getNumOfCert() == 3);
    
        // Delete rest of the certifications
        user.deleteCert("az900");
        user.deleteCert("sc900");
        user.deleteCert("ai900");
        
        // Test getNumOfCert() Function
        assertTrue(user.getNumOfCert() == 0);

        // Make sure everything is deleted from certificate table
        user.deleteAllCert();
    }
}
