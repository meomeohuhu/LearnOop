package learnoop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // tạo các đối tượng
        User employer = new Employer("An", "an@gmail.com", "TTJobs");
        User candidate = new Candidate("Binh", "binh@gmail.com", "cv-binh.pdf");
//  gọi các object method
        employer.showBasicInfo();
        employer.showRole();

        candidate.showBasicInfo();
        candidate.showRole();
        //  gọi đa hình notification

        NotificationService notification = new Employer("Lan", "lan@gmail.com", "DevJobs");
        notification.send("Your job post was approved");

        notification = new Candidate("Minh", "minh@gmail.com", "cv-minh.pdf");
        notification.send("Your application was submitted");
// tạo mảng đối tượng
        User[] users = {
            new Employer("An", "an@gmail.com", "TTJobs"),
            new Candidate("Binh", "binh@gmail.com", "cv-binh.pdf"),
            new Admin("Chi", "chi@gmail.com", "HR")
        };

        for (User user : users) {
            user.showBasicInfo();
            user.showRole();
        }

        System.out.println("total user :" + User.getTotalUsers());
        System.out.println("total employer :" + Employer.getTotalEmployers());

        NotificationService[] services = {
            new Employer("An", "an@gmail.com", "TTJobs"),
            new Candidate("Binh", "binh@gmail.com", "cv-binh.pdf"),
            new Admin("Chi", "chi@gmail.com", "HR")
        };

        for (NotificationService service : services) {
            service.send("This is a notification for " + ((User) service).name);
        }

        System.out.println(AppConstatants.APP_NAME);

        // tạo mảng ArrayList
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new Employer("thinh", "thinh@gmail.com", "TechCorp"));
        userList.add(new Candidate("thinh1", "thinh@gmai1l.com", "TechCorp"));
        userList.add(new Admin("thinh2", "thinh@gmail.com", "TechCorp"));

        for (User u : userList) {
            u.showBasicInfo();
            u.showRole();
        }
// tạo mảng user
        User[] user1 = new User[3];
        user1[0] = new Employer("thinh", null, null);
        user1[1] = new Candidate("thinh1", null, null);
        user1[2] = new Admin("thinh2", null, null);

        for (User u : user1) {
            u.showBasicInfo();
            u.showRole();
        }

        demoArrayListMethods();
        demoArrayMethods();
    }

    private static void demoArrayListMethods() {
        System.out.println("=== ARRAYLIST METHODS ===");

        ArrayList<User> userList = new ArrayList<>();
// thêm mảng
        userList.add(new Employer("Long", "long@gmail.com", "TopCV"));
        userList.add(new Candidate("Hoa", "hoa@gmail.com", "cv-hoa.pdf"));
        userList.add(new Admin("Quan", "quan@gmail.com", "IT"));
//  số lượng phần tử
        System.out.println("size(): " + userList.size());
// lấy phần tử vị trí 1
        User firstUser = userList.get(0);
        System.out.println("get(0):");
        firstUser.showBasicInfo();

        userList.set(1, new Candidate("Mai", "mai@gmail.com", "cv-mai.pdf"));
        System.out.println("After set(1, ...):");
        userList.get(1).showBasicInfo();
// xóa phần tử vị trí 2
        userList.remove(2);
        System.out.println("After remove(2), size(): " + userList.size());

        System.out.println("isEmpty(): " + userList.isEmpty());

        for (User user : userList) {
            user.showBasicInfo();
            user.showRole();
        }

        userList.clear();
        System.out.println("After clear(), size(): " + userList.size());
    }

    private static void demoArrayMethods() {
        System.out.println("=== ARRAY OPERATIONS ===");

        User[] users = new User[3];

        users[0] = new Employer("Nam", "nam@gmail.com", "ViecLam24h");
        users[1] = new Candidate("Linh", "linh@gmail.com", "cv-linh.pdf");
        users[2] = new Admin("Khanh", "khanh@gmail.com", "Admin");

        System.out.println("length: " + users.length);

        User firstUser = users[0];
        System.out.println("users[0]:");
        firstUser.showBasicInfo();

        users[1] = new Candidate("Trang", "trang@gmail.com", "cv-trang.pdf");
        System.out.println("After users[1] = ...:");
        users[1].showBasicInfo();

        users[2] = null;
        System.out.println("After users[2] = null:");

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                System.out.println("users[" + i + "] is empty");
                continue;
            }

            users[i].showBasicInfo();
            users[i].showRole();
        }
    }
}
