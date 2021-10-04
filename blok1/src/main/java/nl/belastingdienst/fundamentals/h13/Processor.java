package nl.belastingdienst.fundamentals.h13;

import java.util.List;

public class Processor<EenVariabelType extends Number> { // type declaration, usually called T

    public void process(List<EenVariabelType> list) {
        for (EenVariabelType item : list) {
            System.out.println(item.doubleValue());
        }
    }

}

