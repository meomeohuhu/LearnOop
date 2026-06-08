package learnoop;

public class Stringdemo {
    public static void main(String[] args) {
         String text ="java";
        text = text.toUpperCase();
        System.out.println(text);
        // nối chuỗi
        StringBuilder builder = new StringBuilder();
        for(int i=1;i<=5;i++){
            builder.append(i);
        }
        System.out.println(builder.toString());
        // 12345
        builder.insert(0,"Number: ");
        // Number: 12345
        builder.delete(1, 2);
        // Number: 2345
        builder.reverse();
        // 5432 : rebmuN
    }
    
}
