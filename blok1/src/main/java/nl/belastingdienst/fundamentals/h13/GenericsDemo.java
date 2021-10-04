package nl.belastingdienst.fundamentals.h13;

import nl.belastingdienst.fundamentals.h8.Person;

import java.util.List;

public class GenericsDemo {

    private final static PersonProcessor personProcessor = new PersonProcessor();

    public static final Person AMBER = new Person("Amber", 23);
    public static final Person MATTHIJS = new Person("Matthijs", 43);
    public static final Person MARCO = new Person("Marco", 32);

    private final static List listOfAnything = List.of(
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
        withoutGenerics();
        withGenerics();
    }

    private static void withoutGenerics() {
        // personProcessor.processPersonsNotTypeSafe(listOfAnything); // allowed but throws a RuntimeException!
        personProcessor.processPersonsTypeSafe(listOfAnything);
    }

    private static void withGenerics() {
        personProcessor.processPersonsGeneric(personList);

        Processor<Double> doubleProcessor = new Processor<>();
        // doubleProcessor.process(personList); // not allowed
        // doubleProcessor.process(listOfAnything); // allowed with warning: still a RuntimeException!
        doubleProcessor.process(List.of(1.0, 2.0, 3.0)); // allowed and type safe
    }

}
