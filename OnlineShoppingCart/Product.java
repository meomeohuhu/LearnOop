package OnlineShoppingCart;

public class Product {
    private String name;
    private double price;
    private int stock;
    private String productId;
    public Product(String name, double price, int stock, String productId){
        this.name=name;
        this.price=price;
        this.stock=stock;
        this.productId=productId;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public String getProductId(){
        return productId;
    }
   
    public void showProductDetails(){
        System.out.println("Name: "+name);
        System.out.println("Price: "+price);
        System.out.println("Stock: "+stock);
        System.out.println("Product ID: "+productId);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.productId.equals(other.productId); 
    }
    public int hashCode(){
        return productId.hashCode();
    }
}
