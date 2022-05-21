package algorithm;
import algorithm.util.Node;
import algorithm.util.PrintUtil;

public class MergeTwoSortedList {

    /*
     * 1. base cases: if list1 is null, return list2. if list2 is null, return list1
     * 2. create a new list with the first node being 0
     * 3. create another node and keep the pointer to the new list'
     * 4. while list1 and list2 aren't null,
     *    1) check if list1 value is greater than list2 value? if yes then assign list2 value to the next node of list3. Then move the list2 pointer to the next node.
     *    2) heck if list2 value is greater than list1 value? if yes then assign list1 value to the next node of list3. Then move the list1 pointer to the next node.
     * 5. check if list1 or list2 still have leftover nodes. if yes then attach them to list3.
     * 6. return head.next because head is the dummy node created.
     *
     *
     * https://leetcode.com/problems/merge-two-sorted-lists/
     * https://www.youtube.com/watch?v=KVf1Uuqfv8E&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=26
     *
     * Time Complexity: O(N)
     * Space Complexity : O(N)
     */
    public static Node merge(Node list1, Node list2){
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        Node list3 = new Node(0);
        Node head = list3;

        while(true){
            if(list1 == null || list2 == null)
                break;

            if(list1.getValue() > list2.getValue()){
                list3.setNext(list2);
                list2 = list2.getNext();
            }
            else{
                list3.setNext(list1);
                list1 = list1.getNext();
            }
            list3 = list3.getNext();
        }

        if(list1 != null)
            list3.setNext(list1);
        else list3.setNext(list2);

        return head.getNext();
    }
    public static void main(String ...args){
        //list1 = [1,2,4], list2 = [1,3,4]

        Node list1 = new Node(1);
        list1.setNext(new Node(2));
        list1.getNext().setNext(new Node(4));

        Node list2 = new Node(1);
        list2.setNext(new Node(3));
        list2.getNext().setNext(new Node(4));

        System.out.println(" ----- ORIGINAL LISTS ----- ");
        System.out.println("list 1 ");
        PrintUtil.printLinkedList(list1);
        System.out.println("list 2");
        PrintUtil.printLinkedList(list2);
        System.out.println("merged lists ");
        PrintUtil.printLinkedList(merge(list1, list2));
    }
}
