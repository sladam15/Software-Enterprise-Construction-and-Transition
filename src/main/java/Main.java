public class Main {

    /**
     * Main method starts two battles with two different monsters, sets
     * environment, and starts the battle.
     * You can assume that this method uses the values it is supposed to use and is correct.
     */
    public static void main(String[] args) {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);

        // More adaptable code for Task 3.1
        Mascotmon attacker3 = new Mascotmon(Mascotmon.Name.BLUE);
        Mascotmon defender3 = new Mascotmon(Mascotmon.Name.PATTY);
        
        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        //Set the weather
        fight1.setEnvironment(Environment.Weather.sunny);
        //Initiate battle
        fight1.initiateBattle();
        System.out.println("This is the end of the training simulation");

        //Create Second battle scenario with two mons
        BattleScenario fight2 = new BattleScenario(attacker2, defender2); 
        //Set the weather
        fight2.setEnvironment(Environment.Weather.rainy);
        //Initiate battle
        fight2.initiateBattle();
        System.out.println("This is the end of the training simulation");


        // Added code for Task 3.1
        BattleScenario fight3 = new BattleScenario(attacker3, defender3);
        fight3.setEnvironment(Environment.Weather.rainy);
        fight3.initiateBattle();
        System.out.println("This is the end of the training simulation");
    }
}
