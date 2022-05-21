package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class MiddleElementInLinkedList {

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> null
    // 1. slow = 1, fast =1
    // 2. slow = 2, fast = 3,
    // 3. slow = 3, fast = 5
    // 4. slow = 4, fast = 7
    // 5. slow = 5, fast = 9
    // 6. slow = 6, fast = 11
    // 7. slow = 7, fast = 13
    // 8. slow = 8, fast = 15

    public static void main(String... args){
        Node head = new Node(1);
        head.addNext(2);
        head.getNext().addNext(3);
        head.getNext().getNext().addNext(4);
        head.getNext().getNext().getNext().addNext(5);

        System.out.println("linked list");
        PrintUtil.printLinkedList(head);
        System.out.println("Middle element = " + findMiddle(head));
    }

    public static int findMiddle(Node node){
        Node slow = node;
        Node fast = node;
        while(fast.getNext() != null && fast.getNext().getNext() != null ){
            slow  = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getValue();
    }
}
