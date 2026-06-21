package CourseSystem;

public class Main {
    public static void main(String[] args) {
        CourseSystem system = new CourseSystem();

        Student s1 = new Student("S001", "An", "an@gmail.com", "IT");
        Student s2 = new Student("S002", "Binh", "binh@gmail.com", "Business");
        Student s3 = new Student("S003", "Chi", "chi@gmail.com", "Design");

        Course c1 = new Course("JAVA101", "Java Core", CourseLevel.BEGINNER, 2);
        Course c2 = new Course("SPRING201", "Spring Boot", CourseLevel.INTERMEDIATE, 1);

        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);

        system.addCourse(c1);
        system.addCourse(c2);

        system.enroll("S001", "JAVA101");
        system.enroll("S002", "JAVA101");

            system.showAllCourses();
            system.showCourseStudents("JAVA101");
            system.showRecords();
            system.showCourseStudents("SPRING201");
        
        
    }
    
}
