package learnoop.Datetime;
import java.time.LocalDate;
import java.time.LocalTime; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Datetime {
   public static void main(String[] args) {
     LocalDate today = LocalDate.now();
    LocalTime now = LocalTime.now();
    LocalDateTime current = LocalDateTime.now();
    System.out.println("Today: " + today);
    System.out.println("Now: " + now);
    System.out.println("Current: " + current);

    LocalDate birthday = LocalDate.of(1990, 5, 15);
    LocalTime meetingTime = LocalTime.of(14, 30);
    LocalDateTime appointment = LocalDateTime.of(2024, 6, 20, 10, 0);
    System.out.println(today.isAfter(birthday)); // true
    System.out.println(today.isBefore(birthday));
    System.out.println(today.isEqual(birthday));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate = current.format(formatter);
    System.out.println("Formatted Date: " + formattedDate);

    String dayText="08/06/2026";
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate parsedDate = LocalDate.parse(dayText, formatter2);
    System.out.println("Parsed Date: " + parsedDate);

    // format time
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = now.format(timeFormatter);
    System.out.println("Formatted Time: " + formattedTime);
    // format datetime
    DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String formattedDateTime = current.format(datetimeFormatter);   
    System.out.println("Formatted DateTime: " + formattedDateTime);
    

   }
    
}
