package richard5zx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SystemManagerDAOTest {

    /**
     * Add and delete repeated user
     */
    @Test
    public void registeringReapeatedUserTest() {
        SystemManagerDAO.registerUser("user1", "password");
        assertTrue(SystemManagerDAO.getNumOfUser() == 1);

        SystemManagerDAO.registerUser("user1", "password");
        assertTrue(SystemManagerDAO.getNumOfUser() == 1);

        SystemManagerDAO.deleteAllUsers();
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
}