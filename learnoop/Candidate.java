package learnoop;

public class Candidate extends User implements NotificationService {
    private String cvUrl;

    public Candidate(String name, String email, String cvUrl) {
        super(name, email);
        this.cvUrl = cvUrl;
    }

    @Override
    public void showRole() {
        System.out.println("Candidate CV: " + cvUrl);
    }

    @Override
    public void send(String message) {
        System.out.println("Send notification to candidate " + name + ": " + message);
    }
}
