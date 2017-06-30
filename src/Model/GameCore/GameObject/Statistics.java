package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class Statistics {
    int attack, health, currentHealth, price;
    double armor,speed,attackSpeed;

    public Statistics(int attack, int health, double attackSpeed, double speed, double armor, int cost) {
        this.attack = attack;
        this.health = health;
        this.attackSpeed = attackSpeed;
        this.speed = speed;
        this.armor = armor;
        this.currentHealth = health;
        this.price = cost;
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
     * Gets health.
     * @return Health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets attack speed.
     * @return Attack speed
     */
    public double getAttackSpeed() {
        return attackSpeed;
    }

    /**
     * Gets speed.
     * @return Speed
     */
    public double getSpeed() {
        return speed;
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
     * Gets price.
     * @return current price
     */
    public int getPrice() {
        return price;
    }

}
