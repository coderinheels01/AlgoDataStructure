package algorithm;
import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;
import java.util.Stack;

public class MergeTwoBinaryTree {
    /*
     * https://leetcode.com/problems/merge-two-binary-trees/
     *
     * 1. if tree 1 is null, return tree2
     * 2. if tree 2 is null, return tree1
     * 3. otherwise add both tree1 and tree2 values
     * 4. recursively call merge method on both tree1.left and tree2.left and attach it to tree1.left.
     * 5. recursively call merge method on both tree1.right and tree2.right and attach it to tree1.right
     * 6. return tree1
     *
     * https://www.youtube.com/watch?v=_LJO5nBKC1A&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=10
     */
    public static Node mergeRecursive(Node tree1, Node tree2){
        if(tree1 == null)
            return tree2;
        if(tree2 == null)
            return tree1;

        tree1.val += tree2.val;
        tree1.left = mergeRecursive(tree1.left, tree2.left);
        tree1.right = mergeRecursive(tree1.right, tree2.right);
        return tree1;
    }

    /*
     * Using stack,
     *
     * 1. base case: if tree1 is null return tree2 or if tree2 is null, return tree1
     * 2. push the left node and right node into a stack if they are not null.
     * 3. as long as the stack isn't empty, pop the stack and sum the values.
     * 4. check if the left subtree left  is null then, assign right subtree's left to the left subtree's left
     * 5. check if both the left subtree's left and right subtree's left are not null, then push into stack
     * 6. check if the left subtree right is null then, assign right subtree's right to the left subtree's right
     * 7. check if both the left subtree's right and right subtree's right are not null, then push into stack
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static Node mergeIterative(Node tree1, Node tree2){
        Stack<Node[]> stack = new Stack<>();
        stack.push(new Node[]{tree1, tree2});
        Node[] nodes;

        if(tree2 == null){
            return tree1;
        }
        if(tree1 == null){
            return tree2;
        }


        while(!stack.isEmpty()){
            nodes = stack.pop();
            nodes[0].val += nodes[1].val;

            if(nodes[0].left == null){
                nodes[0].left = nodes[1].left;
            }
            else if(nodes[1].left != null){
                stack.push(new Node[]{nodes[0].left, nodes[1].left});
            }

            if(nodes[0].right == null){
                nodes[0].right = nodes[1].right;
            }
            else if(nodes[1].right != null){
                stack.push(new Node[]{nodes[0].right, nodes[1].right});
            }
        }

        return tree1;
    }

    public static void main(String ...args){

        /*
         *        1
         *     3     2
         *   5
         *
         */
        Node tree1 = new Node(1);
        tree1.left = new Node(3);
        tree1.right = new Node(2);
        tree1.left.left = new Node(5);
        System.out.println(" ----- TREE 1 ----- ");
        PrintUtil.printBinaryTree(tree1);
        /*
         *        2
         *     1     3
         *       4     7
         *
         */
        Node tree2 = new Node(2);
        tree2.left = new Node(1);
        tree2.left.right = new Node(4);
        tree2.right = new Node(3);
        tree2.right.right = new Node(7);
        System.out.println(" ----- TREE 2 ----- ");
        PrintUtil.printBinaryTree(tree2);


        System.out.println(" ----- METHOD 1 ----- ( recursive )");
        PrintUtil.printBinaryTree(mergeRecursive(tree1, tree2));



        /*
         *        1
         *     3     2
         *   5
         *
         */
        tree1 = new Node(1);
        tree1.left = new Node(3);
        tree1.right = new Node(2);
        tree1.left.left = new Node(5);
        /*
         *        2
         *     1     3
         *       4     7
         *
         */
        tree2 = new Node(2);
        tree2.left = new Node(1);
        tree2.left.right = new Node(4);
        tree2.right = new Node(3);
        tree2.right.right = new Node(7);

        System.out.println(" ----- METHOD 2 ----- ( iterative )");
        PrintUtil.printBinaryTree(mergeIterative(tree1, tree2));
    }

}
