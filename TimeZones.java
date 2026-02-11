import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZones {
    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime ist = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println("GMT Time: " + gmt.format(f));
        System.out.println("IST Time: " + ist.format(f));
        System.out.println("PST Time: " + pst.format(f));
    }
}
