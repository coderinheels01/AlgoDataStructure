package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {

    /*
     * 1. base case: if root is null then return 0
     * 2. if the root.val falls between low and high then return the sum of root.val + left sub-tree value + right sub-tree value
     * 3. otherwise return just the right sub-tree and left sub-tree
     *
     * Time Complexity : O(N)
     * Space Complexity : O(H)
     *
     * https://leetcode.com/problems/range-sum-of-bst/submissions/
     * https://www.youtube.com/watch?v=Re0QTM4hBuI&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=38
     */
    public static int rangeSumBSTRecursive(Node root, int low, int high) {
        if(root == null){
            return 0;
        }
        if(root.val >= low && root.val <= high)
            return root.val + rangeSumBSTRecursive(root.left, low , high) + rangeSumBSTRecursive(root.right, low , high);
        else if(root.val > low )
            return rangeSumBSTRecursive(root.left, low , high);
        else
            return rangeSumBSTRecursive(root.right, low , high);
    }
    /*
     * Iterative approach using queue.
     * Time Complexity : O(N)
     * Space Complexity: O(N)
     */
    public static int rangeSumBSTIterative(Node root, int low, int high) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node;
        int sum = 0;

        while(!q.isEmpty()){
            node = q.remove();
            if(node.val >= low && node.val <= high)
                sum += node.val;
            if(node.left!= null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        return sum;
    };
    public static void main(String ...args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.right = new Node(18);
        int low = 7, high =15;

        System.out.println("----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive) sum of tree nodes that falls between " + low + " and " + high + " is " + rangeSumBSTRecursive(root, low, high));
        System.out.println("(Iterative) sum of tree nodes that falls between " + low + " and " + high + " is " + rangeSumBSTIterative(root, low, high));

    }
}
