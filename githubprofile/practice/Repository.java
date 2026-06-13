package githubprofile.practice;

import java.util.ArrayList;

public class Repository<T> {
    private ArrayList<T> items=new ArrayList<>();

    public void add(T item){
        items.add(item);
    }
    public ArrayList<T> findAll(){
        return items;
    }
    
}
