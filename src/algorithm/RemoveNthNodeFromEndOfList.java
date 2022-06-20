package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class RemoveNthNodeFromEndOfList {

    /*
     * 1. the key is to have a dummy node pointing to the node that needs to be removed.
     * 2. create a dummy node. Set the next of dummy node to current head node.
     * 3. assign both slow and fast nodes with dummy node.
     * 4. move the fast pointer by n. so fast pointer will be exactly n nodes apart from slow pointer.
     * 5. iterate both slow and fast by one pointer until fast hits null. Then we have slow pointer pointing at the previous node
     *    of the node that we want to delete.
     * 6. simply assign slow.next with slow.next.next to delete the node
     * 7. return dummy.next.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     * https://www.youtube.com/watch?v=XVuQxVej6y8
     *
     */
    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy  = new Node();
        dummy.setNext(head);
        Node slow = dummy;
        Node fast = dummy;

        while(n > 0){
            fast = fast.getNext();
            n--;
        }

        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext();
        }

        slow.setNext(slow.getNext().getNext());

        return dummy.getNext();
    }
    public static void main (String... args) {
        Node node = new Node(1);
        node.setNext(new Node(2));
        node.getNext().setNext(new Node(3));
        node.getNext().getNext().setNext(new Node(4));
        node.getNext().getNext().getNext().setNext(new Node(5));
        int n = 2;
        System.out.println("----- ORIGINAL LINKED LIST ----- ");
        PrintUtil.printLinkedList(node);

        Node head = removeNthFromEnd(node, n);

        System.out.println("----- AFTER REMOVAL OF N-TH NODE ----- ");
        PrintUtil.printLinkedList(head);

        node = new Node(1);
        node.setNext(new Node(2));
        n = 2;
        System.out.println("----- ORIGINAL LINKED LIST ----- ");
        PrintUtil.printLinkedList(node);

        head = removeNthFromEnd(node, n);

        System.out.println("----- AFTER REMOVAL OF N-TH NODE ----- ");
        PrintUtil.printLinkedList(head);


    }
}
