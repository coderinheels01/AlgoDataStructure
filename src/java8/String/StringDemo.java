package java8.String;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringDemo {

    public static void main(String... args){
        String helloWorld = "Hello World";
        toUpperCase(helloWorld);
        System.out.println();
        String[] inputs = {"Emily", "Emma", "John", "Hein"};
        stringJoiner(inputs);
        stringJoinerFromString(inputs);
    }

    public static void toUpperCase(String s){
        s.chars().mapToObj(letter -> (char) letter).map(Character::toUpperCase).forEach(System.out::print);
    }

    public static void stringJoiner(String[] inputs){
        StringJoiner sj = new StringJoiner(",", "(", ")");
        Arrays.stream(inputs).forEach(sj::add);
        System.out.println(sj.toString());
    }
    public static void stringJoinerFromString(String[] inputs){
        System.out.println(String.join(",", inputs));
    }
}
