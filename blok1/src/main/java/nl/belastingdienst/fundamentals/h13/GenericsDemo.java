package nl.belastingdienst.fundamentals.h13;

import nl.belastingdienst.fundamentals.h8.Person;

import java.util.List;

public class GenericsDemo {

    private final static PersonProcessor personProcessor = new PersonProcessor();

    private static final Person AMBER = new Person("Amber", 23);
    private static final Person MATTHIJS = new Person("Matthijs", 43);
    private static final Person MARCO = new Person("Marco", 32);

    private final static List listOfAnything = List.of( // raw type (== geen type argument ingevuld)
            AMBER, MATTHIJS, MARCO,
            "Linh", "Pepijn",
            1,
            new IllegalAccessError()
    );

    private final static List<Person> personList = List.of(
            AMBER, MATTHIJS, MARCO
    );

    // Generics = Generic Types
    public static void main(String[] args) {
        // Person processor:
        personProcessor.processPersonsNotTypeSafe(personList);
        personProcessor.processPersonsNotTypeSafe(listOfAnything); // allowed but throws a ClassCastException!
        personProcessor.processPersonsTypeSafe(personList);
        personProcessor.processPersonsTypeSafe(listOfAnything);
        personProcessor.processPersonsGeneric(personList);
        personProcessor.processPersonsGeneric(listOfAnything); // allowed with warning but throws a RuntimeException!

        // generic number processor:
        Processor<Double> doubleProcessor = new Processor<>();
        doubleProcessor.process(List.of(1.0, 2.0, 3.0)); // allowed and type safe
        doubleProcessor.process(listOfAnything); // allowed with warning: still a RuntimeException!
        // doubleProcessor.process(personList); // not allowed

        //     <type argument>
        Processor<Integer> intProcessor = new Processor<>();
        intProcessor.process(List.of(1, 2, 3)); // allowed and type safe

        // Processor<Person> pProcessor = new Processor<>(); // not allowed, Person is not a Number
    }

}
