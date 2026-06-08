package learnoop;

import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
         HashSet<String> roles =new HashSet<>();
        roles.add("Employer");
        roles.add("Candidate");
        roles.add("Admin");
        HashSet<String> skills = new HashSet<>();
        skills.add("Java");
        skills.add("Python");
        skills.add("Java");
        System.out.println("Roles: " + roles);
        if(skills.contains("Java")){
            System.out.println("Java skill exists");
        }
        skills.remove("Python");

        for(String skill:skills){
            System.out.println("Skill: " + skill);
        }
        skills.clear();
        System.out.println("Skills after clear: " + skills);
    }
}
