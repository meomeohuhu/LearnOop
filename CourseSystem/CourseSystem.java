package CourseSystem;
import java.util.ArrayList;
import java.util.HashMap;

public class CourseSystem {
    HashMap<String, Course> courses = new HashMap<>();
    HashMap<String, Student>students=new HashMap<>();

    ArrayList<EnrollmentRecord>enrollmentRecords=new ArrayList<>();
    public void addStudent(Student student){
        if(students.containsKey(student.getId())){
            System.out.println("Student with ID " + student.getId() + " already exists.");
        }
        else{
            students.put(student.getId(), student);
        }   
    }
    public void addCourse(Course course){
        if(courses.containsKey(course.getCourseCode())){
            System.out.println("Course with code " + course.getCourseCode() + " already exists.");
        }
        else{
            courses.put(course.getCourseCode(), course);
        }
    }
    public Student findStudent(String studentId){
        if(students.containsKey(studentId)){
            return students.get(studentId);
        }
        else{
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }
    }
    public Course findCourse(String courseCode){
        Course course = courses.get(courseCode);
        if(course == null){
            throw new CourseNotFoundException("Course with code " + courseCode + " not found.");
        }
        return course;
    }
    public void enroll(String studentId, String courseCode){
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);
        
        course.addStudent(student);

        enrollmentRecords.add(
            new EnrollmentRecord(studentId, courseCode, EnrollmentStatus.ENROLLED)
        );
    }
    public void cancelEnrollment(String studentId,String courseCode){
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);
        course.removeStudent(student);
        enrollmentRecords.add(
            new EnrollmentRecord(studentId, courseCode, EnrollmentStatus.DROPPED)
        );
    }
    public void showAllCourses(){
        for(Course course :courses.values()){
            course.showInfo();
            System.out.println("-------------------");
        }
    }
    public void showCourseStudents(String courseCode){
        Course course = findCourse(courseCode);
        course.showStudents();
    }
    public void showRecords(){
        for(EnrollmentRecord record: enrollmentRecords){
            record.showRecord();
            System.out.println("-------------------");
        }
    }
   
    
}
