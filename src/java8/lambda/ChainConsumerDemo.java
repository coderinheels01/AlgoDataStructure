package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * In this example, chaining two consumers is demonstrated.
 * The frist consumer will print out the string , second consumer will add the string values
 * to the second array java8.list
 */
public class ChainConsumerDemo {

    public static void main(String... args) {

        List<String> inputs = Arrays.asList("one", "two", "three", "four", "five");

        Consumer<String> printConsumer = System.out::println;

        List<String> results = new ArrayList<>();

        Consumer<String> addToArrayListConsumer = results::add;

        System.out.println("********* printing inputs array then adding to results array ********** ");
        inputs.forEach(printConsumer.andThen(addToArrayListConsumer));

        System.out.println("********* printing results array ********** ");
        results.forEach(printConsumer);

    }
}
