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

    /**
     * Sets currentHealth minus the received damage.
     * @param ad Received damage
     */
    public void receiveDamage(int ad){
        currentHealth = (int) (currentHealth - (ad*(100 /(100+armor))));
        System.out.println("Ouch! : "+currentHealth+"/"+health);
    }

    /**
     * Gets attack style.
     * @return Attack style
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Sets attack style.
     * @param attack Attack style
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Gets health.
     * @return Health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health.
     * @param health Health to be set.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets attack speed.
     * @return Attack speed
     */
    public int getAttackSpeed() {
        return attackSpeed;
    }

    /**
     * Sets attack speed
     * @param attackSpeed Attack speed to be set
     */
    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    /**
     * Gets speed.
     * @return Speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets speed.
     * @param speed Speed to be set.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Gets current health.
     * @return Current health.
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Sets health
     * @param currentHealth Health amount to be set
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Gets armor value.
     * @return Armor value
     */
    public double getArmor() {
        return armor;
    }

    /**
     * Sets armor value.
     * @param armor Armor value to be set
     */
    public void setArmor(double armor) {
        this.armor = armor;
    }

    /**
     * Gets level.
     * @return Current level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level.
     * @param level Level to be set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets mana.
     * @return current mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * Sets mana.
     * @param mana Mana to be set
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

}
