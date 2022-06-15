package algorithm;

import java.util.Comparator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class CarFleet {

    /*
     * 1. sort the cars by positions in reverse order using tree map.
     * 2. traverse the sorted tree map and calculate the time it will take to get to target.
     *    formula : ( target - current position) / current speed;
     * 3. if the stack size is greater than 2 then, peek the top 2 stack values and then compare them.
     *    if car2 is going to get to the destination before car1 that means we have a fleet and pop the stack.
     * 4. return the stack size.
     *
     * Time Complexity: O(NLogN)
     * Space Complexity: O(N)
     *
     * https://leetcode.com/problems/car-fleet/
     * https://www.youtube.com/watch?v=Pr6T-3yB9RM
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> sortedByPosition= new TreeMap<>(Comparator.reverseOrder());
        for(int i=0; i< position.length; i++){
            sortedByPosition.put(position[i], speed[i]);
        }
        Stack<Double> stack = new Stack<>();
        for(Map.Entry<Integer, Integer> entry : sortedByPosition.entrySet()){
            stack.push((double)(target - entry.getKey()) / entry.getValue());
            if(stack.size()>=2){
                Double car2 = stack.peek();
                Double car1 = stack.get(stack.size() -2);
                if(car1 <= car2)
                    stack.pop();
            }
        }
        return stack.size();
    }


    public static void main(String ...args){
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;
        System.out.println("car fleet count " + carFleet(target, position, speed));

        int[] position2 = {3};
        int[] speed2 = {3};
         target = 10;

        System.out.println("car fleet count " + carFleet(target, position2, speed2));

        target = 100; int[] position3 = {0,2,4}; int[] speed3 = {4,2,1};
        System.out.println("car fleet count " + carFleet(target, position3, speed3));

        target =10; int[] position4 = {6,8}; int[] speed4 = {3,2};
        System.out.println("car fleet count " + carFleet(target, position4, speed4));

        target =10; int[] position5 = {2, 4}; int[] speed5 = {3,2};
        System.out.println("car fleet count " + carFleet(target, position5, speed5));

    }
}
