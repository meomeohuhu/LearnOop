package githubprofile.practice;

public class Employer extends User implements NotificationService {
    @Override
    public void showProfile() {
        System.out.println("Employer Profile: " + name);
    }
    
    @Override 
    public void send(String message) {
        System.out.println("Sending notification to employer: " + name + " - " + message);
    }
    public Employer(String name,String email, String password){
        super(1L,name,email,password, UserRole.EMPLOYER);
    }
}
 