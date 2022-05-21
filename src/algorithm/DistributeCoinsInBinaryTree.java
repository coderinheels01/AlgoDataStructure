package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

public class DistributeCoinsInBinaryTree {
    static int moves =0;

    /*
     *
     * read the explanation in the below ink
     * https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal
     * https://www.youtube.com/watch?v=MfXxic8IhkI&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=40
     */
    public static int distributeCoins(Node root) {
        if(root == null)
            return 0;

        giveCoins(root);
        return moves ;
    }

    private static int giveCoins(Node node){
        if(node == null)
            return 0;
        int left = giveCoins(node.left);
        int right = giveCoins(node.right);
        moves +=  Math.abs(left) + Math.abs(right);
        return node.val + left + right -1;
    }

    public static void main(String ...args){
        Node root = new Node(3);
        root.left = new Node(0);
        root.right = new Node(0);

        System.out.println("----- ORIGINAL TREE ---");
        PrintUtil.printBinaryTree(root);
        System.out.println("how many moves in order to distribute equally? " + distributeCoins(root));
    }
}
