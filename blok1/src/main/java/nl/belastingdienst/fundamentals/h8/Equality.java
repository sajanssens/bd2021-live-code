package nl.belastingdienst.fundamentals.h8;

import nl.belastingdienst.fundamentals.h7.Author;

import java.util.HashSet;
import java.util.Set;

public class Equality {

    public static void main(String[] args) {
        int i = 9, j = 9;
        if (j == i) {
            System.out.println("1 Gelijk");
        } else {
            System.out.println("1 Ongelijk");
        }

        Author a = new Author("Bram Janssens", 42, true);
        Author b = new Author("Bram Janssens", 42, false);

        if (a == b) { // a is een ander object dan b
            System.out.println("2 Gelijk");
        } else {
            System.out.println("2 Ongelijk");
        }

        if (a.equals(b)) { // de inhoud van a en b zijn hetzelfde
            System.out.println("3 Gelijk");
        } else {
            System.out.println("3 Ongelijk");
        }

        Set<Author> uniekeAuthors = new HashSet<>();
        uniekeAuthors.add(a); // deze voegt toe als hashcode van a er nog niet inzit EN onder die hashcode de objecten NIET equal zijn
        uniekeAuthors.add(b); // deze voegt toe als hashcode van b er nog niet inzit EN onder die hashcode de objecten NIET equal zijn

        for (Author uniekeAuthor : uniekeAuthors) {
            System.out.println(uniekeAuthor);
            System.out.println(uniekeAuthor.hashCode());
        }

        System.out.println(a);

    }

}
