package java8.IO;

import java8.stream.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderDemo {

    public static void main(String... args) {
        printIfDirectoryAndNamContainsJDK14();
        System.out.println("*****************************************");
        printIfFileAndNamContainsRecursivelyDemo();
        System.out.println("*****************************************");
        loadFile();
    }

    public static void printIfDirectoryAndNamContainsJDK14() {
        Path path = Paths.get("/Users/emiaun/Desktop/Projects");
        Predicate<Path> isDirectory = p -> p.toFile().isDirectory();
        Predicate<Path> contains = p -> p.getFileName().toString().contains("jdk14");
        try (Stream<Path> stream = Files.list(path)) {
            stream.filter(isDirectory.and(contains)).forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void printIfFileAndNamContainsRecursivelyDemo() {
        Path path = Paths.get("/Users/emiaun/Desktop/Projects");

        Predicate<Path> isFile = p -> p.toFile().isFile();
        Predicate<Path> containsDemo = p -> p.getFileName().toString().contains("Demo.java");

        try (Stream<Path> stream = Files.walk(path)) {
            stream.filter(isFile.and(containsDemo)).forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void loadFile() {
        Path path = Paths.get("/Users/emiaun/Desktop/Projects/jdk14/src/java8/stream/file/person.txt");
        List<Person> people = new ArrayList<>();

        try (Stream<String> stream = Files.lines(path)) {
            people = stream.map(line -> {
                String[] input = line.split(" ");
                return new Person(input[0], Integer.parseInt(input[1]));
            }).collect(Collectors.toList());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        people.sort(Comparator.comparing(Person::getAge).reversed());
        people.forEach(p -> System.out.println(p.getFirstName() + " " + p.getAge()));
    }
}
