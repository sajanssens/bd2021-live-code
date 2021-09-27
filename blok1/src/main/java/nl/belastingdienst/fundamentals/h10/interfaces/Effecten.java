package nl.belastingdienst.fundamentals.h10.interfaces;

public class Effecten {

    // niet closed for modification: want, als ik een effect wil toevoegen, moet ik de code aanpassen.
    // ook niet SRP, want bevat meerdere effecten.
    public String process(String sound) {
        // galm
        sound = sound + ".......";

        // echo
        sound = sound + sound;

        // distortion
        sound = "!!!"+ sound + "!!!";

        return sound;
    }

}
