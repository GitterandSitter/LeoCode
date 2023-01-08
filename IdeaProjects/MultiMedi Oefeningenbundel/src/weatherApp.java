import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class weatherApp {
    public static String[] weerStatussen = {"Zonnig", "Lichte buien", "Stormweer", "Hagel"};

    public static void main(String[] args) {

        LocalDate lt = LocalDate.now();
        DayOfWeek weekDay = lt.getDayOfWeek();
        Random rand = new Random();

        System.out.println("**********\nWeather App\n**********\n");

        for (int i= 0; i<7; i++){
            System.out.println(weekDay.plus(i) + "-" + lt.plusDays(i));
            System.out.println("***********");
            System.out.println(weerStatussen[rand.nextInt(0, weerStatussen.length - 1)]+"\n");
        };
    }
}
