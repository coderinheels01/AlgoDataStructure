package algorithm.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintUtil {

    public static void printIntArray(int[] numbers, String method){
        System.out.printf("Printing for method %s: %s \n", method,  Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println();
    }

    public static void printTwoDIntArray(int[][] numbers){
        for(int i =0; i< numbers.length; i++){
            for(int j=0; j< numbers[0].length; j++){
                System.out.print(numbers[i][j] + ", ");
            }
            System.out.println();
        }
    }
    public static void printIntArrayWithoutName(int[] numbers){
        System.out.printf("Printing for method %s \n",  Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println();
    }

    public static void printLinkedList(Node node){
        while(node != null){
            System.out.printf("%s," , node.getValue());
            node = node.getNext();
        }
        System.out.println();
    }

    public static void printIntArrayList(List<Integer> numbers){
        numbers.forEach(x -> System.out.print(x + ","));
        System.out.println();
    }
    public static void printNestedArrayList(List<List<Integer>> numbers){
        numbers.forEach(x -> System.out.println(x));
    }

}
