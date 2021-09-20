package nl.belastingdienst.h4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gemiddelde {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cijfer = 0;

        List<Integer> cijfers = new ArrayList<>();

        System.out.println("Geef wat cijfers (-1 is stoppen)");

        while ((cijfer = s.nextInt()) != -1) {
            cijfers.add(cijfer);
        }

        double v = cijfers.stream().mapToInt(i -> i).average().orElse(-1);
        System.out.println(v);
    }

}
