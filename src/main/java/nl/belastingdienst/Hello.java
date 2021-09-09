package nl.belastingdienst;

import static java.lang.Math.cos;

public class Hello {

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]); // CTRL D = duplicate line
        System.out.println(args[2]);

        double result = cos(Math.PI * 1.23);
        double result2 = cos(Math.PI * 1.3);
        double result3 = cos(Math.PI * 3);
    }

}
