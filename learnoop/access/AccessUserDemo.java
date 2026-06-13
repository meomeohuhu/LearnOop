package learnoop.access;

public class AccessUserDemo {
    public static void main(String[] args) {
        AccessUser user =new AccessUser();
        System.out.println(user.publicName);// Truy cập được vì public
        System.out.println(user.protectedName);// Truy cập được vì cùng package
        System.out.println(user.defaultName);// Truy cập được vì cùng package
        System.out.println(user.getPrivateName());// Truy cập được thông qua phương thức getter
        user.printNames();// Truy cập được vì cùng class
    }
    
}
