package richard5zx;

public class Token {

    // Attributes
    private String jdbcURL = "jdbc:postgresql://localhost:5432/certificates";
    private String username = "postgres";
    private String password;
    private boolean validity;

    // Constructor
    public Token(String password, boolean valid) {
        this.password = password;
        this.validity = valid;
    }

    // Getters
    public String getJdbcURL() {
        return this.jdbcURL;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getValidity() {
        return this.validity;
    }
}
