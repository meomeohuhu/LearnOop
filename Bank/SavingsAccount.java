package Bank;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance, AccountType.SAVINGS);
    }
    @Override 
    public void withdraw(double amount){
        if (amount <= 0) {
    throw new InvalidAmountException("Withdrawal amount must be positive.");
} else if (amount > balance) {
    throw new InsufficientValanceException("Insufficient funds for withdrawal.");
} else if (balance - amount < 100) {
    throw new InsufficientValanceException("Minimum balance of $100 must be maintained.");
} else {
    balance -= amount;
}

    }
    @Override 
    public void showInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Balance: $" + balance);
        System.out.println("Account Type: " + accountType);

    }
 
}
