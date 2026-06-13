package githubprofile.practice;

public class Admin extends User implements NotificationService {
    @Override
    public void showProfile() {
        System.out.println("Admin Profile: " + name);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending notification to admin: " + name + " - " + message);
    }
    public Admin(String name,String email,String password){
        super(1L,name,email,password,UserRole.ADMIN);
    }
}
