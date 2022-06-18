package algorithm;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


// Time Complexity: O(NLOgN)
// Space Complexity : O(N)
// See TimeBasedMap for ArrayList implementation.
//https://leetcode.com/problems/time-based-key-value-store/
//https://www.youtube.com/watch?v=fu2cD_6E8Hw
public class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap(){
        timeMap = new HashMap<>();
    }

    // set the map by string key and set the tree map by time into a tree map.
    public void set(String key, String value, int timestamp) {
            timeMap.putIfAbsent(key, new TreeMap<>());
            timeMap.get(key).put(timestamp, value);
    }

    // 1. if the treemap is null then return empty string
    // 2. otherwise get the floorKey meaning key is lower than requested time stamp if it doesn't exist
    // 3. if the floor is null then return empty string
    // 4. otherwise get the key.
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = timeMap.get(key);
        if(treeMap==null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);

        if(floor == null)
            return "";
        return treeMap.getOrDefault(floor, "");
    }
}
