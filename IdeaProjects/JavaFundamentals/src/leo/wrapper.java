package leo;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class wrapper {

    public static void main(String args[]) {

        System.out.println("Enter an int as a String. It will be converted to an Integer.");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        Integer integer =  Integer.parseInt(input);
        integer += 25;
        System.out.println(integer);

    }


    }
