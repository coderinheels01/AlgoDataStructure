package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamMapAndFlatMapFunctionDemo {
    public static void main(String... args){
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = Arrays.asList(7, 8, 9, 10);
        List<Integer> list3 = Arrays.asList(11, 12, 13);

        List<List<Integer>> finalList = Arrays.asList(list1, list2, list3);

        Consumer<? super Object> printStream = i -> System.out.print(i + " ");

        System.out.println("**** print the size of each java8.list **** ");
        Function<List<?>, Integer> listSize = List::size;
        finalList.stream().map(listSize).forEach(printStream);

        System.out.println("\n**** flat map a java8.list of stream of lists  **** ");
        Function<List<?>, Stream<?>> listToStream = list -> list.stream();
        finalList.stream().flatMap(listToStream).forEach(printStream);
    }
}

