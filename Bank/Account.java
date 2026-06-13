package Bank;

abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;
    protected AccountType accountType;
    public abstract void withdraw(double amount);
    public abstract void showInfo();
    
}
