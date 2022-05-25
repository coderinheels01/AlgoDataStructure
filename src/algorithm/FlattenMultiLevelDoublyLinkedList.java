package algorithm;

import algorithm.util.doubly.Node;
import algorithm.util.doubly.PrintUtil;

public class FlattenMultiLevelDoublyLinkedList {

    /*
     * 1. traverse the linked link but stop when the current node has a child
     * 2. if the current node has a child,
     *    a) save current node as previous node
     *    b) save current.next node as next node
     *    c) set next node of current node to current.child
     *    d) set current.child previous to current node.
     *    e) get pointer to child node so we can traverse.
     *    d) then kill the child sub list by setting current.child to null
     *    e) traverse the child nodes until the last node then set the last node next to previously saved
     *       next node. and set the previously saved next node's previous to current child. ( make sure to do  null pointer check
     *       since next could be pointing to null
     * 3. return the head
     *
     *
     *   Time Complexity : O(N)
     *   Space Complexity : O(1)
     *
     * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
     */
    public static Node flatten(Node head) {
        Node current = head;
        while(current != null){
            if(current.child != null){
                Node prev = current;
                Node next = current.next;
                prev.next = current.child;
                current.child.prev = prev;
                Node childHead = current.child;
                current.child = null;
                while(childHead.next != null){
                    childHead = childHead.next;
                }
                childHead.next = next;
                if(next != null)
                    next.prev = childHead;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String ...args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next.next;
        head.next.next.prev = head.next.next;
        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.prev = head.next.next.child;

        System.out.println("----- AFTER FLATTENING ----- ");
        PrintUtil.printDoublyLinkedList(flatten(head));
    }
}
