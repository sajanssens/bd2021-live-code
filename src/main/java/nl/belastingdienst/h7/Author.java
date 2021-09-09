package nl.belastingdienst.h7;

import nl.belastingdienst.h2.ietsanders.Book;

public class Author {

    // fields: data STATE
    private String name /*= null*/;
    private int age /*= 0*/;
    public String genre /*= null*/;
    public Book debut /*= null*/;
    public boolean isLief /*= false*/;
    public char rating;
    public static final int max = 100;

    public Author() {

    }

    public Author(boolean isLief) {
        this.isLief = isLief;
    }

    // DRY = Dont Repeat Yourself

    public Author(String eenNaam, int eenAge, boolean eenIsLief) {
        name = eenNaam;
        age = eenAge;
        isLief = eenIsLief;
    }

    public static int geefDeMaxLeeftijd(){
        return max;
    }

    // Methods: functies, BEHAVIOUR
    public int doeIets(String name) {
        String verbodennaam; // lokale geen default waarde
        if (name.equals("tolkien")) {
            return 42;
        } else {
            return 42;
        }
    }

    public void doeIetsAnders() {
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
            name = eenNieuweNaam;
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
}
