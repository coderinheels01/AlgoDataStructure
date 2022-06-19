package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class ReorderList {

    /*
     * 1. find the middle of the node using slow and fast pointers.
     * 2. reverse half the list once the slow pointer is pointing to the middle of the list.
     * 3. create a new head and set values of half of original list and reversed list alternatively
     *    by checking if current node count is even or odd. if it's even set the node with non-reversed value.
     *    otherwise set it with value from reversed list.
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

        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node prev = null;
        Node current = slow;

        while(current != null){
           Node next =  current.getNext();
           current.setNext(prev);
           prev = current;
           current = next;
        }

        Node tempHead = new Node();
        Node newHead = tempHead;
        int count = 0;
        while(prev != null && head != null){
            if(count%2 == 0){
                tempHead.setNext(head);
                head = head.getNext();
            }
            else{
                tempHead.setNext(prev);
                prev = prev.getNext();
            }
            count++;
            tempHead = tempHead.getNext();
        }
        PrintUtil.printLinkedList(newHead.getNext());
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
