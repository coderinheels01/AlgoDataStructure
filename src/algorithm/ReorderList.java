package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class ReorderList {

    /*
     * 1. find the middle of the node using slow and fast pointers. Keep a pointer called slowTail to keep the previous pointer of slow. so we can set it to null
     *    and break the link list in half.
     * 2. reverse half the list once the slow pointer is pointing to the middle of the list.
     * 3. merge the two lists
     *     a) get the pointer of first.next and second.next.
     *     b) set the first.next to second. ( 1 -> 5)
     *     c) if firstNext is null break out of the loop. because we have already merged the list successfully.
     *     d) set second.next to first.next ( 1 -> 5 -> 2)
     *     e) move both pointers to next, first = firstNext; second = secondNext;
     *
     * Time Complexity: O(N)
     * Space complexity :O(1)
     *
     * https://leetcode.com/problems/reorder-list/
     * https://www.youtube.com/watch?v=S5bfdUTrKLM
     */
    public static void reorderListOptimized(Node head) {
        Node slow = head;
        Node fast = head;
        Node slowTail = null;
        while(fast != null && fast.getNext() != null){
            slowTail= slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        slowTail.setNext(null);
        Node prev = null;
        Node current = slow;

        while(current != null){
           Node next =  current.getNext();
           current.setNext(prev);
           prev = current;
           current = next;
        }

        Node first = head;
        Node second = prev;

        while(first != null){
            Node firstNext = first.getNext();
            Node secondNext = second.getNext();

            first.setNext(second);
            if(firstNext == null)
                break;

            second.setNext(firstNext);

            first= firstNext;
            second = secondNext;
        }

        PrintUtil.printLinkedList(head);

//        Node tempHead = new Node();
//        Node newHead = tempHead;
//        int count = 0;
//        while(prev != null && head != null){
//            if(count%2 == 0){
//                tempHead.setNext(head);
//                head = head.getNext();
//            }
//            else{
//                tempHead.setNext(prev);
//                prev = prev.getNext();
//            }
//            count++;
//            tempHead = tempHead.getNext();
//        }
//
//        while(prev != null){
//            tempHead.setNext(prev);
//            prev = prev.getNext();
//            tempHead = tempHead.getNext();
//        }


//PrintUtil.printLinkedList(newHead.getNext());

    }

    public static void main (String... args) {
        Node node = new Node(1);
        node.setNext(new Node(2));
        node.getNext().setNext(new Node(3));
        node.getNext().getNext().setNext(new Node(4));
        node.getNext().getNext().getNext().setNext(new Node(5));
        System.out.println("----- ORIGINAL LIST -----");
        PrintUtil.printLinkedList(node);
        System.out.println("----- REORDER LIST -----");
        reorderListOptimized(node);


        node = new Node(1);
        node.setNext(new Node(2));
        node.getNext().setNext(new Node(3));
        node.getNext().getNext().setNext(new Node(4));
        System.out.println("----- ORIGINAL LIST -----");
        PrintUtil.printLinkedList(node);
        System.out.println("----- REORDER LIST -----");
        reorderListOptimized(node);
    }
}
