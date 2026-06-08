package learnoop;

public abstract class User {
    protected String name;
    protected String email;
    protected static int totalUsers=0;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        totalUsers++;
    }

    public void showBasicInfo() {
        System.out.println(name + " - " + email);
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public abstract void showRole();
}
