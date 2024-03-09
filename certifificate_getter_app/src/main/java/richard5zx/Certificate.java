package richard5zx;

public class Certificate {
    
    // Attributes
    private int cert_id;
    private String cert_name;
    
    // Constructor
    public Certificate(int cert_id, String cert_name) {
        this.cert_id = cert_id;
        this.cert_name = cert_name;
    }

    // Methods
    public int get_cert_id() {
        return this.cert_id;
    }

    public String get_cert_name() {
        return this.cert_name;
    }
}
