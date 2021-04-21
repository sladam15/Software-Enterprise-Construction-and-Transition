public class Type {   //SER316 TASK 2 SPOTBUGS FIX

    String type;

    public Type() {  //SER316 TASK 2 SPOTBUGS FIX
        type = "Normal";
    }

    /**
     * Method assigns a certain type depending on the monster name.
     * You can assume that this method uses the values it is supposed to use and is correct.
     */
    public Type(Mascotmon.Name name) {   //SER316 TASK 2 SPOTBUGS FIX
        if (name.equals(Mascotmon.Name.ALBERT)) {
            type = "Water";
        } else if (name.equals(Mascotmon.Name.RALPHIE)) {
            type = "Ground";
        } else if (name.equals(Mascotmon.Name.SPARKY)) {
            type = "Fire";
        } else if (name.equals(Mascotmon.Name.BLUE)) {
            type = "Normal";
        } else if (name.equals(Mascotmon.Name.PATTY)) {
            type = "Water";
        } else {
            type = "Normal";
        }
    }
}
