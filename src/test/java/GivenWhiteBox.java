import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;


public class GivenWhiteBox {
    @Before
    public void setUp() throws Exception {
    }


    /**
     * This is not deterministic if total damage is calculated correctly. Try to find out why and what the problem is.
     * Then make changes so that the battle outcome IS deterministic!
     * The battle mechanic will need to change for this but you should try to make 
     * the least amount of changes possible
     */
    @Test
    public void BvsRsunny() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        //Set the weather
        fight1.setEnvironment(Environment.Weather.sunny);

        Mascotmon mon = fight1.fight();
        assertEquals(mon, attacker1);
    }

    // Node coverage test case will visit every node in path
    // 1-15 nodes are all executed in BattleScenario.java
    // Both node coverage and edge coverage are similar here because
    // there's parts of the code that repeat because of a monster
    // fainting or not
    @Test
    public void testNodeCoverage() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        System.out.println("    testNodeCoverage");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(70, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 42, 0.2);
    }

    // Edge coverage test case will visit every node in path
    // All branches of code have been executed each once in BattleScenario.java
    // The while loop creates a lot of possibilities for each branch to execute
    @Test
    public void testEdgeCoverage() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        System.out.println("    testEdgeCoverage");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 15, 0.2);
    }

}