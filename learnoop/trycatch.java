package learnoop;
// try-catch-finally
// static của class- không cần khởi tạo trước khi gọi
// static of class- share accros all with out called instance
public class trycatch {
public static void main(String[] args) {
        try {
        int result = 10 / 0;
        System.out.println(result);
    } catch (ArithmeticException e) {
       System.out.println("Error: " + e.getMessage());
    }
    finally {
        System.out.println("This block always executes");
    }
    try{
        User user = findUserByEmail("unknow@gmail.com");
        user.showBasicInfo();
    }catch (UserNotFoundException e){
        System.out.println("Error: " + e.getMessage());
    }
    // check age
    try {
        checkAge(16);
        
    }catch (InvalidAgeExection e){
        System.out.println("Error: " + e.getMessage());
    }
    // readfile
    try{
        readFile("");

    }catch (FileReadException e)
{
        System.out.println("Error: " + e.getMessage());
    
}   
}

   
     public static void checkAge(int age){
        if(age<18){
            throw new InvalidAgeExection("Age must be at least 18" + age);
        }
        System.out.println("Age is valid");
    }
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
    public static void readFile(String filename) throws FileReadException{
        if (filename == null || filename.isEmpty()){
            throw new FileReadException("invalid file name");
        }
    }
    public static User findUserByEmail(String email){
        if(!email.equals("an@gmail.com")){
              throw new UserNotFoundException("User not found: " + email);
        }
        return new Employer("An", "an@gmail.com", "TTJobs");
    }
    public static class InvalidAgeExection extends RuntimeException{
        public InvalidAgeExection(String message){
            super(message);
        }
    }
    public static class FileReadException extends Exception{
        public FileReadException(String message){
            super(message);
        }
    }
}
