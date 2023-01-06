package leo;

import java.awt.print.Printable;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;


import static java.lang.Integer.parseInt;


public class App {
    private static Thread plusThread;
    private static Thread dollarThread;

    public static void main(String args[]) throws IOException {
       /* float step = 0.5F;
        double feetConversionRatio = 3.2808399;
        for (float i = 1; i < 5; i+=step) {
            System.out.printf("%.2f meter = %.2f feet \n",i, (i*feetConversionRatio));
            ---------------------------------------------

        int[] numbers = new int[20];
        for(int i=0; i < numbers.length; i+=0){
            numbers[i] = ++i * 7;
        }
        System.out.println(Arrays.toString(numbers));
        ----------------------------------------------------

        int[][] table = new int[4][7];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = i * j;
            }
        }
        for (int[] intArray : table) {
            for (int number : intArray) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        ---------------------------------------------




        System.out.println(Statistics.average(2,4));
        System.out.println(Statistics.min(2,4, 10, 6, 7));
        System.out.println(Statistics.max(2,4, 10, 6, 7));

        ---------------------------------------------------------

        /*Instant thisMoment = Instant.now();
        thisMoment.plusSeconds(42);
        thisMoment.plusMillis(9);
        thisMoment.plusNanos(4);
        System.out.println(thisMoment);*/

        //--------------------------------------------------------

        /*System.out.println("Enter a day of the week as a number: ");
        Scanner keyboard = new Scanner(System.in);
        String startDay = keyboard.next();
        System.out.println("Enter days to be added as a number: ");
        String plusDays = keyboard.next();
        int numberOne = parseInt(startDay);
        int numberTwo = parseInt(plusDays);
        int sum = numberOne + numberTwo;

        DayOfWeek day = DayOfWeek.of(sum);


        System.out.println("This day is " + day);

        LocalDate myDateOfBirth = LocalDate.of(1996, Month.JULY, 17);
        System.out.println(myDateOfBirth);
        System.out.println("Was it a leap year? " + myDateOfBirth.isLeapYear());


        String[] zones = {"Europe/Brussels", "Australia/Sydney", "Australia/Adelaide"};
        for (String zone : zones) {
            ZoneId zoneid = ZoneId.of(zone);
            ZonedDateTime nowTime = ZonedDateTime.now(zoneid);
            System.out.println("At " + zone + ", the time is: " + nowTime);
        }
        ZoneId utcminusfour = ZoneId.ofOffset("UTC", ZoneOffset.ofHours(-4));
        ZonedDateTime nowTimeUMF = ZonedDateTime.now(utcminusfour);

        System.out.println("At UTC-4, the time is now: " + nowTimeUMF);

        Instant now = Instant.now();
        Instant later = now.plusSeconds(3600);

        // Duration
        Duration duration = Duration.between(now, later);

        // ChronoUnit
        long minutes = ChronoUnit.MINUTES.between(now, later);

        // Period
        LocalDate dateOfBirth = LocalDate.of(2000, Month.JANUARY, 5);
        LocalDate today = LocalDate.now();

        Period period = Period.between(dateOfBirth, today);

        System.out.println("Time since you were born: " + period);

        ---------------------------------------------------

        LocalDate today = LocalDate.now();

        System.out.println(today);

        DateTimeFormatter majorityFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(today.format(majorityFormat));

        DateTimeFormatter usaFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(today.format(usaFormat));*/


                /*try {
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Voer het eerste getal in: ");
                    int num = Integer.parseInt(keyboard.next()); //! throws NumberFormatException
                    System.out.println("Voer het tweede getal in: ");
                    int den = Integer.parseInt(keyboard.next()); //! throws NumberFormatException
                    int div = num / den; //! throws ArithmeticException
                    System.out.printf("%d/%d=%d", num, den, div);
                }/*catch (NumberFormatException nfe){
                    System.out.println("Onjuist formaat. Zie foutcode: ");
                    System.out.println(nfe.getMessage());
                    nfe.printStackTrace();
                }
                catch (ArithmeticException ae){
                    System.out.println("Division by zero");
                }
                catch (RuntimeException re){
                    System.out.println("Invalid number");
                    System.out.println(re.getMessage());
                }
                finally {
                    System.out.println("Good bye!"); // will always print, even after an error
                }

                ------------------------------------------------ */
        /*Integer[] numbers = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        Stream<Integer> stream = Stream.of(numbers); // stroom met als bron de array van Integers
        stream = stream.filter(i -> i % 2 != 0); // weg filteren: even getallen. Resultaat is een nieuwe stroom
        stream.forEach(i -> System.out.println(i)); // consumeren van de stream door System.out.println

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer<Integer> method = (n) -> {
            System.out.println(n);
        };
        numbers.forEach(method);*/

        /*IntStream stream = IntStream.range(0, 100); // stroom met als bron de getallen 0 tot 100

        stream = stream.filter(i -> i%2!=0); // weg filteren: even getallen. Resultaat is een nieuwe stroom
        stream.forEach(i -> System.out.println(i)); // consumeren van de stream door System.out.println*/
        // IntStream.range(0, 100).filter(i -> i%2!=0)
        //       .forEach(System.out::println);

       /* int[] array = { 8, 5, 6, 1, 111};
        IntStream stream = IntStream.of(array); // stream maken van de array
        stream = stream.map( i -> i*2); // alle getallen vermenigvuldigen met 2. Resultaat is een nieuwe stroom
        stream.forEach(System.out::println); // print: 16, 10, 12, 2, 222*/

        /*NavigableSet<Integer> numbers = new TreeSet<>();
        numbers.add(4);
        numbers.add(8);
        numbers.add(3);
        System.out.println("** list of numbers **");
        for(int n: numbers){
            System.out.println(n);
        }

        System.out.println("** added 5 **");
        numbers.add(5);
        numbers.forEach(System.out::println);

        System.out.println("** removed 4 **");
        numbers.remove(4);
        numbers.forEach(System.out::println);

        System.out.println("first: " + numbers.first());
        System.out.println("last: " + numbers.last());
        System.out.println("ceiling(7): " + numbers.ceiling(7));
        System.out.println("floor(7): " + numbers.floor(7));
        System.out.println("higher(7): " + numbers.higher(7));
        System.out.println("lower(7): " + numbers.lower(7));*/

        /*
        Path path = Path.of("myFile.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/


/*
        //Gecomprimeerd bestand aanmaken
        FileOutputStream fos = new FileOutputStream("myFile.txt");
        DeflaterOutputStream dos = new DeflaterOutputStream(fos);
        PrintStream ps = new PrintStream(dos);
        FileInputStream fis = null;
        InflaterInputStream iis = null;


        ps.println(2022);
        ps.println("Hallo Java");
        ps.println("Dit bestand is gecomprimeerd.");
        ps.close();
        fos.close();


        //Decomprimeren en weergeven op de terminal. Bestand > FileInputStream > InflaterInputStream > Nakijken geschiktheid (mark()/reset()-bufferedIOstream)
        // > byteArrayOutputStream > byteArray > String


        try {

            // Creates a FileInputStream
            fis = new FileInputStream("myFile.txt");


            //New InflaterInputStream
            iis = new InflaterInputStream(fis);

            byte[] result = new byte[1024];
            int length = 0;


            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            if(iis.markSupported()){
                iis.mark(0);
            }
            if(iis.markSupported()){
                iis.reset();
            }
            while(iis.available() != 0){
                buffer.write(iis.read());
                length++;   //Eigen idee; oplossing onbekende argumentgrootte
            }

            //https://www.tutorialspoint.com/javazip/javazip_inflaterinputstream_read.htm gebruikt een gekende boodschaplengte.
            // Voor een onbekende hoeveelheid tekst, bufferlengte incrementeren bij iedere gelezen lijn uit de inflateinputstream. Voor
            //die lengte (aantal bytes) dan de bufferstroom converteren naar String


            iis.close();
            String message = new String(buffer.toByteArray(),0, length,"UTF-8");
            System.out.println(message);



        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not find file " + fis.getFD());
        }


        //Alternatieve uitlezingsmethode gebasseerd op https://www.inf.unibz.it/~calvanese/teaching/04-05-ip/lecture-notes/uni08/node15.html
        //De InflatedInputStream voeden aan een InputStreamReader die een BufferedReader-object voedt.
        //Zoalng deze niet leeg is (non-null: ready()) steeds een lijn uit de buffer lezen en omzetten naar een String.

        /*InputStreamReader isr = new InputStreamReader(iis);
        BufferedReader br = new BufferedReader(isr);
        while(br.ready()) {         //Eigen idee: .ready()
            String line = br.readLine();
            System.out.println(line);*/


        /*
//Serializable

        String text = new String("This is some text");
        LocalDateTime date = LocalDateTime.now();

        try (FileOutputStream file = new FileOutputStream("MyFile.ser");
             ObjectOutputStream out = new ObjectOutputStream(file);  ) {
            out.writeObject(text);
            out.writeObject(date);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try(FileInputStream fileInputStream = new FileInputStream("MyFile.ser");
            ObjectInputStream in = new ObjectInputStream(fileInputStream);) {
            String textPart = (String) in.readObject();
            LocalDateTime datePart = (LocalDateTime) in.readObject();
            System.out.println(textPart);
            System.out.printf("%td/%<tm/%<tY %<tH:%<tM:%<tS%n", date);
        }catch (FileNotFoundException fnfex){
            System.out.println("Error: File not found");
        }catch (Exception ex ) {
            System.out.println("Error: Input problem: " + ex.getMessage()
                    + " " + ex.getClass().getName());
        }*/

       /* InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(isr);
        System.out.print("Enter a number to square: ");

        try{
            int enterNumber = parseInt(keyboard.readLine());
            System.out.println("Square of " + enterNumber + " = " + Math.pow(enterNumber, 2));
        }catch (Exception ex){
            System.out.println("Oops, something wrong happened!");
            System.out.println(ex.getMessage());
        }

        try( Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter a number to square: ");
            int number = scanner.nextInt();
            System.out.println("Square of " + number + " = " + Math.pow(number, 2));
        }catch (InputMismatchException ime){
            System.out.print("Error: Invalid input detected");
        }


        */


        /*
        // creating list of process
        List<String> list = new ArrayList<String>();
        list.add("notepad.exe");
        //Path path = Paths.get("C:\\Users\\biebu\\Desktop\\xyz.txt");
        //list.add(String.valueOf(path));
        list.add("C:\\Users\\biebu\\Desktop\\xyz.txt");

        // create the process
        ProcessBuilder build = new ProcessBuilder(list);

        // checking the command in list
        System.out.println("command: " + build.command());

        Process process = build.start();*/



        /*PrintThread plusPrinter = new PrintThread('+', 100);
        PrintThread dollarPrinter = new PrintThread('$', 100);

        plusPrinter.start();
        dollarPrinter.start();*//*

        CharacterPrinter plusPrinter = new CharacterPrinter('+', 100);
        CharacterPrinter dollarPrinter = new CharacterPrinter('$', 100);

        //Thread plusThread = new Thread(plusPrinter);
        //Thread dollarThread = new Thread(dollarPrinter);
        Thread plusThread = new Thread(() -> printCharacters('+', 100));
        Thread dollarThread = new Thread(() -> printCharacters('$', 100));
        dollarThread.setDaemon(true);   //dollarPrinter process (dollarThread) will
        //be shut down upon program end. Executed or not.


        plusThread.start();
        dollarThread.start();


        try{
            Thread.sleep(320);
            plusThread.interrupt();
            Thread.sleep(240);
            dollarThread.interrupt();
        } catch(InterruptedException ie) {
            System.out.println("Interrupted");
        }
    }*/

    plusThread = new Thread(() -> printCharactersAndWait('+', 100));
    dollarThread = new Thread(() -> printCharacters('$', 100));

        plusThread.start();
        dollarThread.start();}


    public static void printCharacters(char character, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(character);

        }
    }
    public static void printCharactersAndWait(char character, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(character);
            try {
                dollarThread.join();    //Await execution of the dollarThread- after running the System.out.println once.
            }catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
    }





/*class Statistics {


    public static int average(int... values){
        System.out.println("Average of an integer array");
        int total = 0;
        for( int el: values){
            total += el;
        }
        if( values.length != 0){
            return total / values.length;
        }
        return 0;
    }

    public static int average(int value1, int value2){
        System.out.println("Average of 2 integers");
        return (value1 + value2)/2;
    }

    public static int min(int... values) {
        int min = values[0];
        for( int val: values){
            if(val<min){
                min = val;
            };
        }
        return min;
    }

    public static int max(int... values) {
        int max = values[0];
        for( int val: values){
            if(val>max){
                max = val;
            };
        }
        return max;
    }



}*/




