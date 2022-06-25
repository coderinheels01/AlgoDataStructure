package algorithm;

public class ReverseNodesInKGroup {
    /*
     * 1. create a dummy node to hold head and another dummy node called group previous to hold the same value.
     * 2. traverse to kth node from groupPrevious. Initially this would be 1. 
     * 3. if kth node is null then break out of the loop.
     * 4. reverse groupPrevious and set previous to kth node's next. (unlike normal reverse node prev is not null, it is kth node)
     * 5. now groupPrevious is 3-> 4-> 5. we preserve this by storing it to temp
     * 6. groupPrevious.next  = kthNode ( this will make sure the reversed kth node is now the head of the dummy node). so 2-> 1-> 3->4 -> 5- null
     * 7. restore groupPrevious node by assignin gtemp node from step 5 to groupPrevious.
     * 
     * Time Complexity :O(N)
     * Space Complexity: O(1)
     *
     * https://leetcode.com/problems/reverse-nodes-in-k-group/
     * https://www.youtube.com/watch?v=1UOPsfP85V4
     *
     */
    public static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node groupPrevious = dummy;

        while(true){
            Node kNode = findKthNode(groupPrevious, k);
            if(kNode == null)
                break;
            Node groupNext = kNode.next;

            reverse(groupPrevious.next, kNode.next);

            Node temp = groupPrevious.next; // store it in temp to preserve groupPrevious. Group preivous is now 3 -> 4 -> 5 -> null
            groupPrevious.next = kNode; // put kth node to the beginning of the group. this will change dummy node to 0 -> 2-> 1-> 3 -> 4 -> 5 -null
            groupPrevious = temp;

        }
        return dummy.next;
    }

    private static Node findKthNode(Node node, int k){
        Node current = node;
        while(k > 0 ){
            current = node.next;
            node =node.next;
            k--;
        }
        return current;
    }

    private static Node reverse(Node node, Node kNode){
        Node prev = kNode;
        Node current = node;

        while(current != kNode){
            Node next = node.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String ...args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);

        Node result =  reverseKGroup(head, 2);

        Node result1 = result;
        System.out.println(result.val);

    }
}
