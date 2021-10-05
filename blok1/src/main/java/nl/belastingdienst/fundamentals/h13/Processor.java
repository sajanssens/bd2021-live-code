package nl.belastingdienst.fundamentals.h13;

import java.util.List;
//                     type parameter
public class Processor<N extends Number> { // type declaration, usually called T (some type), R (some returntype), V (type of some value), K (type of some key)

    public void process(List<N> list) {
        for (N number : list) {
            System.out.println(number.doubleValue());
        }
    }

}

