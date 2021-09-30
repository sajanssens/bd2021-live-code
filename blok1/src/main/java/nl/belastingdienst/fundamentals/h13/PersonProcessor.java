package nl.belastingdienst.fundamentals.h13;

import nl.belastingdienst.fundamentals.h8.Person;

import java.util.List;

public class PersonProcessor {

    public void processPersons(List eenLijstMetDingen) {
        for (Object ding : eenLijstMetDingen) {
            if (ding instanceof Person) {
                Person person = (Person) ding;
                System.out.println(person.getAge());
            }
        }
    }

    public void processPersons2(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.getAge());
        }
    }

}

