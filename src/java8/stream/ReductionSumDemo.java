package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReductionSumDemo {
    public static void main(String... args){
        List<Integer> ages = Arrays.asList(1, 1, 1, 1);
        Integer sumOfAge = ages.stream().reduce(0, Integer::sum);

        System.out.println("sum of age = " + sumOfAge);

        int id =1;
        Stream<Integer> emptyStream = Stream.empty();
        int emptyStreamReduce = emptyStream.reduce(id, Integer::sum);
        System.out.println("empty stream sum of age = " + emptyStreamReduce);

        Stream<Integer> oneElementStream = Stream.of(4);
        int oneElementReduce = oneElementStream.reduce(id, Integer::sum);
        System.out.println("one element stream sum of age = " + oneElementReduce);
    }
}
