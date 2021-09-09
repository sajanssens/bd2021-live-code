package nl.belastingdienst.ietsanders;

public class Book { // Altijd met één hoofdletter

    // STATE
    // DATA: wat is een boek? C.q. welke eigenschappen, velden heeft ie?
    private String title;
    private String isbn;
    // ...
    // ...

    // BEHAVIOUR
    // FUNCTIONS = methods
    public void lees() {
        int i = 0;
        System.out.println("Lees " + title); // concatenatie van strings (tekst)
        System.out.printf("Lees titel %s met isbn %s", title, isbn); // concatenatie van strings (tekst)
    }

    /**
     * Met deze methode klap je het boek dicht.
     */
    public void klapDicht() { // Camel Casing
        System.out.println(title + " is dichtgeklapt.");
    }

    // ...

}

