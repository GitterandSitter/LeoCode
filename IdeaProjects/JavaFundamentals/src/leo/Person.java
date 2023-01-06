package leo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Person implements Serializable {

    SimpleDateFormat formatObject = new SimpleDateFormat ("dd-MM-yyyy");

    private String name;
    private String surname;

    Date birthday = formatObject.parse("12-12-2012");






    public Person(String name, String surname, String birthdate) throws ParseException {
        this.name = name;
        this.surname = surname;
        birthday = formatObject.parse(birthdate);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }



}
