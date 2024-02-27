package richard5zx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CertificateTest {

    /**
     * Test to add and delete certificates
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

        // Reset database: Delete all from table
        Certificate.deleteAllCertificates("111");
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert("111") == 0);
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteAllCertTest() {
        
        // Delete all from table
        Certificate.deleteAllCertificates("111");

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert("111") == 0);
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteCertTest() {
        // Add Certificate
        Certificate.addCertficate("javaocp", "111");
        Certificate.addCertficate("javaEE", "111");
        Certificate.addCertficate("dp900", "111");
        Certificate.addCertficate("az900", "111");
        Certificate.addCertficate("sc900", "111");
        Certificate.addCertficate("ai900", "111");

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert("111") == 6);

        // Delete 3 certifications
        Certificate.deleteCertficate("javaocp", "111");
        Certificate.deleteCertficate("javaEE", "111");
        Certificate.deleteCertficate("dp900", "111");
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert("111") == 3);
    
        // Delete rest of the certifications
        Certificate.deleteCertficate("az900", "111");
        Certificate.deleteCertficate("sc900", "111");
        Certificate.deleteCertficate("ai900", "111");
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert("111") == 3);
    }
}