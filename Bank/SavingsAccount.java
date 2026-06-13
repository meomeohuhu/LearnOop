package Bank;

public class SavingsAccount extends Account {
    @Override 
    public void withdraw(double amount){
        if(amount<=0){
            throw new InvalidAmountException("Withdrawal amount must be positive.");

        }
        else if(balance - amount <100){
            System.out.println("Insufficient balance. Minimum balance of $100 must be maintained.");

        }
        else if(amount> balance){
            throw new InsufficientValanceException("Insufficient funds for withdrawal.");
        }
        else{
            balance -= amount;
        }

    }
    @Override 
    public void showInfo(){

    }
 
}
