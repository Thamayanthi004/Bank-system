public class Customer {

    private int accountNo;
    private String name;
    private double balance;
    private String accountType;
    private String email;

    public Customer() {}

    public Customer(int accountNo, String name, double balance, String accountType, String email) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
        System.out.println(accountNo + " | " + name + " | " + balance + " | " + accountType + " | " + email);
    }
}