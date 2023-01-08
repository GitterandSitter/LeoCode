public class Monster {
    private String name;
    private int strength;
    private int maxHP;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHp() {
        return hp;
    }

    private int hp;

    public Monster(String name, int strength, int maxHP, int hp) {
        this.name = name;
        this.strength = strength;
        this.maxHP = maxHP;
        this.hp = hp;
    }
}
