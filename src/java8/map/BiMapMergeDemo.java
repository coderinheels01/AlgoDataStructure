package java8.map;

import java8.stream.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiMapMergeDemo {
    public static void main(String... args) {
        List<Person> peopleList = loadPersonsList();
        Map<Integer, List<Person>> mappedByAge = mapByAge(peopleList);
        System.out.println("original map by group by age");
        printMap(mappedByAge);

        Map<Integer, Map<String, List<Person>>> mappedByAgeAndGender = new HashMap<>();

        peopleList.forEach(person ->
                mappedByAgeAndGender.computeIfAbsent(person.getAge(), age -> new HashMap<>())
                        .merge(person.getGender(), new ArrayList<Person>() {{
                            add(person);
                        }}, (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        })
        );
        System.out.println("Printing bimap");
        printBiMap(mappedByAgeAndGender);
    }

    public static void printBiMap(Map<Integer, Map<String, List<Person>>> biMap){
        biMap.forEach((age, map) -> System.out.println(age + " -> " + map));
    }

    public static void printMap(Map<Integer, List<Person>> map) {
        map.forEach((age, list) -> System.out.println(age + " -> " + list));
    }

    public static List<Person> loadPersonsList() {
        List<Person> people = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("/Users/emiaun/Desktop/Projects/jdk14/src/java8/stream/file/person.txt"))) {
            people.addAll(stream.map(line -> {
                String[] inputs = line.split(" ");
                return new Person(inputs[0], Integer.parseInt(inputs[1]), inputs[2]);
            }).collect(Collectors.toList()));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return people;
    }

    ;

    public static Map<Integer, List<Person>> mapByAge(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    ;

}
