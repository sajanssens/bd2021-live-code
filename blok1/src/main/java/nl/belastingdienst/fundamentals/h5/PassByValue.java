package nl.belastingdienst.fundamentals.h5;

import nl.belastingdienst.fundamentals.h7.Author;

public class PassByValue {

    public void verhoogLeeftijd(Author a) {
        int age = a.getAge();
        a.setAge(age + 10);
    }

    public static void main(String[] args) {
        PassByValue passByValue = new PassByValue();

        Author bram = new Author("Bram", 42, true); // @123
        passByValue.verhoogLeeftijd(bram);
        System.out.println(bram.getAge());
    }

}
