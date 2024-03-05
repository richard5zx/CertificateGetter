package richard5zx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AuthenticationTest {
    /**
     * Test a valid password;
     */
    @Test
    public void validPassword() {
        
        // Test a successful registration and authentication
        String username = "111";
        String password = "111";

        SystemManagerDAO.registerUser(username, password);

        Authentication authenticator1 = new Authentication(username, password);

        assertTrue(authenticator1.getValidity());

        // Test a successful registration and authentication
        String username2 = "asdasd1321";
        String password2 = "243242";

        SystemManagerDAO.registerUser(username2, password2);

        Authentication authenticator2 = new Authentication(username2, password2);

        assertTrue(authenticator2.getValidity());

        SystemManagerDAO.deleteAllUsers();
    }

    /**
     * Test a invalid user;
     */
    @Test
    public void invalidPassword() {
        // Test an unsuccessful registration and authentication

        String username3 = "asdasd1321";
        String password3 = "243242";

        Authentication authenticator3 = new Authentication(username3, password3);

        assertFalse(authenticator3.getValidity());
    }
}
