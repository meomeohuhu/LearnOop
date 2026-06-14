package library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

LibraryItem b1 = new Book("B001", "Clean Code", "Robert Martin", 464);
LibraryItem b2 = new Book("B002", "Effective Java", "Joshua Bloch", 416);
LibraryItem m1 = new Magazine("M001", "Tech Monthly", "John Smith", 12);

library.addItem(b1);
library.addItem(b2);
library.addItem(m1);

library.showAllItems();

library.borrowItem("B001", "An");
library.returnItem("B001", "An");

library.showRecords();
    }
    
}
