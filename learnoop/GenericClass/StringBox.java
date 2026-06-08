package learnoop.GenericClass;
import learnoop.Employer;
import learnoop.User;
public class StringBox {
    public static void main(String[] args) {
        Box<String> stringBox=new Box<>("Hello, World!");
        String text =stringBox.getValue();
        System.out.println(text);


        Box<Integer> intBox=new Box<>(123);
        Integer number=intBox.getValue();
        System.out.println(number);
        Box<User> userBox=new Box<>(new Employer("alice","an@s.com","Tech"));
        User user=userBox.getValue();
        user.showBasicInfo();
        user.showRole();

    }

    
}
