package learnoop;

public class Admin extends User implements NotificationService {
    private String department;
    public Admin(String name, String email, String department){
        super(name,email);
        this.department=department;
    }
    @Override
    public void showRole() {
        System.out.println("Admin Department: " + department);
    }
    public void send(String message) {
        System.out.println("Send notification to admin " + name + ": " + message);
    }
    
    
}
