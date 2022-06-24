package algorithm;

public class LRUCacheMain {
    public static void main(String ...args){
//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//
//        System.out.println(cache.get(1));
//        cache.put(3, 3);
//        System.out.println(cache.get(2));
//        cache.put(4, 4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

//         LRUCache cache = new LRUCache(2);
//         cache.put(1, 0);
//         cache.put(2, 2);
//         System.out.println(cache.get(1));
//         cache.put(3, 3);
//         System.out.println(cache.get(2));
//         cache.put(4, 4);
//         System.out.println(cache.get(1));
//         System.out.println(cache.get(3));
//         System.out.println(cache.get(4));

//        LRUCache cache = new LRUCache(2);
//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        //["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
        //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5, 5);
        System.out.println("-----");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}
