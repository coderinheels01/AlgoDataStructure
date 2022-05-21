package algorithm;
import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeDepth {

    /*
     * recursive bottom up approach
     *
     * 1. base case, return 0 if the root is null
     * 2. traverse left sub-tree and store the depth
     * 3. traverse right sub-tree and store the depth
     * 4. return the max depth value of left or right sub-tree and add 1
     *
     *
     * Time Complexity : O(N)
     * Space Complexity : O(M) where M is the depth of the tree
     */
    public static int depthOfTreeRecursiveBottomUp(Node root){
        if(root == null)
            return 0;

        int depthLeft = depthOfTreeRecursiveBottomUp(root.left);
        int depthRight = depthOfTreeRecursiveBottomUp(root.right);

        return Math.max(depthLeft, depthRight) +1;
    }

    /*
     * recursive top down approach.
     * 1. base case, return if the root is null
     * 2. have a global scope int called max.
     * 3. update max only at root nodes.
     * 4. traverse down left and right sub-trees.
     *
     * Time Complexity - O(N)
     * Space Complexity - O(N)
     *
     * https://www.youtube.com/watch?v=MARxXuqnVGw&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=14
     */
    static int max;
    public static int depthOfTreeRecursiveTopDown(Node root){
        topDown(root, 1);
        return max;
    }
    public static void topDown(Node root, int depth){
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            max = Math.max(max, depth);
        topDown(root.left, depth +1);
        topDown(root.right, depth +1);
    }
    /*
     * Iterative approach using Stack.
     *
     * 1. create two stacks, one for storing nodes and one for storing depth int.
     * 2. push root into node stack and 1 into depth stack.
     * 3. while both node stack and depth stacks are not empty, pop both stacks
     *    a. check if node has left sub tree and right sub tree, if yes then push the left sub-tree
     *       and right sub-tree into the node stack.
     *    b. increment the depth of parent node by 1 and push into the depth stack.
     * 4. find the max value of current depth or previous max depth and assign it to max depth variable.
     * 5. return the max depth
     *
     * Time Complexity : O(N)
     * Space Compleity : O(N)
     *
     */
    public static int depthOfTreeIterativeUsingStack(Node root){
        Stack<Node> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        Node node;
        int maxDepth = 0;
        int depth =0;

        nodeStack.push(root);
        depthStack.push(1);

        while(!nodeStack.isEmpty() && !depthStack.isEmpty()){
            node = nodeStack.pop();
            depth= depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if( node != null && node.right !=null){
                nodeStack.push(node.right);
                depthStack.push(depth+1);
            }
            if( node != null && node.left !=null){
                nodeStack.push(node.left);
                depthStack.push(depth+1);
            }
        }


        return maxDepth;
    }
    /*
     * Iterative approach using Queue.
     *
     * 1. create a queue.
     * 2. add root into the queue
     * 3. while queue is not empty
     *    a. get the size of the queue.
     *    b. while size not zero, deque the queue and keep pushing left and right node into the queue.
     * 4. outside of the nested loop, increment the depth
     * 5. return the depth
     *
     * Time Complexity : O(N^2)
     * Space Compleity : O(N)
     *
     */
    public static int depthOfTreeIterativeUsingQueue(Node root){
        Queue<Node> q =  new LinkedList<>();
        int depth = 0;
        Node node;
        int size;

        q.add(root);
        while(!q.isEmpty()){
            size = q.size();
            while(size > 0){
                node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                size--;
            }
            depth++;
        }

        return depth;
    };

    public static void main(String ...args){
        /*
         *        1
         *     2     3
         *   4   5  6 7
         *  8 9
         * In order : [ 4, 2, 5, 1, 6, 3 ]
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        System.out.println(" ----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);

        System.out.println(" ----- METHOD 1 ( RECURSION Bottom Up  )----- ");
        System.out.println(depthOfTreeRecursiveBottomUp(root));

        System.out.println(" ----- METHOD 1 ( RECURSION Top Down  )----- ");
        System.out.println(depthOfTreeRecursiveTopDown(root));

        System.out.println(" ----- METHOD 2 ( Iterative using Stack  )----- ");
        System.out.println(depthOfTreeIterativeUsingStack(root));

        System.out.println(" ----- METHOD 3 ( Iterative using Queue  )----- ");
        System.out.println(depthOfTreeIterativeUsingQueue(root));
    }

}
