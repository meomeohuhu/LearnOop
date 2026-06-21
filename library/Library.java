package library;

import java.util.ArrayList;
import java.util.HashMap;

public  class Library {
    HashMap<String, LibraryItem> items = new HashMap<>();
    ArrayList<BorrowRecord>records= new ArrayList<>();
    public void addItem(LibraryItem item){
        items.put(item.itemCode,item);
    }
    public LibraryItem findItem(String itemCode){
        if(items.containsKey(itemCode)){
            return items.get(itemCode);
        } else{
            throw new ItemNotFoundException("Item with code " + itemCode + " not found.");
        }
    }
    public void borrowItem(String itemCode, String userName){
        LibraryItem item=findItem(itemCode);
        if(item.borrowStatus==BorrowStatus.AVAILABLE){
            item.borrowStatus=BorrowStatus.BORROWED;
            records.add(new BorrowRecord(itemCode,"BORROWED",userName));
        }
        else{
            throw new InvalidOperationException("Item with code " + itemCode + " is already borrowed.");
        }
    }
    public void returnItem(String itemCode, String userName){
        LibraryItem item=findItem(itemCode);
        if(item.borrowStatus==BorrowStatus.BORROWED){
            item.borrowStatus=BorrowStatus.AVAILABLE;
            records.add(new BorrowRecord(itemCode, "RETURNED",userName));
        }
        else{
            throw new InvalidOperationException("Item with code " + itemCode + " is not currently borrowed.");
        }
    }
    public void showAllItems(){
        for(LibraryItem item: items.values()){
            item.showInfo();
                System.out.println("-------------------");

        }
    }
    public void showRecords(){
        for(BorrowRecord record:records){
            record.showRecord();
                System.out.println("-------------------");
        }
    }
    
   
    
}

