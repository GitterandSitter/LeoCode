package leo;

public class CharacterPrinter implements Runnable {
    private char character;
    private int count;

    public CharacterPrinter (char character, int count) {
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