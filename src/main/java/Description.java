public class Description {

    public String description;

    public Description() {
        description = "New mascot";
    }

    /**
     * Method will give a description (nickname) to a certain monster if chosen.
     * @param name   is the name of the chosen monster.
     *
     * May be duplicate code with default located below.
     */
    public Description(Mascotmon.Name name) {
        String n = name.toString();
        if (n.equals("ALBERT")) {
            description = "The Alligator";
        } else if (n.equals("RALPHIE")) {
            description = "The Buffalo";
        } else if (n.equals("SPARKY")) {
            description = "The Sun Devil";
        } else if (n.equals("BULLY")) {
            description = "The Bull Dog";
        } else {
            description = "New mascot";
        }
    }
}
