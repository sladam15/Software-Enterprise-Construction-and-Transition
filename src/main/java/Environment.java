/**
 Class:	Environment.java

 Description: The following class determines a particular
 weather environment to account for when a fight occurs.
 If a particular weather environment is present, it may
 give certain buffs or debuffs to certain attacks and health,
 depending on the monster type and other situations.
 */

public class Environment {

    Weather WEATHER;
    String buffedType;
    String DebuffedType;
    double buffModifier;
    double debuffModifier;

    public Environment(){
        this(Weather.NEUTRAL);
    }

    public Environment(Weather weather) {
        this.WEATHER = weather;
        this.buffModifier = 1.25;
        this.debuffModifier = 0.75;
        switch (weather){
            case SUNNY:
               this.buffedType = "Fire";
               this.DebuffedType = "Water";
               break;
            case RAINY:
                this.buffedType = "Water";
                this.DebuffedType = "Fire";
                break;
            case DROUGHT:
                this.buffedType = "Ground";
                this.DebuffedType = "Normal";
                break;
            case NEUTRAL:
                this.buffedType = "";
                this.DebuffedType = "";
                break;
        }
    }

    public String GetBuffedType(){
        return buffedType;
    }

    public String getDebuffedType(){
        return DebuffedType;
    }

    public enum Weather {
        SUNNY, RAINY, DROUGHT, NEUTRAL
    }
}
