package nl.belastingdienst.h10;

public class Flag implements Raisable {

    @Override
    public void raise() {
        System.out.println("Raising the flag");
    }
}
