public class Environment {

    Weather WEATHER;
    String buffedType;
    String debuffedType;
    double buffModifier;
    double debuffModifier;

    public Environment() {
        this(Weather.neutral);
    }

    /**
     * Method assigns a certain buffer (1.25) or a debuffer (.75) to
     * monsters if their types are against another type which they
     * may get stronger or weaker against.
     * You can assume that this method uses the values it is supposed to use and is correct.
     */
    public Environment(Weather weather) {
        this.WEATHER = weather;
        this.buffModifier = 1.25;
        this.debuffModifier = 0.75;
        switch (weather) {
            case sunny:
                this.buffedType = "Fire";
                this.debuffedType = "Water";
                break;
            case rainy:
                this.buffedType = "Water";
                this.debuffedType = "Fire";
                break;
            case drought:
                this.buffedType = "Ground";
                this.debuffedType = "Normal";
                break;
            default:
                this.buffedType = "";
                this.debuffedType = "";
                break;
        }
    }

    public String getBuffedType() {   //SER316 TASK 2 SPOTBUGS FIX
        return buffedType;
    }

    public String getDebuffedType() {
        return debuffedType;
    }

    public enum Weather {
        sunny, rainy, drought, neutral
    }
}
