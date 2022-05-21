package java8.stream;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamFilteringWithPredicatesDemo {
    public static void main(String... args){
        Supplier<Stream<String>> inputSupplier = () -> Stream.of("one", "two", "three", "four", "five");

        Predicate<String> greaterThanThreePredicate = s -> s.length() > 3;
        Consumer<String> printStream = System.out::println;

        System.out.println("**** filtering the strings with at least length 4 and print out ****");
        inputSupplier.get().filter(greaterThanThreePredicate).forEach(printStream);


        Predicate<String> equalToTwo = Predicate.isEqual("two");
        Predicate<String> equaltToThree = Predicate.isEqual("three");

        System.out.println("**** filtering the strings that are either equal to two or three and print out ****");
        inputSupplier.get().filter(equalToTwo.or(equaltToThree)).forEach(printStream);
    }
}
