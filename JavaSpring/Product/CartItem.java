package JavaSpring.Product;

public class CartItem {
    private Product product;
    private int quantity;
    public CartItem(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }
    public void increaseQuantity(int quantity){
        this.quantity+=quantity;
    }
    
    
    
}
