package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair{
    int timestamp;
    String value;
    public Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}

// Time Complexity O(Log N ) implementation.
// Space Complexity O(N)
// See TimeMap for O(N LogN) implementation using TreeMap.
// https://leetcode.com/problems/time-based-key-value-store/
// https://www.youtube.com/watch?v=fu2cD_6E8Hw
public class TimeBasedMap {
    Map<String, List<Pair>> timeMap;
    public TimeBasedMap(){
        timeMap = new HashMap<>();
    }

    /*
     * 1. set the list of pair with empty array list if the key doesn't exist. then add the pair to the list
     */
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent( key, new ArrayList<>());
        timeMap.get(key).add(new Pair(timestamp, value));
    }

    /*
     * 1. get the list with key from the map
     * 2. do the binary search on the list.
     *    a) if the timestamp is equal to Pair.timestamp at mid  then return the value
     *    b) if the Pair.timestamp < timestamp, then do the search on the right sub-list but
     *       store the Pair.value in the time stamp becasue we will have to return the closest time stamp
     *       value smaller than timestamp
     *    c) otherwise, search in the left sub-list
     *
     * Time Complexity: O(LogN)
     * Space Complexity: O(N)
     */
    public String get(String key, int timestamp) {
        List<Pair> values = timeMap.getOrDefault(key, new ArrayList<>());
        int left =0; int right = values.size()-1;
        String result ="";
        while(left <= right){
            int mid = (left + right)/2;
            Pair value = values.get(mid);
            if(value != null && value.timestamp == timestamp){
                return value.value;
            }
            else if( value.timestamp < timestamp){
                result = value.value;
                left = mid+1;
            }
            else{
                right = right -1;
            }
        }

        return result;
    };
}
