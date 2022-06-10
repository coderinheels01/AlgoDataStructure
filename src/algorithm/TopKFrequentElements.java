package algorithm;
import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {


    /*
     * 1. loop the numbers, count and put them into HashMap.
     * 2. loop the entry set of the map, sort them by value put them into LinkedHashMap to preserve insertion order.
     * 3. loop through the sorted HashMap until the count reaches k number then put into array.
     * 4. return the result array.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/top-k-frequent-elements/
     *
     */
    public static int[] topKFrequentLinkedHashMap(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) +1);
        }

        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, v1) -> k1,  LinkedHashMap::new));

        int count = 0;
        for(Integer n : sortedMap.keySet()){
            if(k == count)
                break;
            result[count] = n;
            count++;
        }

        return result;
    };
    /*
     * 1. loop the numbers, count and put them into HashMap.
     * 2. loop the entry set of the map, add them to PriorityQueue.
     * 3. loop through the PriorityQueue until the count reaches k number then put into array.
     * 4. return the result array.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/top-k-frequent-elements/
     *
     */
    public static int[] topKFrequentPriorityQueue(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for(int n : nums){
            count.put(n , count.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue() );

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            pq.add(entry);
        }

        int[] topNumbers = new int[k];
        int idx = 0;
        while (!pq.isEmpty() && idx < k) {
            topNumbers[idx] = pq.poll().getKey();
            idx++;
        }
        return topNumbers;
    };
    public static void main(String ...args){
        int[] nums = {1,1,1,2,2,3};
        int k = 1;
        System.out.println("\n-----ORIGINAL ARRAY-----");
        Arrays.stream(nums).forEach(n -> System.out.print(n + " , "));
        System.out.println("\n----- USING SORTED MAP-----");
        Arrays.stream(topKFrequentLinkedHashMap(nums, k)).forEach(n -> System.out.print(n + " , "));
        System.out.println("\n----- USING PRORITY QUEUE -----");
        Arrays.stream(topKFrequentPriorityQueue(nums, k)).forEach(n -> System.out.print(n + " , "));

        int[] nums2 = { -1,-1};
        k = 1;

        System.out.println("\n-----ORIGINAL ARRAY-----");
        Arrays.stream(nums2).forEach(n -> System.out.print(n + " , "));
        System.out.println("\n----- USING SORTED MAP-----");
        Arrays.stream(topKFrequentLinkedHashMap(nums2, k)).forEach(n -> System.out.print(n + " , "));
        System.out.println("\n----- USING PRORITY QUEUE -----");
        Arrays.stream(topKFrequentPriorityQueue(nums2, k)).forEach(n -> System.out.print(n + " , "));

        int[] nums3 = { 1,2};
        k = 2;

        System.out.println("\n-----ORIGINAL ARRAY-----");
        Arrays.stream(nums3).forEach(n -> System.out.print(n + " , "));
        System.out.println("\n----- USING SORTED MAP-----");
        Arrays.stream(topKFrequentLinkedHashMap(nums3, k)).forEach(n -> System.out.print(n + " , "));
        System.out.println("\n----- USING PRORITY QUEUE -----");
        Arrays.stream(topKFrequentPriorityQueue(nums3, k)).forEach(n -> System.out.print(n + " , "));


    }
}
