package algorithm;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer {

    /*
     * We will do double pass with this approach
     * 1. first pass we will put the original node as key and it's deep copy value wihtout any next or random pointers as value.
     * 2. We will need two dummy pointers to store the final result. one to traverse to next pointer, another one to hold the head pointer
     *    of the list.
     * 3. traverse the original list again and get each node from hash map then assign it's next to the map value. As well as the random
     *    pointer of the next node.
     * 4. return the next of the dummy pointer.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/copy-list-with-random-pointer/
     * https://www.youtube.com/watch?v=5Y2EiZST97Y
     */
    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node current = head;

        while(current != null){
            map.putIfAbsent(current, new Node(current.val));
            current = current.next;
        }

        Node node = head;
        Node newHead = new Node(0);
        Node dummy = newHead;
        while(node != null){
            newHead.next = map.get(node);
            newHead.next.random = map.get(node.random);
            newHead = newHead.next;
            node = node.next;
        }

        return dummy.next;
    }

    public static void main(String ...args){
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = new Node(11);
        head.next.next.random = new Node(1);
        head.next.next.random.random = head;
        head.next.next.next = new Node(10);
        head.next.next.next.next = head.next.next.random;
        head.next.next.next.random = head.next.next;

        copyRandomList(head);
    }
}
