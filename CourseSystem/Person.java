package CourseSystem;

public abstract class Person {
    protected String id;
    protected String name;
    protected String email;
    public Person(String id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    public abstract void showInfo();
    @Override 
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(!(obj instanceof Person)) return false;
        Person person= (Person)obj;
       return this.id.equals(person.id);
    }
    public int hashCode(){
        return id.hashCode();
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
}
