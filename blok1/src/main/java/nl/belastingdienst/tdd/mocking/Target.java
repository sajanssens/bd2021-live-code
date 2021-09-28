package nl.belastingdienst.tdd.mocking;

public class Target {

    private Dependency d = new Dependency();

    int methode() {
        int getal = 4;
        // ..
        // ..
        int x = d.x();
        x = d.x();
        // ..
        // ..

        return getal * x;
    }

    public void setD(Dependency d) {
        this.d = d;
    }
}
