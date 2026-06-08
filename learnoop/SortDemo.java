package learnoop;
import java.util.ArrayList;
import java.util.Collections;
public class SortDemo {
    public static void main(String[] args) {
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");   
        skills.add("C++");

        Collections.sort(skills);
        System.out.println("Sorted skills: " + skills);

        ArrayList<User> users = new ArrayList<>();
        users.add(new Employer("An", "long@gmail.com    ", "TTJobs"));
        users.add(new Candidate("Binh", "      b@gmail.com", "cv-binh.pdf"));
        users.add(new Admin("Chi", "chi@gmail.com", "HR"));
        users.sort((u1, u2) -> u1.name.compareTo(u2.name));
        
        for(User user : users){
             user.showBasicInfo();
         }
         // sắp xếp theo email
        
    }
    
}
