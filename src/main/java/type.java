/**
 Class:	type.java

 Description: This class classifies a certain type
 to a monster of a specific name.
 */

public class type
{

    String type;

    public type()
    {
        type = "Normal";
    }


    public type(Mascotmon.Name name)
    {
        if (name.equals(Mascotmon.Name.ALBERT))
            type = "Water";
        else if (name.equals(Mascotmon.Name.RALPHIE))
            type = "Ground";
        else if (name.equals(Mascotmon.Name.SPARKY))
            type = "Fire";
        else
            type = "Normal";
    }
}
