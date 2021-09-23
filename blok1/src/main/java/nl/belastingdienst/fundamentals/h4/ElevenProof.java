package nl.belastingdienst.fundamentals.h4;

public class ElevenProof {

    private ScannerTussenpersoon scannerTussenpersoon = new ScannerTussenpersoon();

    public static void main(String[] args) {
        new ElevenProof().start();
    }

    private void start() {
        String rekeningnummer = getRekeningnummer();

        int som = bepaalSom(rekeningnummer);
        System.out.println(som);

        boolean isOk = isElevenProof(som);
        System.out.println(isOk);
    }

    String getRekeningnummer() {
        System.out.println("Geef rekeningnummer: ");
        return scannerTussenpersoon.nextLine();
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
        return som % 11 == 0;
    }

    public void setScannerTussenpersoon(ScannerTussenpersoon s) {
        this.scannerTussenpersoon = s;
    }
}
