package learnoop;
import java.util.HashMap;
public class Hashmap {
      public static void main(String[] args) {
        HashMap<String, User> userMap = new HashMap<>();

        userMap.put("an@gmail.com", new Employer("An", "an@gmail.com", "TTJobs"));
        userMap.put("binh@gmail.com", new Candidate("Binh", "binh@gmail.com", "cv-binh.pdf"));
        User user = userMap.get("an@gmail.com");
        user.showBasicInfo();
        System.out.println(userMap.size());
        for(User User:userMap.values()){
            User.showBasicInfo();
            User.showRole();
        }
        // kiểm tra key tồn tại
        if(userMap.containsKey(user)){
            System.out.println("Key exists");
        }
        userMap.remove("an@gmail.com");
        System.out.println(userMap.size());
        for(String email:userMap.keySet()){
            System.out.println("Key: " + email);
            user.showBasicInfo();
        }
        // hashset sử dụng để tạo ptu không trùng lặp
       

    }
    
}
