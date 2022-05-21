package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.Stack;

public class BinaryTreePruning {

    /*
     * https://www.youtube.com/watch?v=77LJc56bwnE&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=33
     * https://leetcode.com/problems/binary-tree-pruning/
     *
     * 1. if the left sub tree value is not 0 and it's left and right sub-tree are both null.
     *    then prune left sub-tree
     * 2. same for the right sub-tree
     * 
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static Node pruneTreeRecursive(Node root) {
        if(root == null)
            return null;

        containsOne(root);
         return root;
    }

    private static boolean containsOne(Node node){
        if (node == null) return false;
        boolean containsLeft = containsOne(node.left);
        boolean containsRight = containsOne(node.right);
        if(!containsLeft)
            node.left = null;
        if(!containsRight)
            node.right = null;
        return node.val == 1 || containsLeft || containsRight;
    }


    public static void main(String ...args){
        Node root = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(1);

        System.out.println("----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("----- AFTER PRUNING ----- ");
        PrintUtil.printBinaryTree(pruneTreeRecursive(root));
    }
}
