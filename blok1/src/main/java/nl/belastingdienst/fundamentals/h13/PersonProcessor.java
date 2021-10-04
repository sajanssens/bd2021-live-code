package nl.belastingdienst.fundamentals.h13;

import nl.belastingdienst.fundamentals.h8.Person;

import java.util.List;

public class PersonProcessor {

    public void processPersonsNotTypeSafe(List eenLijstMetDingen) {
        for (Object ding : eenLijstMetDingen) {
            Person person = (Person) ding;
            System.out.println(person.getAge());
        }
    }

    public void processPersonsTypeSafe(List eenLijstMetDingen) {
        for (Object ding : eenLijstMetDingen) {
            if (ding instanceof Person) {
                Person person = (Person) ding;
                System.out.println(person.getAge());
            }
        }
    }

    public void processPersonsGeneric(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.getAge());
        }
    }

}

