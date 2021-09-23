package nl.belastingdienst.fundamentals.h8;

public class Lombok {

    public static void main(String[] args) {
        Person p = new Person("Bram", 42);
        int age = p.getAge();
        System.out.println(p);

        PersonLomboked p2 = new PersonLomboked("Bram", 42);
        int age1 = p2.getAge();
    }

}
