package nl.belastingdienst.fundamentals.h4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gemiddelde {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> cijfers = new ArrayList<>();

        System.out.println("Geef wat cijfers (-1 is stoppen): ");

        int cijfer;
        while ((cijfer = s.nextInt()) != -1) {
            cijfers.add(cijfer);
        }

        double avg = cijfers.stream().mapToInt(i -> i).average().orElse(-1);
        System.out.println(avg);
    }

}
