package nl.belastingdienst.fundamentals.h2;

public enum Kompas { // enumeratie, opsomming van vaste waardes, since java 5 language feature
    N {
        @Override
        public void doeIets() {
            System.out.println("doeIets NOORD");
        }
    },
    O, Z, W;

    public void doeIets() {
        System.out.println("doeIets");
    }
}
