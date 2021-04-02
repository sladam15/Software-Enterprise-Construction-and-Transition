/**
 Class: Attack.java

 Description: The following class is an object called
 attack that has certain behaviors of damage and type.
 These can then be given to an individual monster to
 be used in a fight.
 */

public class Attack {

    public String type;
    public double damage;

    public Attack(double damage, String type){
        this.type = type;
        this.damage = damage;
    }


}