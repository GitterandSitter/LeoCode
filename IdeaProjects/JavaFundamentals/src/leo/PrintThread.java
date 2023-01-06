package leo;

public class PrintThread extends Thread {
    private char character;
    private int count;

    public PrintThread (char character, int count) {
        this.character = character;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.print(character);
        }
    }
}
