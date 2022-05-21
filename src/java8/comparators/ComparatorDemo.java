package java8.comparators;

import java8.stream.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComparatorDemo {
    public static void main(String... args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Emily", "Aung"));
        personList.add(new Person("Larry", "Scott"));
        personList.add(new Person("John", "Smith"));
        personList.add(new Person("Hein", "Htet"));

        personList.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));

        System.out.println(personList.stream().map(p -> p.getFirstName() + " " + p.getLastName()).collect(Collectors.joining(",")));

        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add(null);
        stringList.add(null);
        stringList.add("five");
        stringList.add(null);

        System.out.println("before sorting = " + String.join(",", stringList));
        stringList.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("after sorting with nulls a the beginning = " + String.join(",", stringList));
        stringList.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("after sorting with nulls a the end = " + String.join(",", stringList));

        System.out.println("before removing nulls = " + String.join(",", stringList));
        stringList.removeIf(Objects::isNull);
        System.out.println("after removing nulls = " + String.join(",", stringList));

    }
}
