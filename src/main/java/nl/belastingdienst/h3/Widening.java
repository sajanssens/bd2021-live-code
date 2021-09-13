package nl.belastingdienst.h3;

public class Widening {

    public static void main(String[] args) {
        // van toepassing op primitives

        short s2 = 900; // signed (met een +/- teken); unsigned (alleen positief) primitive bestaat niet behalve char;
        char c2 = 98;
        // char c2 = -98; // is unsigned!

        // widening = impliciet
        int int4 = (int) c2;

        // narrowing = explicit
        s2 = (short) int4; // mogelijk verlies van de linker 16 bits (want die worden weggegooid).

    }

}
