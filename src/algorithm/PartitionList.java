package algorithm;


import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class PartitionList {
    /*
     * 1. create two dummy nodes for left sub list
     * 2. create two dummy nodes for right sub list
     * 3. loop until the head becomes null.
     * 4. if the value is less than x then put the node into left sub-list
     * 5. if the value is greater than or equal to x then put the node into right sub-list
     * 6. connect the head of right sub-list to the tail of the left sub-list
     * 7. return next of the head of left subtree.
     *
     *
     * Time Complexity : O(N)
     * Space Complexity: O(1)
     *
     *    Input: head = [1,4,3,2,5,2], x = 3
     *   Output: [1,2,2,4,3,5]
     *
     * https://leetcode.com/problems/partition-list/submissions/
     * https://www.youtube.com/watch?v=KT1iUciJr4g
     * https://www.youtube.com/watch?v=K5AVJVjdmL0&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=37
     */
    public static Node partition(Node head, int x) {
        Node left = new Node(0);
        Node headLeft = left;
        Node right = new Node(0);
        Node headRight = right;

        while(head != null){
            if(head.getValue() < x ){
                left.setNext(head);
                left = left.getNext();
            }
            else{
                right.setNext(head);
                right = right.getNext();
            }
            head = head.getNext();
        }
        right.setNext(null);
        left.setNext(headRight.getNext());

        return headLeft.getNext();
    }

    public static void main(String ...args){
        //1,4,3,2,5,2
        Node head = new Node(1);
        head.setNext(new Node(4));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(2));
        head.getNext().getNext().getNext().setNext(new Node(5));
        head.getNext().getNext().getNext().getNext().setNext(new Node(2));
        int x = 3;

        System.out.println("----- ORIGINAL LIST -----");
        PrintUtil.printLinkedList(head);
        System.out.println("----- AFTER PARTITION BY VALUE "+ x +"-----");
        PrintUtil.printLinkedList(partition(head, x));
    }
}
