package nl.belastingdienst.h4;

import java.util.Scanner;

public class ElevenProof {

    public static void main(String[] args) {
        new ElevenProof().start();
    }

    private void start() {
        System.out.println("Geef rekeningnummer: ");
        var rekeningnummer = new Scanner(System.in).nextLine();

        int som = bepaalSom(rekeningnummer);
        System.out.println(som);

        boolean isOk = isElevenProof(som);
        System.out.println(isOk);
    }

    int bepaalSom(String rekeningnummer) {
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
        return som;
    }

    boolean isElevenProof(int som) {
        int restNaDelingDoorElf = som % 11;
        boolean isOk = restNaDelingDoorElf == 0;
        return isOk;
    }

}
