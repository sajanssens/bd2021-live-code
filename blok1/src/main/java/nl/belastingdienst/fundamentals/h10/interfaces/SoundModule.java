package nl.belastingdienst.fundamentals.h10.interfaces;

import java.util.ArrayList;
import java.util.List;

public class SoundModule {

    // SRP: mijn verantwoordelijkheid is ontvangen van geluid, door een processor halen en afspelen.
    // verantwoordelijkheid = een reden voor omvallen, of aanpassen
    public static void main(String[] args) {
        List<Effect> effects = new ArrayList<>();
        effects.add(new Reverb()); // als we dit dynamisch maken met een voegToe(Effect e) methode wordt het helemaal goed uitbreidbaar.
        effects.add(new Delay());

        String sound = "Vader jacob, Vader jacob";

        String output = sound;

        for (Effect effect : effects) {
            output = effect.process(output);
        }

        System.out.println(output);
    }

}
