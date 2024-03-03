package richard5zx;

public class SystemManager {

    public static boolean registerUser(String username, String password) {
        
        // Check if the user is registered in database
        boolean registered = SystemManagerDAO.isRegistered(username, password);
        
        // If user not registed than register the user
        if(!registered) {
            SystemManagerDAO.registerUser(username, password);
            return true;
        } else {
            return false;
        }
    }
}
