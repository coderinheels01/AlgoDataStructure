package algorithm;

import java.util.*;

public class KeysAndRooms {
    /*
     * https://leetcode.com/problems/keys-and-rooms/
     * https://www.youtube.com/watch?v=Rz_-Kx0LN-E&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=28
     *
     * 1. create a boolean array, index is the room number.
     * 2. create a stack.
     * 3. mark the room 0 as seen by assigning seen[0] =true and push the lists at room 0 to stack.
     * 4. while stack is not empty,
     *    a) pop the stack.
     *    b) get each key and visit each room with the key.
     *    c) if the room has not been visited before, mark it as visited and then push the keys
     *       at that location to the stack.
     * 5. after the stack is fully popped, loop through the boolean array and see if any room has not been visited,
     *    if yes then return false.
     * 6. otherwise return true.
     *
     * Time Complexity : O(N^2)
     * Space complexity : O(N)
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> temp;
        seen[0] = true;
        stack.push(rooms.get(0));

        while(!stack.isEmpty()){
            temp = stack.pop();
            for(int roomNum: temp){
                if(!seen[roomNum]){
                    seen[roomNum] = true;
                    stack.push(rooms.get(roomNum));
                }
            }
        }
        for(int i=0; i < seen.length; i++){
            if(!seen[i])
                return false;
        }
        return true;
    };


    public static void main(String ...args){

        //int[][] rooms = {new ArrayList<>{Arrays.asList(1)},{2},{3},{}};

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(new ArrayList<>(Collections.singletonList(1)));
        rooms.add(new ArrayList<>(Collections.singletonList(2)));
        rooms.add(new ArrayList<>(Collections.singletonList(3)));
        rooms.add(new ArrayList<>());


        System.out.println("can visit all rooms? " + canVisitAllRooms(rooms));

        rooms = new ArrayList<>();

        rooms.add(new ArrayList<>(Arrays.asList(1, 3)));
        rooms.add(new ArrayList<>(Arrays.asList(1, 0, 3)));
        rooms.add(new ArrayList<>(Collections.singletonList(2)));
        rooms.add(new ArrayList<>(Collections.singletonList(0)));


        System.out.println("can visit all rooms? " + canVisitAllRooms(rooms));
    }
}
