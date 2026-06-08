package learnoop.Hashcode;
import java.util.HashSet;

public class EqualsHash {
    public static void main(String[] args) {
        Student s1 = new Student("example@gmail.com");
        Student s2 = new Student("example@gmail.com");
        Student s3 = new Student("different@gmail.com");
        System.out.println(s1==s2); // false
        System.out.println(s1.equals(s2));// true1
        HashSet<Student> studens=new HashSet<>();
        studens.add(s1);
        studens.add(s2);
        studens.add(s3);
        System.out.println(studens.size()); // 2




    }

    
}
