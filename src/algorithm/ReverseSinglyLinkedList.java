package algorithm;
import algorithm.util.Node;
import algorithm.util.PrintUtil;
import java.util.Stack;

public class ReverseSinglyLinkedList {

    public static void main (String... args){
        Node node = new Node(1);
        node.setNext(new Node(2));
        node.getNext().setNext(new Node(3));
        node.getNext().getNext().setNext(new Node(4));
        node.getNext().getNext().getNext().setNext(new Node(5));

        PrintUtil.printLinkedList(reverseIterative(node));

        Node node2 = new Node(1);
        node2.setNext(new Node(2));
        node2.getNext().setNext(new Node(3));
        node2.getNext().getNext().setNext(new Node(4));
        node2.getNext().getNext().getNext().setNext(new Node(5));

        PrintUtil.printLinkedList(reverseRecursive(node2, null));


        Node node3 = new Node(1);
        node3.setNext(new Node(2));
        node3.getNext().setNext(new Node(3));
        node3.getNext().getNext().setNext(new Node(4));
        node3.getNext().getNext().getNext().setNext(new Node(5));
        PrintUtil.printLinkedList(reverseStack(node3));
    }
    /*
     * https://www.youtube.com/watch?v=NhapasNIKuQ
     */
    public static Node reverseIterative(Node head){
        Node prev = null;
        Node next;

        while(head != null){
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        return prev;
    }
    /*
     * https://www.youtube.com/watch?v=W-EfGB0E_ao
     */
    public static Node reverseRecursive(Node head, Node prev){
        if(head == null)
            return prev;

        Node next = head.getNext();
        head.setNext(prev);
        prev = head;
        head = next;

        return reverseRecursive(head, prev);
    }


    /*
     * using a stack. add all the nodes to the stack; and pop each one and set next.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */

    public static Node reverseStack(Node head){
        Stack<Node> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.getNext();
        }
        Node newHead = stack.pop();
        Node next = newHead;
        while(!stack.isEmpty()){
            next.setNext(stack.peek());
            next = stack.pop();
        }
        next.setNext(null);
        return newHead;
    }
}
