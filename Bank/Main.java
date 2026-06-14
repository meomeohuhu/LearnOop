package Bank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class Main {
   public static void main(String[] args) {
     Bank bank = new Bank();
        Account s1 = new SavingsAccount("S001", "An", 1000);
        Account c1 = new CurrentAccount("C001", "Binh", 200);

        bank.addAccount(s1);
        bank.addAccount(c1);

        bank.deposit("S001", 500);
        s1.withdraw(200);
        c1.withdraw(600);

        s1.showInfo();
        c1.showInfo();
   }
    
}
