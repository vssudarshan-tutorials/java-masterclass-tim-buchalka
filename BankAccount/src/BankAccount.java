public class BankAccount {

    private long accountNumber, phoneNumber;
    private double balance;
    private String custName, custEmail;

    public BankAccount(){
        this("name",0, 0, "mail");
        setCustName("Ravi");
        setAccountNumber(234673144);
        setBalance(120000.00);
        setPhoneNumber(998837261);
        setCustEmail("ppp@gmail.com");
    }

    public BankAccount(String name, double d, long p, String mail){
        this("name", "mail");
        custName = name;
        balance = d;
        phoneNumber = p;
        custEmail = mail;
    }

    public BankAccount(String name, String mail){
        custName = name;
        custEmail = mail;
    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public boolean canWithdraw(long amount) {
        return balance - amount >= 0;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void withdraw(long amount) {
        if (canWithdraw(amount))
            balance -= amount;
    }

}
