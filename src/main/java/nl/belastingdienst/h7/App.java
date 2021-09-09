package nl.belastingdienst.h7;

public class App {

    public static void main(String[] args) {
        Author a = new Author(); // instantieren, dmv aanroepen van de constructor

        System.out.println(a.getName());
        System.out.println(a.genre);
        System.out.println(a.getAge());
        System.out.println(a.rating);
        System.out.println(a.isLief);

        Author b = new Author(null, 0, true);
        System.out.println(b.getName());
        System.out.println(b.getAge());
        System.out.println(b.isLief);

        b.setName("123");
        System.out.println(b.getName());

        System.out.println(Author.max);
        System.out.println(Author.geefDeMaxLeeftijd());
    }

}
