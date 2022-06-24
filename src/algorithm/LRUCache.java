package algorithm;

import java.util.HashMap;
import java.util.Map;

/*
 * LRU cache
 * https://leetcode.com/problems/lru-cache/
 * https://www.youtube.com/watch?v=7ABFKPK2hD4&t=858s
 */
class DoubleNode{
    int key;
    int value;
    DoubleNode prev;
    DoubleNode next;
    public DoubleNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private Map<Integer, DoubleNode>  cache= new HashMap<>();
    private int capacity;
    DoubleNode lru;
    DoubleNode mru;
    public LRUCache(int capacity){
        this.capacity = capacity;
        lru = new DoubleNode(0, 0);
        mru = new DoubleNode(0, 0);
        lru.next = mru;
        mru.prev = lru;
    }

    private void remove(DoubleNode node){
        DoubleNode next = node.next;
        DoubleNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void insertAtRight(DoubleNode node){
        DoubleNode prev =  mru.prev;
        node.prev = prev;
        node.next = mru;
        prev.next = node;
        mru.prev = node;
    }

    public void put(int key, int value){

        if(cache.containsKey(key)){
            DoubleNode node = cache.get(key);
            remove(node);
            cache.remove(key);
        }
        else if( cache.size() >= this.capacity){
            cache.remove(lru.next.key);
            remove(lru.next);
        }
        DoubleNode newNode = new DoubleNode(key, value);
        insertAtRight(newNode);
        cache.put(key, newNode);
    }

    public int get(int key){
        DoubleNode node = cache.get(key);
        if(node  == null)
            return -1;
        remove(node);
        insertAtRight(node);
        return node.value;
    }
}
