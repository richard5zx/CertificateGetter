public class Main {
    public static void main(String[] args) {

        Runner.runCertMenu();
        
        String sql = "CREATE TABLE IF NOT EXISTS table (\n"
                 + "    CertificateID int PRIMARY KEY,\n"
                 + "    QuestionID int UNIQUE, \n"
                 + "    Question varchar(255) NOT NULL, \n"
                 + "    Mistakes int DEFAULT 0, \n"
                 + "    DateAdded TIMESTAMP NOT NULL \n"
                 + ");";

        sql = "CREATE TABLE IF NOT EXISTS table ("
                 + "    CertificateID int PRIMARY KEY,"
                 + "    QuestionID int UNIQUE,"
                 + "    Question varchar(255) NOT NULL,"
                 + "    Mistakes int DEFAULT 0,"
                 + "    DateAdded TIMESTAMP NOT NULL"
                 + ");";
        

    }
}