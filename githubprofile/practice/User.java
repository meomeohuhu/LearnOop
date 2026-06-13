package githubprofile.practice;
import java.util.HashMap;
import java.util.Objects;
abstract class User {
    protected Long id;
    protected String name;
    protected String email;
    protected String password;
    protected UserRole role;

    public User(Long id, String name, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public abstract void showProfile();
    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if (!(obj instanceof User)) return false;
        User user = (User) obj;
        return Objects.equals(email, user.email);

    }
    @Override
    public int hashCode(){
        return Objects.hash(email);
    }
    
}
