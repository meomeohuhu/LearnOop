package learnoop;

public class Employer extends User implements NotificationService {
    private String company;
    private static int totalEmployers=0;

    public Employer(String name, String email, String company) {
        super(name, email);
        this.company = company;
        totalEmployers++;
    }

    @Override
    public void showRole() {
        System.out.println("Employer at " + company);
    }

    @Override
    public void send(String message) {
        System.out.println("Send notification to employer " + name + ": " + message);
    }
    public static int getTotalEmployers(){
        return totalEmployers;
    }
}
