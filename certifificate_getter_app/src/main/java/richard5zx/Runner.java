package richard5zx;

import java.util.Scanner;

public class Runner {

    public static void runCertMenu() {
        System.out.println("Hello! Welcome to Certificate Getter!");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running) {
            System.out.println();
            System.out.println("List of options:");
            System.out.println("1) Get number of certificates");
            System.out.println("2) List certificates");
            System.out.println("3) Add New Certificates");
            System.out.println("4) Delete existing Certificates");
            System.out.println("5) Select certificate");
            System.out.println("6) Exit application");
            System.out.println();
            System.out.print("Option: ");

            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            System.out.println("Selected input: " + option);

            switch(option) {
                case 1:
                    System.out.println("Get num of certificates selected");
                    System.out.println("Number of Certificates: " + Certificate.getNumOfCert(scanner));
                    break;
                case 2:
                    System.out.println("List certificates selected");
                    Certificate.listCertficates(scanner);
                    break;
                case 3:
                    System.out.println("Add certificates selected");
                    Certificate.addCertficates(scanner);
                    break;
                case 4:
                    System.out.println("Delete certificates selected");
                    Certificate.deleteCertficates(scanner);
                    break;
                case 5:
                    System.out.println("Select certificates selected");
                    String certName = Certificate.selectCertificate(scanner);
                    runQuestionMenu(scanner, certName);
                    break;
                case 6:
                    System.out.println("Exit application, Bye!");
                    return;
                default:
                    System.out.println("Enter a valid selction");
            }
        }

        System.out.println();
        scanner.close();
    }

    public static void runQuestionMenu(Scanner scanner, String string) {
        System.out.println("made it to runQuestionMenu");
        System.out.println("In Progress");
    }
}
