public class Stats {

    double attack;
    double defense;
    double health;

    /**
     * Constructor assigns default statistics of attack, defense, and health to a given monster
     * depending on the chosen name.
     * May be duplicate code with default located below.
     */
    public Stats() {
        attack = 50;
        defense = 50;
        health = 100;
    }

    /**
     * Method assigns statistics of attack, defense, and health to a given monster
     * depending on the chosen name.
     *
     * You can assume that this method uses the values it is supposed to use and is correct. 
     */
    public Stats(Mascotmon.Name name) {
        switch (name) {
            case ALBERT:
                attack = 60;
                defense = 40;
                health = 100;
                break;
            case RALPHIE:
                attack = 30;
                defense = 65;
                health = 105;
                break;
            case SPARKY:
                attack = 70;
                defense = 40;
                health = 90;
                break;
            case BULLY:
                attack = 40;
                defense = 40;
                health = 110;
                break;
			default:
                attack = 50;
                defense = 50;
                health = 100;
        }
    }
}
