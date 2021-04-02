import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;


//import main.java.BearWorkshop;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<BattleScenario> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BattleScenario>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {BattleScenario1.class},
                {BattleScenario2.class},
                {BattleScenario3.class},
                {BattleScenario4.class},
                {BattleScenario5.class}

        };
        return Arrays.asList(classes);
    }

    private BattleScenario createBattleScenario(Mascotmon a, Mascotmon d) throws Exception {
        Constructor<BattleScenario> constructor = classUnderTest.getConstructor(Mascotmon.class, Mascotmon.class);
        System.out.println(constructor);
        return constructor.newInstance(a, d);
    }

    
    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
    }

    // sample test

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception 
     */
    @Test
    public void BvsRSunnyGround() throws Exception {
        
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        
        BattleScenario fight1 = createBattleScenario(attacker1, defender1); 
        System.out.println("    BvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");
        
        //Calculation: 80 * 1 * 1 - 65 * 1 *1
        // 80 put into attack manually, no weather bonuses on either side, Ralphi has 65 defense
        
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 15, 0.2);
    }
    
    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception 
     */
    @Test
    public void RvsBSunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsBSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");

        //Calculation: 80 * 1.2 * 1 * 1 - 40 * 1 *1
        // 80 put into attack manually, Ralhpie gets bonus for ground attack no weather bonuses or type bonus

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 56, 0.2);
    }

    @Test
    public void AvsRDroughtWater() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsRDroughtWater");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(80, "Water");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);
    }

    @Test
    public void SvsRRainyFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsRRainyFire");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(70, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 42, 0.2);
    }

    @Test
    public void SvsBDefaultNone() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsBDefaultNone");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(0, "None");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.2);
    }

    @Test
    public void SvsASunnyNormal() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsASunnyNormal");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Normal");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 25, 0.2);
    }

    @Test
    public void AvsBDefaultWater() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsBDefaultWater");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(100, "Water");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 110, 0.2);
    }

    @Test
    public void BvsADroughtNormal() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsADroughtNormal");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(90, "Normal");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 51, 0.2);
    }

    @Test
    public void AvsBDroughtNormal() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsBDroughtNormal");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(90, "Normal");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 50, 0.2);
    }

    @Test
    public void SvsBRainyNone() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsBRainyNone");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(0, "Normal");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.2);
    }

    @Test
    public void BvsSRainyNone() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsSRainyNone");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(0, "None");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.2);
    }

    @Test
    public void RvsASunnyFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsASunnyFire");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(100, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 50, 0.2);
    }

    @Test
    public void RvsBDefaultGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsBDefaultGround");

        fight1.setEnvironment(Environment.Weather.neutral);
        Attack attack = new Attack(80, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 56, 0.2);
    }
}