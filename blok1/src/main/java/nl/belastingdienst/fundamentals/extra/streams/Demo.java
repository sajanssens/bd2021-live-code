package nl.belastingdienst.fundamentals.extra.streams;

import nl.belastingdienst.fundamentals.h7.Author;
import nl.belastingdienst.fundamentals.h8.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Demo {

    List<Person> people = Arrays.asList(
            new Person("Bram", 42),
            new Person("Jimmy3", 29),
            new Person("Amber", 23),
            new Person("Jimmy2", 29),
            new Person("Jimmy", 29),
            new Person("Anton", 42));

    public static void main(String[] args) {
        Demo demo = new Demo();
        // demo.basics();
        demo.sorting();
    }

    private void sorting() {
        List<Person> collect = people.stream()      // 1
                .sorted()                           // 2 arbeider die kan sorteren
                .collect(toList());

        // or
        // Collections.sort(people);

        System.out.println(people);
    }

    private void basics() {
        List<Integer> authorAges =
                people.stream()
                        .filter(p -> p.getAge() <= 40)
                        .map(p -> new Author(p.getName(), p.getAge() + 2, true))
                        .map(a -> a.getAge())
                        .collect(Collectors.toList());// 3) één terminal operation
        System.out.println(authorAges);

        int sum = authorAges.stream() // objectstream
                .mapToInt(i -> i.intValue())
                .sum();
        System.out.println(sum);

        Integer reduce = authorAges.stream()
                .reduce(0, (subtotaal, i) -> subtotaal + i);
        System.out.println(reduce);

        Person reduce1 = people.stream()
                .reduce(new Person(),
                        (sub, p) -> new Person(sub.getName() + p.getName(), sub.getAge() + p.getAge()));

        System.out.println(reduce1);

        Map<Integer, List<String>> collect =
                people.stream()
                        .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));

        System.out.println(collect);
        // SELECT p.age, count(*)
        // FROM Person p
        // GROUP BY p.age
    }

}
