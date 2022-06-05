package algorithm;
import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.Stack;

public class FlattenBinaryTree {

    public static void flattenRecursive(Node node){
        Node left = dfs(node, null);
        while(left != null){
            System.out.print(left.val + " , ");
            left = left.right;
        }
    }
    /*
     *          1
     *        2     5
     *    3     4     6
     *
     * reverse post-order traversal. right, left, node.
     *
     * 1. keep traversing right. ( be sure to set prev to whatever is returned so it can be passed down to the next recursive call)
     * 2. keep traversing left. ( be sure to set prev to whatever is returned so it can be passed down to the next recursive call )
     * 3. when it gets to the last node,
     *    a) set previous node to the right of the node.  node.right = prev (note: prev is null in the first call. it was passed from
     *       it's parent function)
     *    b) set null to left of the node. node.left = null
     *    c) set node to previous. prev = node;
     * 4. return previous node.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
     * https://www.youtube.com/watch?v=sWf7k1x9XR4
     *
     */
    private static Node dfs(Node node, Node prev){
        if(node == null)
            return prev;

        prev = dfs(node.right, prev);
        prev = dfs(node.left, prev);

        node.right = prev;
        node.left = null;
        prev = node;

        return prev;
    }

    /*
     *  1. push right node into stack
     *  2. push left node into stack
     *  3. if stack is not empty, link the current node's right to top of of the stack. since we pushed right
     *     nodes first, and left node last. so the left node will be pointing to the right node.
     *
     * Time Complexity : O(N)
     * Space Complexity: O(N)
     */
    public static void flattenIterative(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node n = stack.pop();

            if(n.right != null){
                stack.push(n.right);
            }

            if(n.left != null){
                stack.push(n.left);
            }
            if(!stack.isEmpty()){
                n.right = stack.peek();
                n.left = null;
            }
        }

        while(node != null){
            System.out.print(node.val + " , ");
            node = node.right;
        }
    }

    public static void main(String ...args){

        // *          1
        // *        2     5
        // *    3     4     6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        System.out.println("----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        System.out.println("----- RECURSIVE SOLUTION -----");
        flattenRecursive(root);

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        System.out.println("\n----- ITERATIVE SOLUTION -----");
        flattenIterative(root);
    }
}
