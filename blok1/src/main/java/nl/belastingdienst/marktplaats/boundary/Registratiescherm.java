package nl.belastingdienst.marktplaats.boundary;

import nl.belastingdienst.marktplaats.domain.Bezorgwijze;

import java.util.List;

import static nl.belastingdienst.marktplaats.App.*;

public class Registratiescherm implements Boundary {

    // singleton design pattern begin -----------
    private static Registratiescherm self;

    private Registratiescherm() {}

    public static synchronized Registratiescherm registratiescherm() {
        if (self == null) self = new Registratiescherm();
        return self;
    }
    // singleton design pattern end -------------

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Registratie toevoegen]");
            System.out.println("(x) [Terug]");

            switch (readLine()) {
                case "1":
                    add(); break;
                case "x":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    private void add() {
        String email = prompt("Geef uw e-mailadres.");
        List<Bezorgwijze> all = bwDao.getAll();

        System.out.println("Bezorgwijzen:");
        for (Bezorgwijze bezorgwijze : all) {
            System.out.println("(" + bezorgwijze.ordinal() + ") " + bezorgwijze);
        }

        String bw = prompt("Kies een bezorgwijze (1, 2, 3...)");

        System.out.println("Registratie toegevoegd!");
    }

}
