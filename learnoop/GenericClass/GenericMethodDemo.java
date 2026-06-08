package learnoop.GenericClass;
import  learnoop.User;
import learnoop.Employer;
public class GenericMethodDemo {
    public static void main(String[] args) {
        printValue("hello");
        printValue(123);
        printValue(new Employer("alice", "an@s.com", "Tech"));
    }
    public static <T> void printValue(T value) {
        System.out.println("Value: " + value);

    }

    // Method này dùng generic T, nhận vào T, trả về T.

    public static <T> T getValuetest(T value) {
        return value;
    }
    String name=getValuetest("Alice");
    Integer number=getValuetest(123);
    User user=getValuetest(new Employer("bob","m@  s.com","HR"));
    
   
}
