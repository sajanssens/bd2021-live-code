package nl.belastingdienst.h4;

import nl.belastingdienst.h2.ietsanders.Author;

import java.util.ArrayList;
import java.util.List;

public class StatementOrExpression {

    public static void main(String[] args) {
        // statement: stukje code, eindigend op ; of }, dat iets uitvoert
        // expression een stukje code dat tot één waarde leidt.

        int i = 1 + 2;
        // "..left side.. = ..right side..;" assignment statement.
        // 1+2 is een expression: leidt tot één waarde, nl. 3.

        // expression statements:
        ++i;
        // statement, want i wordt opgehoogd
        // expression, want ++i heeft één waarde en die kun je toekennen aan iets anders, bijv. int j

        int k;

        while ((k = i + 4) > 10) { // assignment statement is hier ook een expression
            i++;
            // iets anders
        }

        List<String> woorden = new ArrayList<>();
        woorden.add("Hello");
        woorden.add("world");

        // if statement
        if (i < 9) {
            int z = 0;
        }

        boolean j;
        // als statement
        switch (i) {
            case 1:
            case 2:
            case 5:
                j = true; break;
            default:
                j = false;
        }

        // als expression (java >= 14)
        j = switch (i) {
            case 1, 2, 3 -> true;
            default -> false;
        };

        // for statement (als aantal slagen bekend is)
        for (int a = 0; a < 10; a++) { // spreek uit: "voor a van 0 tot 10 met stap 1, doe":
            System.out.printf("%d ", a);
        }

        // equivalent in while (als je vantevoren niet weet hoe lang je moet doorgaan)
        int a = 0;
        while (a < 10) { // spreek uit: "voor a van 0 tot 10 met stap 1, doe":
            System.out.printf("%d ", a);
            a++; // niet vergeten!
        }

        /*
        for(.a. : .b.) { // b: de collectie
            // a: het element uit de collectie

        }
        */

        for (String woord : woorden) { // voor ieder woord in woorden, doe:

        }

        for (int e = 0; e < woorden.size(); e++) {
            String woord = woorden.get(e);
        }

        try (Author auth = new Author()) {
            System.out.println(auth.name);
        } // auth.close() automatisch aanroepen

    }

}
