import java.util.*;

public class Customer {

    public String customerName;
    private String Mobile;
    private  String Email;
    private String password;
    private  String accountType;
    private  String accountNumber;
    private  double initialDeposit;
    private Map<String, Account> accounts;
    private ArrayList<Account> account;

    public Customer() {
        this.accounts = new HashMap<>();
        this.account = new ArrayList<>();
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    void CreateAccount(Scanner scanner){


        System.out.println("\nCustomer Information:");
        System.out.print("\nEnter  name: ");
        customerName = scanner.nextLine();

        System.out.print("Enter  Mobile Number: ");
        Mobile = scanner.nextLine();

        System.out.print("Enter  Email: ");
        Email = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        System.out.print("Enter account Type: ");
        accountType = scanner.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        initialDeposit = scanner.nextDouble();

        Account account = new Account(accountNumber, customerName, initialDeposit);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully for " + customerName);


    }

    void customerInfo(){
        System.out.println("\n\nName: " + customerName);
        System.out.println("Mobile Number: " + Mobile);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Email: " + Email);
        System.out.println("Password: " + password);
        System.out.println("InitialDeposit: " + initialDeposit);

    }
    void login(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email=sc.nextLine();
        System.out.print("Enter Password: ");
        String pass=sc.nextLine();
        if(Email.equals(email)&& password.equals(pass)){
            System.out.println("Login Successfully");
        }
        else {
            System.out.println("Invalid Username and Password");
        }
    }
}
