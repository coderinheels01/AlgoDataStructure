package java8.map;

import java8.stream.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMergeDemo {

    public static void main(String... args) {
        List<Person> people = loadList();
        List<Person> subList = people.subList(0, 5);
        List<Person> subList2 = people.subList(5, people.size());

        Map<Integer, List<Person>> map1 = mapByAge(subList);
        Map<Integer, List<Person>> map2 = mapByAge(subList2);

        System.out.println("original map 1 ");
        printMap(map1);
        System.out.println("original map 2");
        printMap(map2);

        map1 = mergeTwoMaps(map1, map2);
        System.out.println("Map1 after merge ");
        printMap(map1);

    }

    public static Map<Integer, List<Person>> mergeTwoMaps(Map<Integer, List<Person>> map1, Map<Integer, List<Person>> map2) {
        map2.entrySet().stream().forEach(entry ->
                map1.merge(entry.getKey(), entry.getValue(), (map1List, map2List) -> {
                    map1List.addAll(map1List);
                    return map1List;
                })
        );

        return map1;
    }

    ;

    public static void printMap(Map<Integer, List<Person>> map) {
        map.forEach((age, people) -> System.out.println(age + " -> " + people));
    }

    public static Map<Integer, List<Person>> mapByAge(List<Person> list) {
        return list.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    ;

    public static List<Person> loadList() {
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
}
