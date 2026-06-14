package library;

public class BorrowRecord {
    private String itemCode;
    private String action;
    private String userName;
    public BorrowRecord(String itemCode, String action,String userName){
        this.itemCode = itemCode;
        this.action = action;
        this.userName = userName;
    }
    public void showRecord(){
        System.out.println("Item Code: " + itemCode + ", Action: " + action + ", User Name: " + userName);
    }
}
