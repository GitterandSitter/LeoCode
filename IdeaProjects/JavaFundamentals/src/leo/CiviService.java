package leo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CiviService implements Serializable {
    public static void printPersonDetails() {
        try (
                FileInputStream fileInputStream = new FileInputStream("MyFile.ser");
                ObjectInputStream in = new ObjectInputStream(fileInputStream);) {
            String name = (String) in.readObject();
            String surname = (String) in.readObject();
            //String birthday = (String) in.readObject();
            Date birthday = (Date) in.readObject();
            System.out.println("Name: " + name + " Surname: " + surname);
            System.out.printf("%td/%<tm/%<tY", birthday);
        } catch (
                FileNotFoundException fnfex) {
            System.out.println("Error: File not found");
        } catch (Exception ex) {
            System.out.println("Error: Input problem: " + ex.getMessage()
                    + " " + ex.getClass().getName());
        }
    }
}
