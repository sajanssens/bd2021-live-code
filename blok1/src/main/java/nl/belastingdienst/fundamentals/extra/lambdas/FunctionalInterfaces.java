package nl.belastingdienst.fundamentals.extra.lambdas;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        // f(x) =  x+1
        // f: x => x+1
        MijnFunctie f = x -> x + 1;

        Supplier<Integer> prod = () -> 42;
        Consumer<Integer> cons = x -> System.out.println(x);
    }

    @FunctionalInterface // a) ter info, b) ter bescherming
    interface MijnFunctie {
        // hoe ziet een lambda van dit type eruit?
        int deMethodenaamBoeitNietZoveel(int n);

        // deze interface heeft precies één abstracte methode: dit is een functional interface,
        // een interface waarmee je een functie beschrijft, dus een lambda.
    }
}
