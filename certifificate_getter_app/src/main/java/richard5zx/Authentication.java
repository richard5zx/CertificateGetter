package richard5zx;

import java.util.Scanner;

public class Authentication {
    
    /**
    * Function to retrieve password of database from user 
    * @param Scanner
    * @return String
    */
    public static String getPassword(Scanner scanner) {
        System.out.print("Enter Database password: ");
        String password = scanner.nextLine();
        return password;
    }
}
