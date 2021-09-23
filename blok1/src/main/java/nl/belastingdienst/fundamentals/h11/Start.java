package nl.belastingdienst.fundamentals.h11;

import java.util.Iterator;

public class Start {
    public static void main(String[] args) {

        // static via class
        int getal = TopLevel.GETAL;
        TopLevel.StaticNested staticNested = new TopLevel.StaticNested();
        int i = TopLevel.doeWat();

        // non static via objecten van de class
        TopLevel topLevel = new TopLevel();
        String member = topLevel.member;
        TopLevel.Inner inner = topLevel.new Inner();

        Iterator<Integer> anonymousIterator = anonymousIterator();
        Iterator<Integer> methodLocalIterator = methodLocalIterator();
        NonAnonymousIterator nonAnonymousIterator = new NonAnonymousIterator();
    }

    public static Iterator<Integer> anonymousIterator() {
        return new Iterator<>() {

            @Override public boolean hasNext() {
                return false;
            }

            @Override public Integer next() {
                return null;
            }
        };
    }

    public static Iterator<Integer> methodLocalIterator() {
        class MethodLocalIterator implements Iterator<Integer> {

            @Override public boolean hasNext() {
                return false;
            }

            @Override public Integer next() {
                return null;
            }
        }
        return new MethodLocalIterator();
    }
}
