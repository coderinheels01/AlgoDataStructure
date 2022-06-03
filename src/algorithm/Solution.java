package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class Solution {

//    public static Node reverse(Node head){
//        Node current = head;
//        Node next;
//        Node prev = null;
//        while(current != null){
//            next = current.getNext();
//            current.setNext(prev);
//            prev = current;
//            current = next;
//        }
//        return prev;
//    }
//
//    public static Node reverseRecursive(Node head){
//        return reverse(head, null);
//    }
//
//    public static Node reverse(Node current, Node previous){
//        if(current == null)
//            return previous;
//        Node next = current.getNext();
//        current.setNext(previous);
//        previous = current;
//        current = next;
//        return reverse(current, previous);
//    }

    public static void main(String ...args){
//        Node head = new Node(1);
//        head.setNext(new Node(2));
//        head.getNext().setNext(new Node(3));
//        head.getNext().getNext().setNext(new Node(4));
//        System.out.println(" ----- ORIGINAL Linked List ----- ");
//        PrintUtil.printLinkedList(head);
//        System.out.println(" ----- AFTER REVERSED -----");
//        PrintUtil.printLinkedList(reverse(head));
//
//        head = new Node(1);
//        head.setNext(new Node(2));
//        head.getNext().setNext(new Node(3));
//        head.getNext().getNext().setNext(new Node(4));
//
//        System.out.println(" ----- AFTER REVERSED (Recursive)-----");
//        PrintUtil.printLinkedList(reverseRecursive(head));

        int val  = 20;

        System.out.println( Integer.valueOf(val));

    }
}
