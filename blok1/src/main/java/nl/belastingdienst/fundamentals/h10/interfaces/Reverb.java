package nl.belastingdienst.fundamentals.h10.interfaces;

public class Reverb implements Effect {

    // SRP: één verantwoordelijkheid
    public String process(String input) {
        return input + ".....";
    }

}
