package algorithm;

import java.util.PriorityQueue;

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
     *
     * https://leetcode.com/problems/merge-k-sorted-lists/
     * https://www.youtube.com/watch?v=q5a5OiGbT6Q
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

    public static ListNode mergeUsingPriorityQueue(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for(ListNode list : lists){
            minHeap.add(list);
        }

        while(!minHeap.isEmpty()){
            ListNode list = minHeap.poll();
            current.next = list;
            current = current.next;

            if(list.next != null){
                minHeap.offer(list.next);
            }

        }
        return dummy.next;
    }

    public static ListNode mergeUsingMergeSort(ListNode[] lists) {
        ListNode merged = merge(lists, 0, lists.length-1);
        return merged;
    }

    private static ListNode merge(ListNode[] lists, int start, int end){
        if(start > end)
            return null;
        if(start == end)
            return lists[start];
        if( start+1 == end){
            return mergeTwoLists(lists[start], lists[end]);
        }
        int mid = start + (end - start )/2;
        ListNode upper = merge(lists, start, mid);
        ListNode lower = merge(lists, mid+1, end);
        return mergeTwoLists(upper, lower);
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
        System.out.print("(Brute-force) Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        result = mergeUsingPriorityQueue(new ListNode[]{l1, l2, l3});
        System.out.print("\n(Priority Queue) Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        result = mergeUsingMergeSort(new ListNode[]{l1, l2, l3});
        System.out.print("\n(Merge Sort) Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
