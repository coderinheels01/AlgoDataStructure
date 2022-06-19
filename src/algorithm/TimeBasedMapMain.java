package algorithm;

public class TimeBasedMapMain {
    public static void main(String ...args){
        TimeBasedMap timeMap = new TimeBasedMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));


        timeMap.set("love","high",10);
        timeMap.set("love","low",20);
        System.out.println(timeMap.get("love",5));
        System.out.println(timeMap.get("love",10));
        System.out.println(timeMap.get("love",15));
        System.out.println(timeMap.get("love",20));
        System.out.println(timeMap.get("love",25));
    }
}
