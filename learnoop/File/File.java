package learnoop.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class File {
    public static void main(String[] args)throws IOException {
        Path path = Path.of("C:\\Users\\Thinhpa\\Java\\learnoop\\File\\example.txt");
            Files.writeString(path, "Hello Java File");
            String content = Files.readString(path);
            System.out.println(content);
            if(Files.exists(path)) {
                System.out.println("File exists");
            } else {
                System.out.println("File does not exist");
            }


         List<String> lines= Files.readAllLines(path);
            for(String line :lines){
                System.out.println(line);
            }
            try {
                Files.delete(path);
                System.out.println("File deleted successfully");
            } catch(IOException e) {
                System.out.println("Error deleting file: " + e.getMessage());
            }
}
}

