package nl.belastingdienst.fundamentals.extra.lambdas;

public class Rekenmachinedemo {

    public static void main(String[] args) {
        Rekenmachine r = new Rekenmachine();
        r.telOp(1, 2);
        r.vermenigvuldig(4, 5);

        r.voerUit((a, b) -> a - b, 10, 4);
    }
}
