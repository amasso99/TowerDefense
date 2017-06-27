package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class Statistics {
    int attack, health, attackSpeed, currentHealth, mana, level;
    double armor,speed;

    public Statistics(int attack, int health, int attackSpeed, double speed, double armor, int level, int cost) {
        this.attack = attack;
        this.health = health;
        this.attackSpeed = attackSpeed;
        this.speed = speed;
        this.armor = armor;
        this.currentHealth = health;
        this.level = level;
        this.mana = cost;
    }

    public void levelUp(){
        this.attack = (int) (1.2 * attack);
        this.health = (int) (health * 1.2);
        this.attackSpeed = (int) (1.1 * attackSpeed);
        this.speed = (1.1 * speed);
        this.armor = armor * 1.1;
        this.level++;

        if(level < 5) {
            this.mana = (int) (mana * 1.2);
        } else {
            this.mana = (int) (mana * 1.1);
        }
    }

    public void receiveDamage(int ad){
        currentHealth = (int) (currentHealth - (ad*(100 /(100+armor))));
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

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

}
