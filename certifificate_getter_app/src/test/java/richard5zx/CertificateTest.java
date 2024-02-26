package richard5zx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CertificateTest {

    /**
     * Test to add certificates in database
     */
    @Test
    public void addCertTest() {
        // Add Certificate
        Certificate.addCertficate("javaocp", "111");
        Certificate.addCertficate("javaEE", "111");
        Certificate.addCertficate("dp900", "111");
        Certificate.addCertficate("az900", "111");
        Certificate.addCertficate("sc900", "111");
        Certificate.addCertficate("ai900", "111");

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert("111") == 6);

        // Delete all from table
    }
}