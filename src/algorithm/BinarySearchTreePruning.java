package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

public class BinarySearchTreePruning {

    /*
     * 1. base case: if root is null return null
     * 2. if the current node value falls within low and high, then run algo on both left and right sub-trees
     * 3. if the current node value is less than low, then discard the left sub-tree because all the values in left sub-tree
     *    are less than current node in BST. Then replace current node with it's right sub-tree
     * 4. if the current node value is greater than high, then discard the right sub-tree because ll the values in right sub-tree
     *    are greater than current node in BST. Then replace current node with it's left sub-tree
     *
     * Time Complexity : O(N)
     * Space Complexity : O(H)
     *
     * https://www.youtube.com/watch?v=jwt5mTjEXGc
     * https://leetcode.com/problems/trim-a-binary-search-tree/
     *
     */
    public static Node trimBST(Node root, int low, int high) {
        if(root == null)
            return null;

        if(root.val >= low && root.val <= high){
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        else if(root.val < low){
            root.left = null;
            root = trimBST(root.right, low, high);
        }
        else{
            root.right = null;
            root = trimBST(root.left, low, high);
        }


        return root;
    }
    public static void main(String ...args){
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(2);

        int low = 1;
        int high = 2;
        /*
         *   1
         * 0  2
         * low=1, high = 2
         */
        System.out.println("----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("----- TRIMMED TREE ----- ");
        PrintUtil.printBinaryTree(trimBST(root, low, high));


        root = new Node(3);
        root.left = new Node(0);
        root.left.right = new Node(2);
        root.left.right.left = new Node(1);
        root.right = new Node(4);

         low = 1;
         high = 3;
        /*
         *   1
         * 0  2
         * low=1, high = 2
         */
        System.out.println("----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("----- TRIMMED TREE ----- ");
        PrintUtil.printBinaryTree(trimBST(root, low, high));
    }
}
