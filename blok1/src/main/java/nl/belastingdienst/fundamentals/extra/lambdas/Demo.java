package nl.belastingdienst.fundamentals.extra.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class Demo {

    public static void main(String[] args) {
        List<String> woordenlijst = Arrays.asList("Zulu", "Yankee", "X-ray", "Alpha", "Papa");

        // voorheen kon je alleen waardes meegeven.
        woordenlijst.add("Whisky");
        woordenlijst.add("Tango");

        // Nu ook gedrag. Zulke functies heten higher order functions (functie die een functie meekrijgt)
        // De werking c.q. het gedrag, van een algoritme, d.w.z. HOE hij sorteert, kun je meegeven:

        // 1) gewone ouderwetse implementatie van een interface in een aparte klasse:
        AlfabetischeSorteerder alfabetischeSorteerderObject = new AlfabetischeSorteerder();
        woordenlijst.sort(alfabetischeSorteerderObject);

        // 2) anonieme ouderwetse implementatie van een interface:
        Comparator<String> alfabetischeSorteerderAnoniemObject = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // moet iets positiefs teruggeven als o1>o2
                // moet iets negatiefs teruggeven als o1<o2
                // nul als gelijk
                return o1.compareTo(o2);
            }
        };

        // 3) lambda
        woordenlijst.sort(alfabetischeSorteerderAnoniemObject);

        woordenlijst.sort(naturalOrder());

        List<String> gefilterdeLijst =
                woordenlijst.stream()
                        .filter(w -> w.length() <= 4) // w alleen doorlaten als hij aan het predicaat voldoet
                        .map(w -> w.toUpperCase())
                        .collect(toList());
        System.out.println(gefilterdeLijst);

        // .forEach(w -> System.out.println(w));

    }

}
