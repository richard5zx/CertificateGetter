package richard5zx;

import java.util.Scanner;

public class Runner {

    public static void runLogin() {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while(running) {
            System.out.println("Select number of below options:");
            System.out.println("\t1) Enter application (Enter 1)");
            System.out.println("\t2) Exit application (Enter any key)");
            System.out.print("Input: ");

            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);

            switch(choice) {
                case 1:
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    Authentication authenticator = new Authentication(password);
                    if (!authenticator.authenticate()) {
                        System.out.println("Password is incorrect"); 
                    } else  {
                        System.out.println("Password is correct");
                        runCertMenu(scanner, authenticator.getPassword());
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("Auf Wiedersehen :)");
                    return;   
            }
        }
    }

    public static void runCertMenu(Scanner scanner, String password) {
        System.out.println("Hello! Welcome to Certificate Getter!");

        boolean running = true;
        while(running) {
            System.out.println();
            System.out.println("List of options:");
            System.out.println("1) Get number of certificates");
            System.out.println("2) List certificates");
            System.out.println("3) Add New Certificates");
            System.out.println("4) Delete existing Certificates");
            System.out.println("5) Select certificate");
            System.out.println("6) Delete all certificates");
            System.out.println("7) Exit application");
            System.out.println();
            System.out.print("Option: ");

            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            System.out.println("Selected input: " + option);

            switch(option) {
                case 1:
                    System.out.println("Get num of certificates selected");
                    System.out.println("Number of Certificates: " + Certificate.getNumOfCert(password));
                    break;
                case 2:
                    System.out.println("List certificates selected");
                    Certificate.listCertficates(password);
                    break;
                case 3:
                    System.out.println("Add certificates selected");
                    System.out.print("Enter name of new certificate: ");
                    String cert_name = scanner.nextLine();
                    Certificate.addCertficate(cert_name, password);
                    break;
                case 4:
                    System.out.println("Delete certificate selected");
                    System.out.print("Select id of certificate you want to delete");
                    String id = scanner.nextLine();
                    if (HelperFunction.isNumeric(id)) {
                        // Delete from id
                    } else {
                        // Delete from name
                    }
                    Certificate.deleteCertficate(id, password);
                    break;
                case 5:
                    System.out.println("Select certificate to practice: ");
                    String certName = scanner.nextLine();
                    Certificate.selectCertificate(certName, password);
                    break;
                case 6:
                    System.out.println("Delete all certificates selected");
                    Certificate.deleteAllCertificates(password);
                    break;
                case 7:
                    System.out.println("Exit application, Bye!");
                    return;
                default:
                    System.out.println("Enter a valid selction");
            }
        }

        System.out.println();
        scanner.close();
    }

    public static void runQuestionMenu(String string) {
        System.out.println("made it to runQuestionMenu");
        System.out.println("In Progress");
    }
}
