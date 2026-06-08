package learnoop;

public class EnumDemo {
    public static void main(String[] args) {
        UserRole role = UserRole.ADMIN;
        if(role==UserRole.ADMIN) {
            System.out.println("Hello Admin");
        } else if(role==UserRole.EMPLOYER) {
            System.out.println("Hello Employer");
        } else if(role==UserRole.CANDIDATE) {
            System.out.println("Hello Candidate");
        }
        switch(role) {
            case ADMIN:
                System.out.println("Hello Admin");
                break;
            case EMPLOYER:
                System.out.println("Hello Employer");
                break;
            case CANDIDATE:
                System.out.println("Hello Candidate");
                break;
        }
    }
    
}
