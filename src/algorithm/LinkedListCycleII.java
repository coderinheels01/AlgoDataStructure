package algorithm;
import algorithm.util.Node;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    /*
     * Using as set, try to save all the nodes that has been seen.
     * The first node that returns true to see if it's in the hash set
     * is the one the first node that starts the cycle
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/linked-list-cycle-ii/
     */
    public static Node detectCycleMoreMemory(Node head){
        Node current = head;
        Set<Node> seen = new HashSet<>();

        while(current != null){
            if(seen.contains(current)){
                return current;
            }
            else{
                seen.add(current);
            }
            current = current.getNext();
        }
        return null;
    }

    /*
     *
     * 1. Using two pointers (slow and fast) detect if the linked list has a node.
     * 2. if the pointers meet, break out of the loop
     * 3. To find the pointer that started the cycle, instantiate one pointer with the head, the other with
     *    the pointer where slow and fast meet.
     * 4. move head and slow/fast pointer one step at a time and check if they are equal. Once they are equal
     *    it's when the cycle starts.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public static Node detectCycleOptimized(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.getNext() != null){
            slow = slow.getNext();
            fast  = fast.getNext().getNext();
            if(slow == fast)
                break;
        }

        Node start = head;
        while(start != null && fast != null){
            start = start.getNext();
            fast = fast.getNext();
            if(start == fast)
                return start;
        }

        return null;
    }

    public static void main(String ...args){
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));
        head.getNext().getNext().getNext().setNext(new Node(5));
        head.getNext().getNext().getNext().getNext().setNext(head.getNext().getNext());

        Node firstPointer = detectCycleMoreMemory(head);
        if(firstPointer != null)
            System.out.println("The list has a cycle and the first pointer it meets is at : " + firstPointer.getValue());
        else{
            System.out.println("The list does not have cycle.");
        }

        firstPointer = detectCycleOptimized(head);
        if(firstPointer != null)
            System.out.println("The list has a cycle and the first pointer it meets is at : " + firstPointer.getValue());
        else{
            System.out.println("The list does not have cycle.");
        }
    }
}
