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
    * Authenticates password
    * @return Token
    */
    public Token authenticate() {
        boolean validity;
        if(enteredPassword.equals(this.correctPassword)) {
            validity = true;
        } else {
            validity = false;
        }

        return new Token(correctPassword, validity);
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
