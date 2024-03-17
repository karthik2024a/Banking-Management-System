import java.util.*;
public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer bank = new Customer();
        System.out.println("\n***********************************************");
        System.out.println("BANKING MANAGEMENT SYSTEM");
        System.out.println("***********************************************\n");

        while (true) {

            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Transfer Amount");
            System.out.println("5. Account Info");
            System.out.println("6. Display Last Transaction");
            System.out.println("7. Display Balance");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:

                    bank.CreateAccount(scanner);

                    break;
                case 2:
                    bank.login();

                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    Account depositAccount = bank.getAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter source account number: ");
                    String sourceAccountNumber = scanner.nextLine();
                    Account sourceAccount = bank.getAccount(sourceAccountNumber);

                    System.out.print("Enter destination account number: ");
                    String destinationAccountNumber = scanner.nextLine();
                    Account destinationAccount = bank.getAccount(destinationAccountNumber);

                    if (sourceAccount != null && destinationAccount != null) {
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        sourceAccount.transfer(destinationAccount, transferAmount);
                    } else {
                        System.out.println("One or both accounts not found.");
                    }
                    break;

                case 5:
                    bank.customerInfo();
                    break;


                case 6:
                    System.out.print("Enter account number: ");
                    String displayTransactionAccountNumber = scanner.nextLine();
                    Account displayTransactionAccount = bank.getAccount(displayTransactionAccountNumber);
                    if (displayTransactionAccount != null) {
                        displayTransactionAccount.displayLastTransaction();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter account number: ");
                    String displayAccountNumber = scanner.nextLine();
                    Account displayAccount = bank.getAccount(displayAccountNumber);
                    if (displayAccount != null) {
                        displayAccount.displayBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}