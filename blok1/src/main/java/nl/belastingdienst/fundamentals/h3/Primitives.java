package nl.belastingdienst.fundamentals.h3;

import nl.belastingdienst.fundamentals.h2.ietsanders.Author;

public class Primitives {

    public static void main(String[] args) {
        int i = 1847634870; // value type
        double pi = 3.14;
        byte number = 127;
        number = (byte) (number + 10);

        long numberL = 2L;
        long result = 123 + number;

        int r = (int) (numberL + result);

        System.out.println(i);
        System.out.println(pi);
        System.out.println(number);

        String naam = "Bram"; // reference type
        Author bram = new Author();
        bram.name = "Bram";
        bram.age = -42;
        bram.genre = "Honkbal";

        System.out.println(bram.name);
        System.out.println(bram.age);
        System.out.println(bram.toString());
        // toString geeft een stringrepresentatie van een object
        // standaard is dat fullyqname@adres
        // als je dit overschrijft wordt het iets anders.

        Integer j = Integer.valueOf(84);
        System.out.println(j);

        Author amber = bram;
        updateName(amber, "Amber");
        System.out.println(bram);

        int modulo = 80 % 60; // == 1, rest 20, rest na deling
        System.out.println(modulo);

        int division = 80 / 60; // == 1, rest 20, rest na deling
        System.out.println(division);

        division++;

        System.out.println(division);
    }

    private static void updateName(Author author, String newName) {
        author.name = newName;
    }
}
