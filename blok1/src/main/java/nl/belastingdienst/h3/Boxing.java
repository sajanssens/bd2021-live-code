package nl.belastingdienst.h3;

import java.util.ArrayList;
import java.util.List;

public class Boxing {

    public static void main(String[] args) {
        // boxing
        Integer j = new Integer(42); // deprecated
        Integer k = Integer.valueOf(42);

        // auto boxing
        Integer m = 42;

        // unboxing
        int n = k.intValue();

        // auto unboxing
        int o = k;

        // op eigen class?
        // auto boxing?
        // Author bram = "Bram"; // kan niet!

        // auto unboxing?
        // Author bram = new Author("Bram", 42, false); // constructing
        // var (name, age, islief) = bram; // deconstructing, destructuring

        // Waarom hebben we eigenlijk boxes (instanties van classes,  i.e. objecten)?
        // hoe kan ik anders een author maken?
        String nameVanBram = "Bram";
        int ageVanBram = 42;

        String nameVanLinh = "Linh";
        int ageVanLinh = 27;

        // Specifiek voor wrapper types, i.e. reference type voor iedere primitive:
        // 1) geeft extra functionaliteit.
        int answer = k.intValue();            // instance method
        int answer2 = Integer.parseInt("42"); // static method, utility method
        // 2) Als je generics gebruikt:
        List<Integer> getallen = new ArrayList<>();
        // List<int> getallen = new ArrayList<>(); // not allowed
    }

}
