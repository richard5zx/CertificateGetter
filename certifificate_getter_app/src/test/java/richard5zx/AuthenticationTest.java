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
        // The correct password
        String password = "111";

        Authentication authenticator = new Authentication(password);
        Token token = authenticator.authenticate();

        assertTrue(token.getValidity());
    }

    /**
     * Test a valid password;
     */
    @Test
    public void invalidPassword() {
        // The correct password
        String password = "123";

        Authentication authenticator = new Authentication(password);
        Token token = authenticator.authenticate();

        assertFalse(token.getValidity());
    }
}
