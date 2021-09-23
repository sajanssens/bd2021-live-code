package nl.belastingdienst.fundamentals.h11;

import java.util.Iterator;

public class NonAnonymousIterator implements Iterator<Integer> {
    @Override public boolean hasNext() {
        return false;
    }

    @Override public Integer next() {
        return null;
    }
}
