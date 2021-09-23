package nl.belastingdienst.fundamentals.h4;

public class ExtraOpdrachtLoops {

    public int rekenMaarUit() {
        int som = 0;
        int hits = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                hits++;
                som += hits * i;
            }
        }

        return som;
    }

}
