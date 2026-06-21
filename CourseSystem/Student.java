package CourseSystem;

public class Student extends Person {
    private String major;
    public Student(String id, String name, String email, String major){
        super(id, name, email);
        this.major=major;
    }
    @Override
    public void showInfo(){
        System.out.println("Student Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Major: " + major);
    }
}
