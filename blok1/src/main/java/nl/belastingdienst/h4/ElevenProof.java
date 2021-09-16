package nl.belastingdienst.h4;

import java.util.Scanner;

public class ElevenProof {

    public static void main(String[] args) {
        System.out.println("Geef rekeningnummer: ");
        // var rekeningnummer = "736160221";
        var rekeningnummer = new Scanner(System.in).nextLine();

        var i = 0;
        var factor = 9;
        int som = 0;
        while (factor >= 1) {
            char karakterUitRekeningnummer = rekeningnummer.charAt(i);
            int nummerAlsInt = Character.getNumericValue(karakterUitRekeningnummer);

            int product = nummerAlsInt * factor;
            som = som + product;

            factor--;
            i++;
        }
        System.out.println(som);

        int restNaDelingDoorElf = som % 11;
        boolean isOk = restNaDelingDoorElf == 0;
        System.out.println(isOk);
    }

}
