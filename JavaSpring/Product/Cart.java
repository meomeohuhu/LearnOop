package JavaSpring.Product;
import java.util.HashMap;
import java.util.Map;
import JavaSpring.Product.CartItem;
public class Cart {
    private Map<String,CartItem> items;
    private int id;
    public Cart(int id){
        this.id=id;
        this.items=new HashMap<>();
    }
    public Map<String,CartItem> getItems(){
        return items;
    }
   public void addItem(Product product,int quantity){
    CartItem item= items.get(product.getId());
    if(item == null){
        items.put(
            product.getId(),
            new CartItem(product, quantity)
        );
    } else {
        item.increaseQuantity(quantity);
    }
   }
   public boolean removeItem(String productId){
    return items.remove(productId) != null;
   }
   
   
}
