package CourseSystem;
import java.util.ArrayList;
public class Course {
    private String courseCode;
    private String title;
    private CourseLevel level;
    private int maxStudents;
    private ArrayList<Student> students =new ArrayList<>();

    public Course(String courseCode, String title, CourseLevel level, int maxStudents){
        this.courseCode=courseCode;
        this.title=title;
        this.level=level;
        this.maxStudents=maxStudents;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void addStudent(Student student){
        if(students.size()<maxStudents){
            for(Student s: students){
                 if (s.equals(student)) {
                    System.out.println("Student wi is already enrolled in the course.");
                    return;  
                }
            }
            students.add(student);
        }
        else{
            throw new CourseFullException("Course " + courseCode + " is full. Cannot add student " + student.getName() + ".");
        }
      
    }
    public void removeStudent(Student student){
        if(students.contains(student)){
            students.remove(student);
        }
        else{
            throw new StudentNotFoundException("Student " + student.getName() + " is not enrolled in the course " + courseCode + ".");
        }
    }
    public boolean isFull(){
        return students.size()>=maxStudents;
    }
    public void showInfo(){
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Level: " + level);
        System.out.println("Max Students: " + maxStudents);
        System.out.println("Enrolled Students:");
        for(Student student: students){
            System.out.println("- " + student.getName());
        }
    }
    public void showStudents(){
        System.out.println("Enrolled Students in " + courseCode + ":");
        for(Student student: students){
            System.out.println("- " + student.getName());
        }
    }
    
    
}
