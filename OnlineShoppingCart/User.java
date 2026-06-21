package OnlineShoppingCart;
import java.util.HashMap;
public class User {
    private String name;
    private String userId;
    private Cart cart;
    HashMap<String, Record> purchaseHistory = new HashMap<>();
    public User(String name){
        this.name=name;
        cart = new Cart();
    }
    
    
}
