/*
  File:	Given
  Author: Sean Adams; Code created by SER316 Professors
  Date:	3/27/21

  Description: The following class determines attributes of
  attack, defense, and health given to particular monsters
  of a particular name.
*/

public class Main {
    public static void main(String[] args) {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);
        
        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        //Set the weather
        fight1.setEnvironment(Environment.Weather.SUNNY);
        //Initiate battle
        fight1.initiateBattle();
        System.out.println("This is the end of the training simulation");

        //Create Second battle scenario with two mons
        BattleScenario fight2 = new BattleScenario(attacker2, defender2); 
//        Set the weather
        fight2.setEnvironment(Environment.Weather.RAINY);
//        Initiate battle
        fight2.initiateBattle();
        System.out.println("This is the end of the training simulation");
    }
}
