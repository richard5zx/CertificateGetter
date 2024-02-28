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
        String password = "111";
        // Add Certificate
        Certificate.addCertficate("javaocp", password);
        Certificate.addCertficate("javaEE", password);
        Certificate.addCertficate("dp900", password);
        Certificate.addCertficate("az900", password);
        Certificate.addCertficate("sc900", password);
        Certificate.addCertficate("ai900", password);

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(password) == 6);

        // Reset database: Delete all from table
        Certificate.deleteAllCertificates(password);
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(password) == 0);
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteAllCertTest() {
        String password = "111";
        // Delete all from table
        Certificate.deleteAllCertificates(password);

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(password) == 0);
    }

    /**
     * Test the delete all function. It should remove all existing certificate tables and clear the certificates table data
     */
    @Test
    public void deleteCertTest() {
        String password = "111";
        // Add Certificate
        Certificate.addCertficate("javaocp", password);
        Certificate.addCertficate("javaEE", password);
        Certificate.addCertficate("dp900", password);
        Certificate.addCertficate("az900", password);
        Certificate.addCertficate("sc900", password);
        Certificate.addCertficate("ai900", password);

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(password) == 6);

        // Delete 3 certifications
        Certificate.deleteCertficate("javaocp", password);
        Certificate.deleteCertficate("javaEE", password);
        Certificate.deleteCertficate("dp900", password);
        
        // Test getNumOfCert() Function
        int bug = Certificate.getNumOfCert(password);
        System.out.println(bug);
        assertTrue(Certificate.getNumOfCert(password) == 3);
    
        // Delete rest of the certifications
        Certificate.deleteCertficate("az900", password);
        Certificate.deleteCertficate("sc900", password);
        Certificate.deleteCertficate("ai900", password);
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(password) == 0);

        // Make sure everything is deleted from certificate table
        Certificate.deleteAllCertificates(password);
    }
}