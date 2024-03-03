package richard5zx;

public class SystemManager {

    public static boolean registerUser(String username, String password) {
        boolean registered = SystemManagerDAO.registerUser(username, password);
        return registered;
    }
    
}
