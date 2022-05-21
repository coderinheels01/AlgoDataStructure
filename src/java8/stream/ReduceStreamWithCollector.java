package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReduceStreamWithCollector {
     class Person{
        String name;
        int age;
        Person(){};
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String... args){
        List<String> list = Arrays.asList("Emily", "Aung", "Simon", "John");

        System.out.println("*** joining a java8.list of string with comma using reducer method called collect and Collectors.joining to a String ***");
        String result = list.stream().filter(name -> name.length()> 2).collect(Collectors.joining(","));
        System.out.println("result = " + result);

        System.out.println("\n\n*** joining a list of string with comma using reducer method  Collectors.toList ***");
        List<String> resultList = list.stream().filter(name -> name.length()> 2).collect(Collectors.toList());
        System.out.println("result as a list = " + resultList);


        System.out.println("\n\n*** converting a java8.list into a map and grouping them by age ***");
        ReduceStreamWithCollector.Person p1 = new ReduceStreamWithCollector(). new Person("Emily", 12);
        ReduceStreamWithCollector.Person p2 = new ReduceStreamWithCollector(). new Person("John", 21);
        ReduceStreamWithCollector.Person p3 = new ReduceStreamWithCollector(). new Person("Smith", 21);

        List<Person> personList = Arrays.asList(p1, p2, p3);

        Map<Integer,List<Person>> personMap = personList.stream()
                                              .collect(Collectors.groupingBy(person -> person.age));
        System.out.println("person map grouped by age = "+ personMap);

        System.out.println("\n\n*** grouping person by age then counting the number and " +
                "put it in a map using downstream collector(Collectors.counting)***");
        Map<Integer, Long> personCountMap = personList.stream()
                .collect(Collectors.groupingBy(person -> person.age, Collectors.counting()));

        System.out.println("person count map grouped by age = "+ personCountMap);

    }
}
