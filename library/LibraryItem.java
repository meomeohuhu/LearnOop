package library;
import library.ItemType;
import library.BorrowStatus;

public abstract class LibraryItem {
    protected String itemCode;
    protected String title;
    protected String author;
    protected BorrowStatus borrowStatus;
    protected ItemType itemType;
    public LibraryItem(String itemCode, String title, String author, ItemType itemType){
            this.itemCode=itemCode;
            this.title=title;
            this.author=author;
            this.itemType=itemType;
            this.borrowStatus=BorrowStatus.AVAILABLE;
    }
    public abstract void showInfo();
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj instanceof LibraryItem){
            LibraryItem other=(LibraryItem) obj;
            return this.itemCode.equals(other.itemCode);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return itemCode.hashCode();
    }
    

}
