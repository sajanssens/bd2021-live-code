package nl.belastingdienst.fundamentals.h10.interfaces;

public class Delay implements Effect {

    // SRP: één verantwoordelijkheid
    public String process(String input) {
        return input.repeat(2);
    }

}
