package nl.belastingdienst.h3;

import nl.belastingdienst.h7.Author;

public class Operators {

    public static void main(String[] args) {
        int som = 1 + 2; // + is de operator, 1 en 2 noemen we operands
        shifting();

        instanceOf("Tekst");
        instanceOf(42);
        instanceOf(new Author());

        bitwise();
    }

    private static void bitwise() {
        // als je high performance berekeningen maakt.
        // als je hardware programmeert

        // ~                = bitwise invert : 10001111 -> 01110000
        // >> en varianten  = bitwise shift
        // & en |           = bitwise and/or
        int result = 0b00101011 &
                     0b01001101; // filter, mask
        //             00001001
    }

    private static void shifting() {
        int shift = 32 >> 3; // = 4
        // 00000000_00000000_00000000_00100000 >> 3 =
        // 00000000_00000000_00000000_00000100      = 4

        int shift2 = 33 >> 3; // = 4
        // 00000000_00000000_00000000_00100001 >> 3 =
        // 00000000_00000000_00000000_00000100      = 4

        int shift3 = -32 >> 1; // bit wise shift met behoud van teken
        // v = sign bit: 0 = +, 1 = -
        // 11111111_11111111_11111111_11100000 >> 1 =
        // 11111111_11111111_11111111_11110000      = -16

        int shift4 = -32 >>> 1; // bit wise shift aangevuld met 0
        // v = sign bit: 0 = +, 1 = -
        // 11111111_11111111_11111111_11100000 >> 1 =
        // 01111111_11111111_11111111_11110000      = 2147483632

        System.out.println(shift3);
        System.out.println(shift4);
    }

    private static void instanceOf(Object o) {
        if (o instanceof Integer) {
            System.out.println("Het is een Integer!");
        } else {
            System.out.println("Geen idee wat het type is...");
        }
    }

}
