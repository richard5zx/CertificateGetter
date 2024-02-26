package richard5zx;

public class Authentication {
    // Attribute
    final String correctPassword = "111";
    private String enteredPassword;

    // Constructor
    public Authentication(String password) {
        this.enteredPassword = password;
    }

    // Method
    /**
    * See if user exist in database. If they do return true. If not return false
    * @param Scanner
    * @return String
    */
    public boolean authenticate() {
        if(enteredPassword.equals(this.correctPassword)) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * Function to retrieve password of database from user 
    * @param Scanner
    * @return String
    */
    public String getPassword() {
        return this.correctPassword;
    }
}
