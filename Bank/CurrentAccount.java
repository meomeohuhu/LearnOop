package Bank;

public class CurrentAccount extends Account{
    @Override
    public void withdraw(double amount) {
        if(balance - amount<=-500){
            throw new InvalidAmountException();
        }
        else{
            balance -= amount;
        }
    }
    @Override
    public void showInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Balance: $" + balance);
        System.out.println("Account Type: " + accountType);
    }
    
}
