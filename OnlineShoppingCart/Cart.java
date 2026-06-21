package OnlineShoppingCart;
import java.util.HashMap;
public class Cart {
    HashMap<String, CartItem> Cartitems = new HashMap<>();

    public void addItem(Product product, int quantity){
        if(quantity <=0){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(product.getStock() < quantity){
            throw new IllegalArgumentException("Not enough stock for product: "+product.getProductId());
        }
        if(Cartitems.containsKey(product.getProductId())){
            Cartitems.get(product.getProductId()).increaseQuantity(quantity);
        }
        else{
            Cartitems.put(product.getProductId(), new CartItem(product, quantity));
        }
    }
    public void removeItem(Product product){
        if(Cartitems.containsKey(product.getProductId())){
            Cartitems.remove(product.getProductId());
        }
    }
    public double totalPrice(){
        double total =0;
        for(CartItem cartItem: Cartitems.values()){
            total+= cartItem.getTotal();
        }
        return total;
    }

    

    
}
