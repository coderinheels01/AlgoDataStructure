package java8.map;

import java8.stream.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * google guava api examples can be read here https://www.baeldung.com/java-map-duplicate-keys
 */
public class MapNewMethodsDemo {

    public static void main(String... args) {
        Map<Integer, List<Person>> personMap = loadPersonMap();
        System.out.println("********** original map **********");
        personMap.forEach((age, people) -> System.out.println(age + " -> " + people));

        System.out.println("java 7 get age 16");
        System.out.println("java 7 get function will return null value for key age 16 => " + personMap.get(16));
        System.out.println("java 8 get or return default value if there is no value present ");
        System.out.println("java 8 get function will return default value for key age 16 if no value present => "
                + personMap.getOrDefault(16, new ArrayList<>() {{
            add(new Person());
        }}));

        System.out.println("java 7 put age 16");
        personMap.put(16, new ArrayList<>() {{
            add(new Person("Test", 16, "F"));
        }});
        System.out.println("java 7 put method will replace original value" + personMap.get(16));
        System.out.println("java 8 put if absent");
        personMap.putIfAbsent(16, new ArrayList<>() {{
            new Person();
        }});
        System.out.println("java 8 put if absent will only put age 16 if only there is no existing value " + personMap.get(16));

        System.out.println("java 7 replace will replace");
        List<Person> oldPersonList = new ArrayList<>() {{
            add(new Person("Replace Test", 16, "M"));
        }};
        List<Person> newPersonList = new ArrayList<>() {{
            add(new Person("New Replace Test", 16, "F"));
        }};
        personMap.replace(16, oldPersonList);
        System.out.println("java 7 replace will replace existing value" + personMap.get(16));
        System.out.println("java 8 replace can check if both key and value are what we want to replace. It will replace only when the pair matches ");
        personMap.replace(16, oldPersonList, newPersonList);
        System.out.println("since the pair match it will replace old value with new value " + personMap.get(16));


        System.out.println("java 8 compute");
        personMap.compute(16, (age, people) -> {
            people.add(new Person("Test Compute", 16, "M"));
            return people;
        });
        System.out.println("added one more person to key 16 via compute method");
        System.out.println(personMap.get(16));

        System.out.println("java 8 compute if present");
        personMap.computeIfPresent(18, (age, people) -> {
            people.add(new Person("Compute if present test", 18, "F"));
            return people;
        });
        System.out.println("since key 18 is not there, it won't be added to the map but won't throw NullPointerException like compute");
        System.out.println("get 18 will return = " + personMap.get(18));

        System.out.println("java 8 compute if absent");
        personMap.computeIfAbsent(18, age -> new ArrayList<>()).add(new Person("Compute if absent test", 18, "F"));
        System.out.println("get 18 would now return value" + personMap.get(18));

    }


    public static Map<Integer, List<Person>> loadPersonMap() {
        Map<Integer, List<Person>> personMap = new HashMap<>();
        try (Stream<String> stream = Files.lines(Paths.get("/Users/emiaun/Desktop/Projects/jdk14/src/java8/stream/file/person.txt"))) {
            personMap = stream.map(line -> {
                String[] input = line.split(" ");
                return new Person(input[0], Integer.parseInt(input[1]), input[2]);
            }).collect(Collectors.groupingBy(Person::getAge));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return personMap;
    }

}
