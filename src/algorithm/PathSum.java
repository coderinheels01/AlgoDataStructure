package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.Stack;

public class PathSum {
    /*
     * using two stacks.
     * 
     * 1. base case: check if the root is null, then return false
     * 2. push the root node to the node stack and the (sum - root.val) value into the value stack.
     * 3. while the stacks aren't empty. pop the node stack and the compliment stack.
     * 4. check if current node is the leaf node and the value of the compliment is zero then return true.
     * 5. otherwise if there is left sub-tree,
     *   a) push the left node to nodeStack.
     *   b) push the compliment value ( sum - currentNode.left.value ) into the compliment stack.
     * 6. if there is right sub-gree
     *    a) push the right node to nodeStack.
     *    b) push the compliment value ( sum - currentNode.right.value) into the compliment stack.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://www.youtube.com/watch?v=nBbYMdtZIuc&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=16
     *
     */
    public static boolean findPathSumIterative(Node root, int sum){
        if(root == null)
            return false;

        Stack<Node> nodeStack = new Stack<>();
        Stack<Integer> complimentStack = new Stack();

        nodeStack.push(root);
        complimentStack.push(sum - root.val);

        Node currentNode;
        int compliment;
        while(!nodeStack.isEmpty() && !complimentStack.isEmpty()){
            currentNode = nodeStack.pop();
            compliment = complimentStack.pop();

            if(currentNode.left == null && currentNode.right == null && compliment == 0)
                return true;

            if(currentNode.left != null){
                nodeStack.push(currentNode.left);
                complimentStack.push(compliment - currentNode.left.val);
            }
            if(currentNode.right != null){
                nodeStack.push(currentNode.right);
                complimentStack.push(compliment - currentNode.right.val);
            }

        }
        return false;
    }

    public static boolean findPathSumRecursive(Node root, int sum){
        if(root == null)
            return false;
        else if(root.left == null && root.right == null && (sum - root.val) == 0 ){
            return true;
        }else{
            return  findPathSumRecursive(root.left, sum - root.val) || findPathSumRecursive(root.right, sum - root.val);
        }
    }
    public static void main(String ...args){

        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left  = new Node(7);
        root.left.left.right  = new Node(2);
        root.right.right = new Node(4);
        root.right.left = new Node(13);
        root.right.right.right = new Node(1);

        System.out.println(" ----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        int sum = 22;
        System.out.println(" ----- METHOD 1 ( Iterative using Stack ) -----");
        System.out.println("Does the tree have path sum to the value of "+ sum +" ? " + findPathSumIterative(root, sum));
        System.out.println(" ----- METHOD 2 ( Recursive ) -----");
        System.out.println("Does the tree have path sum to the value of "+ sum +" ? " + findPathSumRecursive(root, sum));
    }
}
