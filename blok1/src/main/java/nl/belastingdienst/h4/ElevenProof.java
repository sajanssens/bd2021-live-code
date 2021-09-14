package nl.belastingdienst.h4;

public class ElevenProof {

    public static void main(String[] args) {
        var rekeningnummer = "736160221";

        var i = 9;       // A = startwaarde, gaat van 9 t/m 1
        var j = 0;       //                  gaat van 0 t/m 8
        int som = 0;
        while (i >= 1) { // B = eindconditie
            // System.out.println(i); // BODY

            char nummer = rekeningnummer.charAt(j); // karakter uit rekeningnummer op plek j
            // System.out.println(nummer);

            // char een = '1'; // = nummer 60 ofzo.
            // String eenS = "1";

            // String nummerAlsString = nummer + "";
            // int nummerAlsInt = Integer.parseInt(nummerAlsString);

            int nummerAlsInt = Character.getNumericValue(nummer);

            int product = nummerAlsInt * i;
            som = som + product;

            // System.out.println(product);
            i--;         // C = stapgrootte
            j++;
        }
        System.out.println(som);

        int restNaDelingDoorElf = som % 11;
        boolean isOk = restNaDelingDoorElf == 0;
        System.out.println(isOk);

        // ...

        // for(startwaarde ; eindconditie ; stapgrootte ){
        //      doe iets zolang eindconditie niet bereikt is.
        // }
    }

}
