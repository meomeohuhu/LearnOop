package Bank;

public class Transaction {
    private String accountNumber;
    private TransactionType transactionType;
    private double amount;
    public Transaction(String accountNumber, TransactionType transactionType, double amount){
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }
    
}
