package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class SortLinkedList {

     // 4 -> 2 -> 1 -> 3 -> null

    /*
     * do a merge sort.
     *
     * 1. using slow and fast pointers technique. move the pointer nodes slow and fast where fast points to end of the list, slow will points to the middle list.
     * 2. while traversing, assign slow to a temp because we will need to use this to break the linked list.
     * 3. break the link by assigning temp.next to null
     * 4. run recursive call on head and slow, to break down the list to just single nodes each.
     *     for example: leftSide = 4, rightSide = 2.
     *                  leftSide = 1, rightSide = 3
     *
     * 5. compare and merge each list.
     *
     * Time Complexity : O(NLogN)
     * Space Complexity : O(N)
     *
     * https://www.youtube.com/watch?v=pNTc1bM1z-4&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=46
     * https://leetcode.com/problems/sort-list/
     */
    public static Node sort(Node head){
        if(head == null || head.getNext() == null)
            return head;

        Node slow = head;
        Node fast = head;
        Node temp = head;
        while(fast != null && fast.getNext() != null){
            temp = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        temp.setNext(null);
        Node leftSide = sort(head);
        Node rightSide = sort(slow);

        Node mergedList = mergeSort(leftSide, rightSide);
        return mergedList;
    }

    private static Node mergeSort(Node leftSide, Node rightSide){
            Node temp = new Node(0);
            Node currentNode = temp;
            while(leftSide != null && rightSide != null){
                if(leftSide.getValue() < rightSide.getValue()){
                    currentNode.setNext(leftSide);
                    leftSide = leftSide.getNext();
                }
                else{
                    currentNode.setNext(rightSide);
                    rightSide = rightSide.getNext();
                }

                currentNode = currentNode.getNext();
            }

            if(leftSide != null){
                currentNode.setNext(leftSide);
            }
            if(rightSide != null ){
                currentNode.setNext(rightSide);
            }
            return temp.getNext();
    }


    public static void main(String ...args){
        Node head = new Node(4);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(1));
        head.getNext().getNext().setNext(new Node(3));

        System.out.println(" ----- ORIGINAL LIST ----- ");
        PrintUtil.printLinkedList(head);
        System.out.println("----- SORTED LIST ----- ");
        PrintUtil.printLinkedList(sort(head));

    }
}
