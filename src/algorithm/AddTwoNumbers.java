package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

import java.util.Stack;

public class AddTwoNumbers {

    public static void main(String... args){
        // 342 + 46 = 388
        Node list1 = new Node(3, new Node(4, new Node(2)));
        Node list2 = new Node(4, new Node(6));

        //PrintUtil.printLinkedList(addTwoNumbersWithStack(list1, list2));
        PrintUtil.printLinkedList(addTwoNumbersWithReverseLinkedList(list1, list2));
    }

    /*
     * https://www.youtube.com/watch?v=_jm-KKZE9x8&t=97s
     * Time complexity - O(N)
     * Space complexity - O(N)
     */
    public static Node addTwoNumbersWithStack(Node list1, Node list2){
        Stack<Node> stack1 = convertToStack(list1);
        Stack<Node> stack2 = convertToStack(list2);

        Node newNode;
        Node result = null;
        int sum;
        int carry =0;

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            Node node1 = !stack1.isEmpty() ? stack1.pop(): new Node();
            Node node2 = !stack2.isEmpty() ? stack2.pop() : new Node();
            sum = ( carry + node1.getValue() + node2.getValue() ) % 10;
            carry = ( carry + node1.getValue() + node2.getValue() ) /10;

            newNode = new Node(sum);
            newNode.setNext(result);
            result = newNode;
        }
        if(carry > 0)
            result.addNext(carry);

        return result;
    }

    private static Stack<Node> convertToStack(Node node){
        Stack<Node> stack = new Stack<>();

        while(node != null){
            stack.push(node);
            node = node.getNext();
        }
        return stack;
    }


    public static Node addTwoNumbersWithReverseLinkedList(Node list1, Node list2){
        Node reversedList1 = reverse(list1);
        Node reversedList2 = reverse(list2);
        Node node;
        Node result = null;

        int carry = 0;
        int value1;
        int value2;
        int sum;

        while(reversedList1 != null || reversedList2 != null){
            value1 = reversedList1 != null ? reversedList1.getValue() :0;
            value2 = reversedList2 != null ? reversedList2.getValue() :0;
            sum = (carry + value1 + value2) %10;
            carry = (value1 + value2 ) / 10;
            node = new Node(sum);
            node.setNext(result);
            result = node;

            if(reversedList1 != null)
                reversedList1 = reversedList1.getNext();
            if(reversedList2 != null)
             reversedList2 = reversedList2.getNext();
        }

        return result;
    }

    private static Node reverse(Node head){
        Node prev = null;
        Node next;
        while( head != null){
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }

        return prev;
    }

}
