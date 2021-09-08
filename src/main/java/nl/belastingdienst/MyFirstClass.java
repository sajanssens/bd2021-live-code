package nl.belastingdienst; // package name

// import java.lang.*; // impliciet aanwezig.

public class MyFirstClass { // class name

    // Fully qualified class name:
    // nl.belastingdienst.MyFirstClass

    // commentaar  = single line comment

    public static void main(String[] args) { // de main methode
        String message = "String hello world!";
        System.out.println(message);
        System.out.println("Nog iets...");

        int i = message.length();
        String message5 = message.repeat(5);  // API feature

        // Java release
        // - language features
        // - API features (add/remove/update)
    }

}
