package richard5zx;

import java.util.Scanner;

public class Runner {

    public static void runLogin() {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while(running) {
            System.out.println("Select number of below options:");
            System.out.println("\t1) Login (Enter 1)");
            System.out.println("\t2) Register account");
            System.out.println("\t2) Exit application (Enter any key)");
            System.out.print("Input: ");

            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);
            
            switch(choice) {
                case 1:
                    System.out.print("Enter password: ");
                    String dbpassword = scanner.nextLine();
                    Authentication authenticator = new Authentication(dbpassword);

                    Token token = authenticator.authenticate();
                    boolean validity = token.getValidity();
                    if (!validity) {
                        System.out.println("Password is incorrect"); 
                        System.out.println();
                    } else  {
                        System.out.println("Password is correct");
                        System.out.println();
                        runCertMenu(scanner, token);
                    }
                    break;

                case 2:
                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();
                    
                    // Register user in database
                    boolean registered = SystemManager.registerUser(username, password);
                    
                    if(registered) {
                        System.out.println("New user is registed, Enter username and password in login menu to login");
                    } else {
                        System.out.println("Account already exists, enter your account in login menu");
                    }
                    break;

                default:
                    System.out.println();
                    System.out.println("Auf Wiedersehen :)");
                    return;
            }
        }
    }

    public static void runCertMenu(Scanner scanner, Token token) {
        
        boolean running = true;
        while(running) {
            System.out.println("Hello! Welcome to Certificate Getter!");
            System.out.println();
            System.out.println("List of options:");
            System.out.println("1) Get number of certificates");
            System.out.println("2) List certificates");
            System.out.println("3) Add New Certificates");
            System.out.println("4) Delete existing Certificates");
            System.out.println("5) Delete all certificates");
            System.out.println("6) Select certificate");
            System.out.println("7) Exit application");
            System.out.println();
            System.out.print("Option: ");

            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            System.out.println("Selected input: " + option);

            switch(option) {
                case 1:
                    System.out.println("Get num of certificates selected");
                    System.out.println("Number of Certificates: " + Certificate.getNumOfCert(token));
                    break;
                case 2:
                    System.out.println("List certificates selected");
                    Certificate.listCertficates(token);
                    break;
                case 3:
                    System.out.println("Add certificates selected");
                    System.out.print("Enter name of new certificate: ");
                    String cert_name = scanner.nextLine();
                    Certificate.addCertficate(cert_name, token);
                    break;
                case 4:
                    System.out.println("Delete certificate selected");
                    System.out.print("Select id or name of certificate you want to delete: ");
                    
                    String cert = scanner.nextLine();
                    
                    if (HelperFunction.isNumeric(cert)) {
                        int id = Integer.parseInt(cert);
                        Certificate.deleteCertficate(id, token);
                    } else {
                        Certificate.deleteCertficate(input, token);
                    }
                    break;
                case 5:
                    System.out.println("Delete all certificates selected");
                    Certificate.deleteAllCertificates(token);
                    break;
                case 6:
                    System.out.print("Select certificate to practice: ");
                    String certName = scanner.nextLine();
                    runQuestionMenu(scanner, certName, token);
                    break;
                case 7:
                    System.out.println("Exit application, Bye!");
                    running = false;
                default:
                    System.out.println("Enter a valid selction");
            }
        }

        System.out.println();
        scanner.close();
    }

    public static void runQuestionMenu(Scanner scanner, String cert, Token token) {
        
        boolean runningMenu = true;
        while (runningMenu) {
            System.out.println("1) Enter a question");
            System.out.println("2) Delete a question");
            System.out.println("3) Modify a question");
            System.out.println("4) Search up question");
            System.out.println("5) Get number of certificates");
            System.out.println("6) List top 15 mistakes");
            System.out.println("7) Practice certificate");
            System.out.println("8) Practice another certificate");
            
            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            System.out.println("Selected input: " + option);
            
            switch(option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                System.out.println("Enter a valid selction");
            }
        }
    }
}
