package Bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    HashMap<String, Account> accounts= new HashMap<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

  
    public void addAccount(Account account){
        accounts.put(account.accountNumber, account);
    }
    Account findAccount(String accountNumber){
        return accounts.get(accountNumber);
    }
    void deposit(String accountNumber,double amount){
       if(amount<=0){
        throw new InvalidAmountException("Deposit amount must be positive.");
       }
       Account account = findAccount(accountNumber);
       if(account==null){
        throw new RuntimeException("Account not found.");
       }
       account.balance += amount;
        transactions.add(new Transaction(accountNumber, TransactionType.DEPOSIT, amount));
      
    }
}
