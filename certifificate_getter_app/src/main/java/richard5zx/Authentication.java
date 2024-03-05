package richard5zx;

public class Authentication {
    
    // Attribute
    Token token;

    // Constructor
    public Authentication(String username, String password) {
        this.token = authenticate(username, password);
    }

    // Method
    /**
    * Authenticates password
    * @return Token
    */
    public Token authenticate(String username, String password) {
        
        boolean valid = AuthenticationDAO.authenticateUser(username, password);
        
        if(valid) {
            return new Token(valid);
        } else {
            return new Token(valid);
        }
    }

    /**
    * Function to retrieve password of database from user 
    * @param Scanner
    * @return String
    */
    public boolean getValidity() {
        return token.getValidity();
    }
}
