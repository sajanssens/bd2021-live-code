package nl.belastingdienst.fundamentals.h13;

import nl.belastingdienst.fundamentals.h8.Person;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    // Generics = Generic Types
    public static void main(String[] args) {
        PersonProcessor processor = new PersonProcessor();

        List personList = new ArrayList();

        personList.add(new Person("Amber", 23));
        personList.add(new Person("Matthijs", 43));
        personList.add(new Person("Marco", 32));
        personList.add("Linh");
        personList.add("Pepijn");
        personList.add(1);
        personList.add(new IllegalAccessError());

        processor.processPersons(personList);

        List<Person> personList2 = new ArrayList<>(); // diamond syntax

        personList2.add(new Person("Amber", 23));
        personList2.add(new Person("Matthijs", 43));
        personList2.add(new Person("Marco", 32));

        processor.processPersons2(personList2);

        Processor<Double> doubleProcessor = new Processor<>();
        // doubleProcessor.process(personList2);
        doubleProcessor.process(List.of(1.0, 2.0, 3.0));
        // doubleProcessor.process(personList);
    }

}
