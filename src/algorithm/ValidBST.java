package algorithm;
import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

public class ValidBST {

    /*
     * 1. call dfs function with -Infinity and Infinity as boundaries
     */
    public static boolean isValidBST(Node root) {
        return dfsWithBoundary(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    /*
     * 1. base case: return true if the root is null
     * 2. return true
     *    a) if the current root value is within boundary and
     *    b) if the recursive call on left subtree is true ( by passing root.value as rightBoundary )
     *    c) if the recursive call on right subtree is true ( by passing root.value as leftBoundary)
     * NOTE. everytime the direction change to left or to right, left or right boundaries change.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/validate-binary-search-tree/
     */
    private static boolean dfsWithBoundary(Node root, long leftBoundary, long rightBoundary){
        if(root == null){
            return true;
        }
        return root.val > leftBoundary && root.val < rightBoundary && dfsWithBoundary(root.left, leftBoundary, root.val) && dfsWithBoundary(root.right, root.val , rightBoundary);
    };

    public static  void main(String ...args){
        Node root = new Node(12);
        root.left  = new Node(7);
        root.left.left = new Node(5);
        root.left.right = new Node(9);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(11);
        root.right  = new Node(18);
        root.right.right  = new Node(25);
        root.right.left  = new Node(14);
        root.right.left.right = new Node(15);

        PrintUtil.printBinaryTree(root);
        System.out.println("isValidBST " + isValidBST(root));

        root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        PrintUtil.printBinaryTree(root);
        System.out.println("isValidBST " + isValidBST(root));

        //[     2
        //   1     4
        // 7   4   8 3
        //6 4 7

        root = new Node(2147483647);
        PrintUtil.printBinaryTree(root);
        System.out.println("isValidBST " + isValidBST(root));



    }
    
}
