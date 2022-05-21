package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {
    /*
     * 1. if the root is null, return true.
     * 2. if teh root is the only node then return true.
     * 3. otherwise, call value match function on the left sub tree and right sub-tree.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/univalued-binary-tree/
     * https://www.youtube.com/watch?v=BkUEFJZpZRw&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=39
     * 
     */
    public static boolean isUnivalTreeRecursive(Node root) {
        if(root == null || root.left == null && root.right == null)
            return true;

        return valueMatch(root.left, root.val) && valueMatch(root.right, root.val);
    }

    private static boolean valueMatch(Node node, int x){
        if(node == null)
            return true;
        return node.val == x && valueMatch(node.left, x) && valueMatch(node.right, x);
    }

    /*
     * using queue,
     * 1. get the root.value and store it in x.
     * 2. push the root into queue and keep checking each node if the values are equal to x
     *     if not return false.
     * 3. at the end return true
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static boolean isUnivalTreeIterative(Node root) {
        if(root == null || root.left == null && root.right == null)
            return true;

        int x = root.val;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node;
        while(!q.isEmpty()){
            node = q.remove();
            if(node.val != x)
                return false;
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        return true;
    }

    public static void main(String ...args){
        Node root = new Node(1);
        root.left = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right  = new Node(1);
        root.right.right  = new Node(1);
        System.out.println("----- ORIGINAL TREE ----- " );
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive)Is the tree uni value tree? "+ isUnivalTreeRecursive(root) );
        System.out.println("(Iterative)Is the tree uni value tree? "+ isUnivalTreeIterative(root) );

        root = new Node(2);
        root.left = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(2);
        root.right  = new Node(2);
        System.out.println("----- ORIGINAL TREE ----- " );
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive)Is the tree uni value tree? "+ isUnivalTreeRecursive(root) );
        System.out.println("(Iterative)Is the tree uni value tree? "+ isUnivalTreeIterative(root) );


        root = new Node(1);
        root.right = new Node(2);
        System.out.println("----- ORIGINAL TREE ----- " );
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive)Is the tree uni value tree? "+ isUnivalTreeRecursive(root) );
        System.out.println("(Iterative)Is the tree uni value tree? "+ isUnivalTreeIterative(root) );


        root = new Node(2);
        root.left = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right  = new Node(2);
        System.out.println("----- ORIGINAL TREE ----- " );
        PrintUtil.printBinaryTree(root);
        System.out.println("(Recursive)Is the tree uni value tree? "+ isUnivalTreeRecursive(root) );
        System.out.println("(Iterative)Is the tree uni value tree? "+ isUnivalTreeIterative(root) );

    }
}
