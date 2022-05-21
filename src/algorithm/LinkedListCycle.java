package algorithm;
import algorithm.util.Node;

import java.util.HashSet;

public class LinkedListCycle {

    /*
     * https://leetcode.com/problems/linked-list-cycle/submissions/
     *
     * Using HashSet
     * 1. loop the linked list.
     * 2. check if the node is already in the set? if yes return true
     * 3. otherwise add the node to the set
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static boolean hasCycleHasSet(Node head){
        HashSet<Node> set = new HashSet<>();
        Node current = head;
        while(current  != null){
            if(set.contains(current)){
                return true;
            }
            else{
                set.add(current);
            }
            current = current.getNext();
        }

        return false;
    }
    /*
     * 1. we will use two pointers.
     * 2. slow pointer will always jump one node
     * 3. fast pointer will always jum two nodes
     * 4. fast pointer will catch up slow pointer from the back and they will be the
     *    same nodes if it has a cycle.
     *
     * Time Complexity : O(N)
     * Space Complexity: O(1)
     * https://www.youtube.com/watch?v=agkyC-rbgKM
     * https://www.youtube.com/watch?v=6OrZ4wAy4uE&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=22
     */
    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String ...args){
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));
        head.getNext().getNext().getNext().setNext(new Node(5));
        head.getNext().getNext().getNext().getNext().setNext(head.getNext());

        System.out.println(" ----- METHOD 1 ----- ");
        System.out.println("does the linked list contains cycle?  " + hasCycleHasSet(head));
        System.out.println(" ----- METHOD 2 ----- ");
        System.out.println("does the linked list contains cycle?  " + hasCycle(head));

        head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));
        head.getNext().getNext().getNext().setNext(new Node(5));
        System.out.println(" ----- METHOD 1 ----- ");
        System.out.println("does the linked list contains cycle?  " + hasCycleHasSet(head));
        System.out.println(" ----- METHOD 2 ----- ");
        System.out.println("does the linked list contains cycle?  " + hasCycle(head));

    }
}


