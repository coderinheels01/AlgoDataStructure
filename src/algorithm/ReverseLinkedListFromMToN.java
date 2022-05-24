package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class ReverseLinkedListFromMToN {

    /*
     * 1. get a hold of the previous node of the list that is starting point of the
     *    list that is going to be reversed.
     * 2. starting point node of the list that needs to be reversed is going to be the tail
     *    at the end of the reversal. so store that value in tail
     * 4. start the reversal process as long as current position is between m and n.
     * 5. set the reversed list to the next of the starting point.
     * 4. set the left over list ( current ) to the next of the tail.
     * 5. return the head node.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/reverse-linked-list-ii/
     *
     */
    public static Node reverseMToN(Node head, int m, int n){

        int currentPosition = 1;
        Node current = head;
        Node start = null;

        // get a hold of node before head node of the list to be reversed.
        while(currentPosition < m){
            start = current;
            current = current.getNext();
            currentPosition++;
        }

       Node prev = null;
       Node tail = current; // get a hold of the node that is going to be the tail at the end of the reversal.
       Node next;

       while(currentPosition >= m && currentPosition <=n){
           next = current.getNext();
           current.setNext(prev);
           prev = current;
           current = next;
           currentPosition++;
       }
       if(start != null) start.setNext(prev);
       if(tail != null) tail.setNext(current);

       if(m >1 )
           return head;
     return prev;
    }


    public static void main(String ...args){
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));
        head.getNext().getNext().getNext().setNext(new Node(5));
        int m = 1;
        int n = 4;
        System.out.println(" ----- ORIGINAL Linked List ----- ");
        PrintUtil.printLinkedList(head);
        System.out.println(" ----- REVERSE M TO N ----- ");
        PrintUtil.printLinkedList(reverseMToN(head, m, n ));
    }
}
