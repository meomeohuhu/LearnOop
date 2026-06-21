package CourseSystem;

public class EnrollmentRecord {
    private String studentId;
    private String courseCode;
    private EnrollmentStatus status;

    public EnrollmentRecord(String studentId, String courseCode, EnrollmentStatus status) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.status = status;
    }

    public void showRecord() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Status: " + status);
    }

}