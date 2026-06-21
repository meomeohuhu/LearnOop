package JavaSpring.Product;

public class Product {
    private String id;
    private String name;
    private float price;
    private int stock;
    public Product(String id, String name, float price, int stock){
        this.id=id;
        this.name=name;
        this.price=price;
        this.stock=stock;
    }
    public void getInfo(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Price: "+price);
        System.out.println("Stock: "+stock);
    }
    public String getId() {
        return id;
    }

    
}
