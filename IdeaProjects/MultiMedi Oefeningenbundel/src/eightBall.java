import java.util.Random;
import java.util.Scanner;

public class eightBall {
    public static void main(String[] args) {
        //Random rand = new Random();
        //Scanner scanner = new Scanner(System.in);
        String[] replies = {"It is certain",
                "It is decidedly so",
                "Without a doubt",
                "Yes -definitely",
                "You may rely on it",
                "As I see it, yes",
                "Most likely",
                "Outlook good",
                "Yes",
                "Signs point to yes",
                "Reply hazy, try again",
                "Ask again later",
                "Better not tell you now",
                "Cannot predict now",
                "Concentrate and ask again",
                "Don’t count on it" ,"My reply is no",
                "My sources say no","Outlook not so good" ,"Very doubtful"};

        /*System.out.println("Ask me a question and I shall reply");

        String question = scanner.nextLine();
        System.out.println("Question asked: " + question);  // Output user input


        System.out.println(replies[rand.nextInt(0, replies.length-1)]);*/

        System.out.println(RandUtil.getRandomEelementFromStringArray(replies));
    }


}
class RandUtil {
    public static String getRandomEelementFromStringArray(String[] repliesFromBall) {

        Random rand = new Random();
        System.out.println("Ask me a question and I shall reply");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.nextLine();
        System.out.println("Question asked: " + question);  // Output user input
        String reply = repliesFromBall[rand.nextInt(0, repliesFromBall.length-1)];

        return reply;
    }
}