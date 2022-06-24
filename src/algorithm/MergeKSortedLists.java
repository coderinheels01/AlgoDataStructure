package algorithm;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

    /*
     * brute-force way of merging.
     *
     * 1. create a private function called merged two lists.
     * 2. create a list called merged and assign it with null initially.
     * 3. merge null and the first list the assign the result to merged.
     * 4. repeat merging the merged list and the next list
     * 5. return the merged list.
     *
     * Time Complexity : O(k * N)
     * Space Complexity: O(1)
     */
    public static ListNode mergeBruteForce(ListNode[] lists) {
        if(lists.length == 1)
            return lists[0];

        ListNode merged = null;
        for(ListNode list : lists){
            merged = mergeTwoLists(merged, list);
        }
        return merged;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){

        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while( l1 != null && l2!= null){
            if(l1.val < l2.val){
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        if(l1!= null){
            current.next = l1;
            current = current.next;
        }
        if(l2 != null){
            current.next = l2;
            current = current.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = mergeBruteForce(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
