package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class EvenOddLinkedLIst {
    /*
     * https://leetcode.com/problems/odd-even-linked-list/
     *
     * 1. create a new node called odd and assign the head.
     * 2. create a new node called even and assign odd.next.
     * 3. create a new node called evenHead and hold the pointer to the even node.
     * 4. while even node is not null or even.next is not null.
     *    a) set odd.next to even.next.
     *    b) move the odd pointer to next.
     *    c) set even.next to odd.next.
     *    d) move the even pointer to the next.
     * 5. now that odd is at the last node. Attach evenHead to the odd linked list.
     * 6. return the head because the head is still pointing to the first node.
     *
     * https://www.youtube.com/watch?v=C_LA6SOwVTM&t=98s
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public static Node oddEvenList(Node head){
        Node odd = head;
        Node even = odd.getNext();
        Node evenHead = even;

        while(even != null && even.getNext() != null){
            odd.setNext(even.getNext());
            odd = odd.getNext();
            even.setNext(odd.getNext());
            even = even.getNext();
        }

        odd.setNext(evenHead);

        return head;
    }
    public static void main(String ...args){
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));
        head.getNext().getNext().getNext().setNext(new Node(5));

        System.out.println("----- ORIGINAL LINKED LIST ----- ");
        PrintUtil.printLinkedList(head);

        System.out.println("----- EVEN ODD LINKED LIST ----- ");
        PrintUtil.printLinkedList(oddEvenList(head));
    }
}
