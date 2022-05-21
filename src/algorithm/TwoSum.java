package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String... args){
        int[] input = {2,7,11,15};
        int target = 22;
        print(twoSumMethod1(input, target), "Method 1");
        print(twoSumMethod2(input, target), "Method 2");
    }

    public static void print(int[] result, String method){
        System.out.println("\nprinting result for " + method);
        Arrays.stream(result).forEach(index -> System.out.printf("%s,", index));
    }
    public static int[] twoSumMethod1(int[] input, int target){
        for(int i=0; i< input.length; i++){
            for(int j=i+1; j< input.length; j++){
                if(input[i] + input[j] == target)
                    return new int[] {i , j};
            }
        }
        return new int[]{};
    }

    public static int[] twoSumMethod2(int[] input, int target){
        Map<Integer, Integer> lookup = new HashMap<>();

        for(int i=0; i< input.length; i++){
            int complement = target -  input[i];
            if(lookup.containsKey(complement))
                return new int[]{lookup.get(complement), i};
            else
                lookup.put(input[i], i);
        }
        return new int[]{};
    };
}
