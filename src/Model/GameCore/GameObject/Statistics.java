package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class Statistics {
    int attack, health, range, attackSpeed, speed, currentHealth, mana, level;
    double armor;
    boolean ground, aimsGround;

    public Statistics(int attack, int range, int health, int attackSpeed, int speed, double armor, boolean ground, boolean aimsGround, int level, int cost) {
        this.attack = attack;
        this.range = range;
        this.health = health;
        this.attackSpeed = attackSpeed;
        this.speed = speed;
        this.armor = armor;
        this.currentHealth = health;
        this.ground = ground;
        this.aimsGround = aimsGround;
        this.level = level;
        this.mana = cost;
    }

    public void levelUp(){
        double percent = currentHealth / health;
        this.attack = (int) (1.2 * attack);
        this.range = (int) (range * 1.1);
        this.health = (int) (health * 1.2);
        this.attackSpeed = (int) (1.1 * attackSpeed);
        this.speed = (int) (1.1 * speed);
        this.armor = armor * 1.1;
        this.level++;
        if(level < 5) {
            this.mana = (int) (mana * 1.2);
        } else {
            this.mana = (int) (mana * 1.1);
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isGround() {
        return ground;
    }

    public boolean isAimsGround() {
        return aimsGround;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setGround(boolean ground) {
        this.ground = ground;
    }

    public void setAimsGround(boolean aimsGround) {
        this.aimsGround = aimsGround;
    }
}
