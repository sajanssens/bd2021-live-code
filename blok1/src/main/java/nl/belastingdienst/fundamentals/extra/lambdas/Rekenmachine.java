package nl.belastingdienst.fundamentals.extra.lambdas;

import java.util.function.BiFunction;

public class Rekenmachine {

    public int telOp(int a, int b) {
        return a + b;
    }

    public int vermenigvuldig(int a, int b) {
        return a * b;
    }

    public int voerUit(BiFunction<Integer, Integer, Integer> f, int a, int b) {
        return f.apply(a, b);
    }

}
