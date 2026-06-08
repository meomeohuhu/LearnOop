package learnoop.Hashcode;

public class Student {
    private String email;
    public Student(String email) {
        this.email = email;
    }
    @Override
    public boolean equals(Object obj)
{
    if(this ==obj){
        return true;
    }
    if(!(obj instanceof Student)){
        return false;
    }
    Student student = (Student) obj;
    return java.util.Objects.equals(this.email, student.email);

}
@Override
public int hashCode(){
    return java.util.Objects.hash(email);

}
}