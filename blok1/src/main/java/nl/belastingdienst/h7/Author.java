package nl.belastingdienst.h7;

import nl.belastingdienst.h2.ietsanders.Book;

import java.util.List;

public class Author { // immutable class/objects als alle fields final zijn

    // fields: data STATE, behoren bij objecten (instanties van deze class)
    // aka: instance variables
    private final String name /*= null*/; // immutable field
    private int age /*= 0*/;
    public String genre /*= null*/;

    public Book debut /*= null*/;
    public boolean isLief /*= false*/;
    public char rating;

    // static fields, behoren bij class:
    private static final int defaultAge = -1; // final is read only
    public static final int max = 100;

    public Author() {
        this(true); // MOET op eerste regel van deze constructor staan!
        // = constructor chaining

        // name = "UNKNOWN";
        // age = -1;
        // isLief = true;

        // Author init = new Author("UNKNOWN", -1, true); // FOUT!
    }

    public Author(boolean isLief) {
        this("UNKNOWN", defaultAge, isLief);
    }

    public Author(String eenName) {
        this(eenName, defaultAge, true);
    }

    // DRY = Dont Repeat Yourself

    public Author(String eenNaam, int eenAge, boolean eenIsLief) {
        name = eenNaam;
        age = eenAge;
        isLief = eenIsLief;
    }

    // Methods: functies, BEHAVIOUR
    // aka instance methods

    /**
     * @param name
     * @return
     */
    public int doeIets(String name) {
        int i = this.age * 2;
        System.out.println(i);

        System.out.println(defaultAge);

        String verbodennaam; // lokale geen default waarde
        if (name.equals("tolkien")) {
            return 42;
        } else {
            return 42;
        }
    }

    public void doeIetsAnders() {
        System.out.println("doeIetsAnders");
        System.out.println(this);
        //...
        //...
        //...
    }

    // getters: waarde ophalen van een field
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setters: waarde veranderen van een field
    public void setName(String eenNieuweNaam) {
        if (eenNieuweNaam.startsWith("1")) {
            System.err.println("Naam mag niet met 1 beginnen...");
        } else {
            // name = eenNieuweNaam;
        }
    }

    public void setAge(int age) {

        if (age < max) {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }

    // static methods, a.k.a. class methods:
    // je kunt niet bij instance variables!

    public static int geefDeMaxLeeftijd() {
        return max;
    }

    public static List<Genre> getAllGenres() {
        // System.out.println(name);
        return List.of(Genre.HORROR, Genre.THRILLER, Genre.FANTASY);
    }

    public int geefDubbeleVanLeeftijd() {
        return this.age * 2;
    }

    public static int geefDubbeleVanLeeftijd(Author eenAuthor) {
        return eenAuthor.age * 2;
    }

    public static int geefDubbeleVanLeeftijd(int leeftijd) {
        return leeftijd * 2;
    }
}
