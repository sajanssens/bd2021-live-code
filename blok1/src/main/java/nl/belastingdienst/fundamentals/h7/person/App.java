package nl.belastingdienst.fundamentals.h7.person;

public class App {

    public static void main(String[] args) {
        try {
            Person p = new Person(45);
            p.haveBirthday();
            System.out.println(p.getAge());
            System.out.println(Person.UNIVERSAL_RIGHTS);
        } catch (PersonDiedException e) {
            // ... doe iets met de opgetrede fout
            System.err.println(e.getMessage());
        }
    }
}
