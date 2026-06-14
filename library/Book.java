package library;

public class Book extends LibraryItem {
    private int pages;
    
    public Book(String itemCode, String title, String author, int pages) {
        super(itemCode, title, author, ItemType.BOOK);
    
        this.pages = pages;
    }
    @Override
    public void showInfo() {
        System.out.println("Book Code: " + itemCode);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Status: " + borrowStatus);
    }
    
}
