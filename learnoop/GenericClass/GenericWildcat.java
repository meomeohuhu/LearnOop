package learnoop.GenericClass;
import learnoop.User;
import learnoop.Employer;
import java.util.ArrayList;
import learnoop.Candidate;
// 1. Vấn đề

// Bạn có:

// ArrayList<Employer> employers = new ArrayList<>();
// ArrayList<Candidate> candidates = new ArrayList<>();
// Cả Employer và Candidate đều là User.

// Nhưng method này:

// public static void printUsers(ArrayList<User> users) {
// }
// không nhận được:

// ArrayList<Employer>
// Dù Employer extends User.

// Lý do: ArrayList<Employer> không phải là con của ArrayList<User>.

public class GenericWildcat {
    public static void main(String[] args) {
        ArrayList<Employer> employers = new ArrayList<>();
        employers.add(new Employer("alice", "m@gmail.com", "Tech"));
        ArrayList<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("bob", "b@gmail.com", "Computer Science"));
        prinUsers(employers);
        prinUsers(candidates);
        ArrayList<User> users = new ArrayList<>();
        addEmployer(users);
        prinUsers(users);

    }
//     ArrayList<Employer> không phải ArrayList<User>.
// ? extends User giúp nhận list User hoặc list class con của User.
// ? super Employer giúp add Employer vào list an toàn.
    // lay du lieu ra
    public static void prinUsers(ArrayList<? extends User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
    // lưu dữ liêu jvaof ArrayList<? super Employer> employers
    public static void addEmployer(ArrayList<? super Employer> users) {
        users.add(new Employer("thomas", "t@gmail.com", "Marketing"));
    }
    
}
