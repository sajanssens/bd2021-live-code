package nl.belastingdienst.fundamentals.h13;

import java.util.List;

public class DoubleProcessor {

    public void processDouble(List<Double> doubleList) {
        for (Double d : doubleList) {
            System.out.println(d.toString());
        }
    }

}

