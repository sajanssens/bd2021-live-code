package nl.belastingdienst.marktplaats;

import nl.belastingdienst.marktplaats.boundary.Hoofdscherm;
import nl.belastingdienst.marktplaats.dao.BezorgwijzeDao;

import java.util.Scanner;

public class App {

    public static final BezorgwijzeDao bwDao = new BezorgwijzeDao();
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() { return scanner.nextLine(); }

    public static String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static void main(String[] args) { new Hoofdscherm().start(); }

}
