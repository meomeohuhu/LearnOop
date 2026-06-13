package githubprofile.practice;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Repository<User> userRepository = new Repository<>();
        Candidate candidate = new Candidate("John Doe", "candidate@example.com", "password123");
        Employer employer = new Employer("Jane Smith", "employer@example.com", "password456");
        Admin admin = new Admin("Bob Johnson", "admin@example.com", "password789");
        userRepository.add(candidate);
        userRepository.add(employer);
        userRepository.add(admin);
        for(User user: userRepository.findAll()){
            user.showProfile();
            if(user instanceof NotificationService)
{
    ((NotificationService)user).send("Welcome");
}        }
        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(admin.email, admin);
        userMap.put(candidate.email, candidate);
        userMap.put(employer.email, employer);
        try{
            User foundUser = findUserByEmail(userMap, "admin@example.com");
            System.out.println("Found user" + foundUser.name);
        } catch(UserNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            User foundUser = findUserByEmail(userMap, "admin1@example.com");
            System.out.println("Found user" + foundUser.name);
        } catch(UserNotFoundException e){
            System.out.println(e.getMessage());
        }
        HashSet<User> users = new HashSet<>();
        users.add(candidate);
        users.add(employer);
        users.add(admin);
        users.add(new Candidate("John Doe", "candidate@example.com", "password123"));
        System.out.println("Total unique users: " + users.size());

    }
    public static User findUserByEmail(HashMap<String, User> users, String email) {
            if(users.get(email) == null){
                throw new UserNotFoundException("User with email " + email + " not found");

    }
            return users.get(email);
}

}

