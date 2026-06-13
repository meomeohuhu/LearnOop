package Bank;

public class InsufficientValanceException extends RuntimeException {
    public InsufficientValanceException() {
        super("Insufficient balance. Cannot withdraw the specified amount.");
    }
    public InsufficientValanceException(String message) {
        super(message);
    }
    
}
