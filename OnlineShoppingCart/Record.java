package OnlineShoppingCart;

public class Record {
    private String productId;
    private int quantity;
    private String userid;
    public Record(String productId, int quantity, String userid){
        this.productId = productId;
        this.quantity = quantity;
        this.userid = userid;
    }
    public void showRecord(){
        System.out.println("Product ID: " + productId + ", Quantity: " + quantity + ", User ID: " + userid);
    }

    
}
