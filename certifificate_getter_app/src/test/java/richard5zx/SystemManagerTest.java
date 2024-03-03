package richard5zx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SystemManagerTest {

    /**
     * Add question test
     */
    @Test
    public void RegisterUserTest() {

        String password = "111";
        Authentication authenticator = new Authentication(password);
        Token token = authenticator.authenticate();

        assertTrue(Certificate.getNumOfCert(token) == 0);


        // Test getNumOfCert() Function
    }
}