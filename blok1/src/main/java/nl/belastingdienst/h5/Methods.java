package nl.belastingdienst.h5;

public class Methods {

    // scope van een variabele is tussen de {}'s waar hij *gedeclareerd* is
    private int getal = 10; // scope is: tussen de {}'s van de class

    public int twoPlusTwo() {
        int a = 2; // scope is: tussen de {}'s van deze methode
        int b = 2;
        return a + b;
    } // = return ...?

    public void doeWat(int i) {
        int getal = 0;
        int result = i + 2;

        if (result > 10) {
            return;
        }

        System.out.println(result);
        System.out.println(getal);
        System.out.println(this.getal);

    } // = return;

}
