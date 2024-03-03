package richard5zx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SystemManagerDAOTest {

    /**
     * Check if the user already exists in database
     */
    @Test
    public void checkifUserRegisteredTest() {

        
        String dbpassword = "111";
        Authentication authenticator = new Authentication(dbpassword);
        Token token = authenticator.authenticate();

        assertTrue(Certificate.getNumOfCert(token) == 0);


        // Test getNumOfCert() Function
    }

    /**
     * Check if the user sucesfully registered
     */
    @Test
    public void RegisterUserTest() {

        String dbpassword = "111";
        Authentication authenticator = new Authentication(dbpassword);
        Token token = authenticator.authenticate();

        assertTrue(Certificate.getNumOfCert(token) == 0);


        // Test getNumOfCert() Function
    }

        /**
     * Check if the user sucesfully registered
     */
    @Test
    public void deleteAllUserTest() {

        SystemManagerDAO.deleteAllUsers();

        assertTrue(SystemManagerDAO.getNumOfUser() == 0);
    }

}