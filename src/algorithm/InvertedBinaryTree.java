package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.Stack;

public class InvertedBinaryTree {


    /*
     *  1. base case: return if the root is null;
     *  2. store the tree.left to temp
     *  3. swap tree.left and tree.right
     *  4. walk down the left subtree and right subtree by calling the recursive function.
     *
     * Time Complexity :  O(N)
     * Space Complexity : O(1)
     *
     * https://www.youtube.com/watch?v=OnSn2XEQ4MY
     *
     */
    public static void invertRecursive(Node tree){
        if(tree == null){
            return;
        }
        Node temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invertRecursive(tree.left);
        invertRecursive(tree.right);
    }

    /*
     * Using stack.
     *
     * 1. push the root node into stack
     * 2. pop the node and swap left and right subtrees.
     * 3. if the left and right sub tree aren't null, then push them into stack
     *
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     */
    public static void invertIterative(Node tree){
        Stack<Node> stack = new Stack<>();
        Node n;
        Node temp;
        if(tree == null)
            return;

        stack.push(tree);

        while(!stack.isEmpty()){
            n = stack.pop();
            temp = n.left;
            n.left = n.right;
            n.right = temp;

            if(n.left != null){
                stack.push(n.left);
            }
            if(n.right != null){
                stack.push(n.right);
            }
        }
    }

    /*
     *        1
     *     2     3
     *   4   5  6  7
     */
    public static void main(String ...args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(" ----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);

        System.out.println(" ----- INVERTED TREE ( recursive ) ----- ");
        invertRecursive(root);
        PrintUtil.printBinaryTree(root);

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(" ----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);

        System.out.println(" ----- INVERTED TREE ( iterative ) ----- ");
        invertIterative(root);
        PrintUtil.printBinaryTree(root);

    }
}
