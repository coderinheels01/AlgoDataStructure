package algorithm;

import algorithm.util.Node;
import algorithm.util.PrintUtil;
import algorithm.util.SumResult;

public class AddTwoNumbersReversed {
    /*
     * https://leetcode.com/problems/add-two-numbers/
     */
    public static void main(String... args){
        Node list1 = new Node(2, new Node(4, new Node(3)));
        Node list2 = new Node(5, new Node(6, new Node(4)));

        //PrintUtil.printLinkedList(addTwoNumbers(list1, list2));

        list1 = new Node(9, new Node(9, new Node(9, new Node(9))));
        list2 = new Node(9, new Node(9));

        PrintUtil.printLinkedList(addTwoNumbers(list1, list2));
    }

    public static Node addTwoNumbers(Node l1, Node l2){
        SumResult result = new SumResult();
        int carryOver = 0;
        while(l1 != null || l2 != null){
            int num1 = l1 != null ? l1.getValue() : 0;
            int num2 =  l2 != null ? l2.getValue() : 0;
            int sum = (num1 + num2 + carryOver)%10;
            carryOver =  (carryOver + num1 + num2) /10;

            result.append(sum);

            if(l1 != null)
                l1= l1.getNext();
            if(l2 !=null )
                l2 = l2.getNext();
        }

        if(carryOver > 0){
            result.append(carryOver);
        }

        return result.getHead().getNext();
    };
}
