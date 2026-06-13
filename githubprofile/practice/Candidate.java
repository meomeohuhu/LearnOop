package githubprofile.practice;

public class Candidate extends User implements NotificationService {
    @Override
    public void showProfile() {
        System.out.println("Candidate Profile: " + name);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending notification to candidate: " + name + " - " + message);
    }
    public Candidate(String name,String email,String password){
        super(1L,name,email,password,UserRole.CANDIDATE);
    }

}
