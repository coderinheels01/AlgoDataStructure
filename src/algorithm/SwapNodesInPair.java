package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class SwapNodesInPair {

    /*
     * 1. create a dummy node with value 0.
     * 2. attach the head to dummy.next.
     * 3. create a node called current that is the same as dummy node. We will use current to loop
     * 4. while current.next and current.next.next aren't null.
     *    a) grab first node which is current.next. ( current is 0, current.next is the real head )
     *    b) grab second node which is current.next.next ( current is 0, current.next.next is head.next)
     *    c) break the link between first node and second node by assigning firstNode.next = secondNode.next.
     *    d) swap the first node and second node by assigning current.next to first node and current.next.next to second node.
     * 5. return dummy.next.
     *
     * Time Complexity : O(N)
     * Space Complexity: O (1)
     * 
     * 
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     * https://www.youtube.com/watch?v=o811TZLAWOo
     * https://www.youtube.com/watch?v=-xwX521Ija4&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=35
     *
     */
    public static Node swapPairs(Node head) {
        if(head == null || head.getNext() == null)
            return head;
        Node dummy = new Node(0);
        dummy.setNext(head);
        Node current = dummy;

        while(current.getNext() != null && current.getNext().getNext() != null){
            Node firstNode = current.getNext();
            Node secondNode = current.getNext().getNext();
            firstNode.setNext(secondNode.getNext());
            current.setNext(secondNode);
            current.getNext().setNext(firstNode);
            current = current.getNext().getNext();
        }

        return dummy.getNext();
    }

    public static void main(String ...args){
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));
        System.out.println("----- ORIGINAL LINKED LIST ----- ");
        PrintUtil.printLinkedList(head);
        System.out.println("----- SWAPPED IN PAIR LINKED LIST ----- ");
        PrintUtil.printLinkedList(swapPairs(head));
    }
}
