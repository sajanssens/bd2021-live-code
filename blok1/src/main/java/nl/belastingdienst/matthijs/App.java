package nl.belastingdienst.matthijs;

import java.util.List;

public class App {

    public static void main(String[] args) {
        GoedCategorie ib = new GoedCategorie();
        ib.setNaam("Inboedel");

        GoedCategorie c = new GoedCategorie();
        c.setNaam("Computer");

        DienstCategorie s = new DienstCategorie();
        s.setNaam("Schoonmaken");

        List<Categorie> allCategories = List.of(ib, c, s);

        for (Categorie cat : allCategories) {
            // foutgevoelig:
            // if(cat.getType().equalsIgnoreCase("G")) {
            //     System.out.println(cat);
            // }

            // compileerbaar:
            if(cat instanceof GoedCategorie) {
                System.out.println(cat);
            }

        }
    }

}
