package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

import java.util.Stack;

public class IsSinglyLInkedListPalindrome {
    /*
     * using stack
     * 1. loop the singly linkedlist and push into stack
     * 2. loop the singly linkedlist again and compare current node with
     *    the value popped from the stack.
     * 3. if they differ, the linked list is not palindrome. otherwise it is
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static boolean isPalindromeMethod1(Node node){
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while(current != null){
            stack.push(current);
            current = current.getNext();
        }

        while(node != null){
            if(node.getValue() != stack.pop().getValue()){
                return false;
            }
            node = node.getNext();
        }

        return true;
    }
    /*
     * without using additional data structure. find middle node, reverse the second half of the
     * node and compare the reversed second half with the first half of the node.
     *
     * 1. find the middle node by using slow pointer and fast pointer. fast pointer will be
     *    hopping two nodes at at time. By the time fast reaches null or fast.next reaches null
     *    slow pointer will be pointing to the middle node.
     * 2. if the fast pointer is null, it means the linked list has even number of nodes.
     * 3. if the fast pointer is not null, it means the linked list has odd number of nodes and slow pointer needs to
     *    move by one node because in this case we don't want to ignore the middle node.
     * 4. reverse the slow node.
     * 5. reset fast node to the head
     * 6. iterate the slow and fast node then compare each node value.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * https://www.youtube.com/watch?v=wk4QsvwQwdQ&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=6
     *
     */
    public static boolean isPalindromeMethod2(Node node){
        Node slow = node;
        Node fast = node;

        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        if(fast != null){
            slow = slow.getNext();
        }
        Node reversedSlow = reverse(slow);
        fast = node;

        while(reversedSlow != null){
            if(reversedSlow.getValue() != fast.getValue()){
                return false;
            }
            reversedSlow = reversedSlow.getNext();
            fast = fast.getNext();
        }
        return true;
    };

    private static Node reverse(Node head){
        Node prev = null;
        // 3 -> 2 -> 1 -> null
        while(head != null){
            Node next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String ...args){
        // 1 -> 2 -> 3 -> 3 -> 2 -> 1 -> null
        Node even = new Node(1);
        even.setNext(new Node(2));
        even.getNext().setNext(new Node(3));
        even.getNext().getNext().setNext(new Node(3));
        even.getNext().getNext().getNext().setNext(new Node(2));
        even.getNext().getNext().getNext().getNext().setNext(new Node(1));

        // 1 -> 2 -> 3 -> 2 -> 1
        Node odd = new Node(1);
        odd.setNext(new Node(2));
        odd.getNext().setNext(new Node(3));
        odd.getNext().getNext().setNext(new Node(2));
        odd.getNext().getNext().getNext().setNext(new Node(1));

        System.out.println(" --------- METHOD 1 --------- ( using stack )");
        PrintUtil.printLinkedList(even);
        System.out.println("Is the list above palindrome? " + isPalindromeMethod1(even));
        PrintUtil.printLinkedList(odd);
        System.out.println("Is the list above palindrome? " + isPalindromeMethod1(odd));

        System.out.println(" --------- METHOD 2 --------- ( no extra data structure )");
        PrintUtil.printLinkedList(even);
        System.out.println("Is the list above palindrome? " + isPalindromeMethod2(even));
        PrintUtil.printLinkedList(odd);
        System.out.println("Is the list above palindrome? " + isPalindromeMethod2(odd));
    }
}
