package nl.belastingdienst; // package name

// import java.lang.*; // impliciet aanwezig.

import nl.belastingdienst.ietsanders.Book;

public class MyFirstClass { // class name

    // Fully qualified class name:
    // nl.belastingdienst.MyFirstClass

    // commentaar  = single line comment

    public static void main(String[] args) { // de main methode
        String message = "String hello world!";
        System.out.println(message);
        Book b2;
        System.out.println("Nog iets...");

        // Java release
        // - language features
        // - API features (add/remove/update)

        // API features van String
        int i = message.length();
        String message5 = message.repeat(5);

        // Language features zijn

    }

}
