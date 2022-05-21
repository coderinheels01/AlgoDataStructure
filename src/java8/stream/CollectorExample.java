package java8.stream;

import java8.stream.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorExample {
    public static void main(String... args) {
        List<Person> persons = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CollectorExample.class.getResourceAsStream("file/person.txt")));
             Stream<String> stream = reader.lines()) {
            persons = stream.map(line -> {
                String[] personInfo = line.split(" ");
                Person p = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
                return p;
            }).collect(Collectors.toList());
        } catch (IOException ioe) {
            System.out.println(ioe);
        };

        Optional<Person> personWithMinAge = persons.stream().filter(p -> p.getAge() > 20).min(Comparator.comparing(Person::getAge));
        System.out.println("Youngest Person older than 20 "+ personWithMinAge.get().getFirstName());
        Optional<Person> personWithMaxAge = persons.stream().filter(p -> p.getAge() > 20).max(Comparator.comparing(Person::getAge));
        System.out.println("Oldest Person older than 20 "+ personWithMaxAge.get().getFirstName());

    }
}
