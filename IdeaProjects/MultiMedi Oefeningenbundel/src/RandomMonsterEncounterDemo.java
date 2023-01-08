import java.util.Random;
import java.util.Scanner;


/** D&D derivation:
 * * Ask five times what to do when a certain monster is encountered in
 * a certain environment, all collected and constructed from individual lists.
 * No user input was implemented. See EightBall class (same package) for demonstration of that functionality.
 */

public class RandomMonsterEncounterDemo {

    static Monster[] monsterReeks = new Monster[3]; //Outside of main for use outside of it.
    public static void main(String[] args){

        String[] names = {"Sully", "Mike", "Randall"};
        int[] strengths = {83, 64, 78};
        for (int i=0; i< names.length; i++){
            monsterReeks[i] = new Monster(names[i], strengths[i], 100, 100);
        }
        for (int i=0; i < 5; i++){
            randomMonsterEncounter(monsterReeks);};
        /*for (Monster monster : monsterReeks) {
            System.out.println(monster.getName());*/ //Test enumeration to fix Array length issue. Remains to solve problems which might arise.
        }
    public static Monster[] returnMonsterArray() {
        return monsterReeks;
    }

    private static void randomMonsterEncounter(Monster[] reeks){
        Monster currentMonster = MonsterRandUtil.getRandomElementFromMonsterArray(reeks); // To preserve attributes belonging to one monster-object
        String[] environments = {"the mall", "the forest", "a cemetery", "an abandoned parking lot", "the backrooms"};
        System.out.println("You walk through " + environments[MonsterRandUtil.rand.nextInt(environments.length)]);
        System.out.println("and you encounter a " + currentMonster.getName());
        System.out.println("It has a strength of " + currentMonster.getStrength()
        + " and a maximum health of " + currentMonster.getMaxHP());
        System.out.println(" What will you do?: \n .Fight \n .Run \n .Hide");
    }
}

class MonsterRandUtil {
    static Random rand = new Random();
    public static Monster getRandomElementFromMonsterArray(Monster[] monsterkes) {
        Monster monster = monsterkes[rand.nextInt(monsterkes.length)];
        return monster;
    }
}
