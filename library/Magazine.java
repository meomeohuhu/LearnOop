package library;

public class Magazine extends LibraryItem {
    private int issueNumber;
    public Magazine(String itemCode, String title, String author, int issueNumber) {
        super(itemCode, title, author, ItemType.MAGAZINE);
        this.issueNumber = issueNumber;
    }
    @Override
    public void showInfo() {
        System.out.println("Magazine Code: " + itemCode);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Status: " + borrowStatus);
    }   
    
}
