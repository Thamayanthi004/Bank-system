import java.util.*;

public class Main {

    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    
    public static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Account Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        customers.add(new Customer(accNo, name, balance, type, email));
        System.out.println("Account Created Successfully!");
    }

   
    public static Customer search(int accNo) {
        for (Customer c : customers) {
            if (c.getAccountNo() == accNo) {
                return c;
            }
        }
        return null;
    }

    // Deposit
    public static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Customer c = search(accNo);
        if (c != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            c.setBalance(c.getBalance() + amt);
            System.out.println("Amount Deposited!");
        } else {
            System.out.println("Account not found!");
        }
    }

    
    public static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Customer c = search(accNo);
        if (c != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();

            if (c.getBalance() >= amt) {
                c.setBalance(c.getBalance() - amt);
                System.out.println(" Withdrawal Successful!");
            } else {
                System.out.println(" Insufficient Balance!");
            }
        } else {
            System.out.println(" Account not found!");
        }
    }

    
    public static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Customer c = search(accNo);
        if (c != null) {
            System.out.println("Balance: " + c.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

   
    public static void transfer() {
        System.out.print("From Account: ");
        int from = sc.nextInt();

        System.out.print("To Account: ");
        int to = sc.nextInt();

        Customer sender = search(from);
        Customer receiver = search(to);

        if (sender != null && receiver != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();

            if (sender.getBalance() >= amt) {
                sender.setBalance(sender.getBalance() - amt);
                receiver.setBalance(receiver.getBalance() + amt);
                System.out.println("Transfer Successful!");
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Invalid Accounts!");
        }
    }

    
    public static void displayAll() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer c : customers) {
            c.display();
        }
    }

    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Search");
            System.out.println("7. Display All");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: checkBalance(); break;
                case 5: transfer(); break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    Customer c = search(sc.nextInt());
                    if (c != null) c.display();
                    else System.out.println(" Not found");
                    break;
                case 7: displayAll(); break;
                case 8:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println(" Invalid choice");
            }
        }
    }
}