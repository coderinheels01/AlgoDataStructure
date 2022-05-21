package algorithm;

import algorithm.util.binarytree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {

    public static List<Integer> inOrderRecursive(Node root){
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    /*
     * recursive approach
     * 1. base case, return when root is null
     * 2. keep calling recursive function on its left node.
     * 3. then add the value to the result
     * 4. keep calling recursive function on it's right node.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static void inOrderRecursive(Node root, List<Integer> result){
        if(root == null)
            return;
        inOrderRecursive(root.left, result);
        result.add(root.val);
        inOrderRecursive(root.right, result);

    }
    /*
     * Iterative approach.
     * 1. if current node is not null push into stack and keep traversing to left.
     * 2. if current node is null, pop the stack, add the value to the result list and traverse to right.
     * 3. break out of the loop when current node becomes null or stack is empty.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://www.youtube.com/watch?v=nzmtCFNae9k
     *
     */
    public static List<Integer> inOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Node current =  root;
        while(current!= null || !stack.isEmpty()){
          if(current != null){
              stack.push(current);
              current = current.left;
          }
          else{
              Node n = stack.pop();
              result.add(n.val);
              current = n.right;
          }
        }
        return result;
    }
    public static void main(String ...args){

        /*
         *        1
         *     2     3
         *   4   5  6
         *
         * In order : [ 4, 2, 5, 1, 6, 3 ]
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);

        System.out.println(" ----- METHOD 1 ----- ( recursive )");
        System.out.println(inOrderRecursive(root));

        System.out.println(" ----- METHOD 2 ----- ( iterative )");
        System.out.println(inOrderIterative(root));
    }
}
