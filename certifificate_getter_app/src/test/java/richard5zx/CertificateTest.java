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
    public void getNumOfCertTest() {

        String password = "111";
        Authentication authenticator = new Authentication(password);
        Token token = authenticator.authenticate();

        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(token) == 0);
    }
    
    /**
     * Test to add and delete certificates
     */
    @Test
    public void addCertTest() {

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

        // Reset database: Delete all from table
        Certificate.deleteAllCertificates(token);
        
        // Test getNumOfCert() Function
        assertTrue(Certificate.getNumOfCert(token) == 0);
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
        SystemManager.out.println(bug);
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