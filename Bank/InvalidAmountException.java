package Bank;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Invalid amount. Amount must be positive.");
    }
    public InvalidAmountException(String message) {
        super(message);
    }
    
}
