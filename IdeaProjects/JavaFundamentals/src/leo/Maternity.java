package leo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Maternity implements Serializable {

    static Person newBorn;

    static {
        try {
            newBorn = new Person("John", "Thomas", "12-12-2012");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try (FileOutputStream file = new FileOutputStream("MyFile.ser");
             ObjectOutputStream out = new ObjectOutputStream(file);  ) {
            out.writeObject(newBorn.getName());
            out.writeObject(newBorn.getSurname());
            out.writeObject(newBorn.getBirthday());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        CiviService.printPersonDetails();
    }
    }
