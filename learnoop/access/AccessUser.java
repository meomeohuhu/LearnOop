package learnoop.access;

public class AccessUser {
    public String publicName="Public User";
    protected String protectedName="Protected User";
    String defaultName="Default User";
    private String privateName="Private User";
    public void printNames() {
        System.out.println(publicName);
        System.out.println(protectedName);
        System.out.println(defaultName);
        System.out.println(privateName);
    }
    public String getPrivateName(){
        return privateName;
    }
    
}
