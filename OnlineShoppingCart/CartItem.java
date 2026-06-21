package OnlineShoppingCart;
import java.util.HashMap;
public class CartItem {
    private Product product;
    private int quantity;
    public CartItem(Product product, int quantity){
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(quantity <=0){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if(product.getStock() < quantity){
            throw new IllegalArgumentException("Not enough stock for product: "+product.getProductId());
        }
        this.product=product;
        this.quantity=quantity;
    }

    public Product getProduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }
    public double getTotal(){
        return product.getPrice()*quantity;
    }
    public void showItem(){
        System.out.println("Product: "+product.getName());
        System.out.println("Quantity: "+quantity);
        System.out.println("Total Price: "+getTotal());
    }
    public void increaseQuantity(int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        int newquantity=this.quantity += quantity;
        if(newquantity>product.getStock()){
            throw new IllegalArgumentException("Not enough stock for product: "+product.getProductId());
        }
        this.quantity=newquantity;
    }
}
