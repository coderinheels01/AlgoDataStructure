package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
    static int sum;

    /*
     * 1. create a global variable called sum and initialize with 0
     * 2. traverse down left and right sub trees.
     * 3. if the root left leaf node is found add to the sum.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/sum-of-left-leaves/
     */
    public static int sumOfLeftLeavesRecursive(Node root) {
        sum = 0;

        traverse(root);
        return sum;
    };

    public static void traverse(Node root){
        if(root == null)
            return;
        if(root.left!= null && root.left.left == null && root.left.right == null){
            sum+= root.left.val;
        }
        traverse(root.left);
        traverse(root.right);
    }

    /*
     * 1. using a queue data structure, push both left and right into the queue if they are not null
     * 2. if the left node is the leaf node meaning it has both left and right null nodes then we add the value to the sum
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     *
     */
    public static int sumOfLeftLeavesIterative(Node root) {
        int sum = 0;
        Queue<Node> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left != null){
                if(node.left.left == null && node.left.right == null){
                    sum += node.left.val;
                }
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }

        }
        return sum;
    }
    public static void main(String ...args){

        /*
         *         3
         *       9   20
         *         15  7
         *
         * sum of all left leave nodes = 9 + 15 = 24
         */
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println("---- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive) sum of the left leaves is :  " + sumOfLeftLeavesRecursive(root));

        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println("---- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Iterative) sum of the left leaves is :  " + sumOfLeftLeavesIterative(root));


        /*
         *  1
         * sum of left leave nodes = 0
         */
        root = new Node(1);

        System.out.println("---- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive) sum of the left leaves is :  " + sumOfLeftLeavesRecursive(root));

        root = new Node(1);

        System.out.println("---- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Iterative) sum of the left leaves is :  " + sumOfLeftLeavesIterative(root));


        /*
         *         1
         *       2   3
         *      4 5
         *
         * sum of left leave nodes = 4
         */
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("---- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive) sum of the left leaves is :  " + sumOfLeftLeavesRecursive(root));

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("---- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Iterative) sum of the left leaves is :  " + sumOfLeftLeavesIterative(root));
    }
}
