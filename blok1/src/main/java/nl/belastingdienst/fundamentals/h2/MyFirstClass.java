package nl.belastingdienst.fundamentals.h2; // package name

// import java.lang.*; // impliciet aanwezig.

import nl.belastingdienst.fundamentals.h2.ietsanders.Author;
import nl.belastingdienst.fundamentals.h2.ietsanders.Book;

public class MyFirstClass { // class name

    // Fully qualified class name:
    // nl.belastingdienst.fundamentals.h2.MyFirstClass

    // commentaar  = single line comment

    public static void main(String[] args) { // de main methode
        String message = "String hello world!";
        System.out.println(message);

        Book b = new Book();
        b.klapDicht();

        Author a;

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
