package java8.lambda;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdaExpressionDemo {
    public static void main(String... args) {
        //lambda expression to compare two strings by length
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        List<String> list = Arrays.asList("****", "*", "***", "**");
        list.sort(comparator);
        list.forEach(System.out::println);
    }
}
