package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class CompletenessOfABinaryTree {
    /*
     * check if the binary tree is complete. ( a complete binary tree is a tree with full leave nodes or a tree with only
     * last node missing.
     *
     * 1. add the root to q.
     * 2. loop until q is empty.
     * 3. if the root is null then set the foundNOde flag to true.
     * 4. next time we are in the while loop and the node is not null then we have a non-complete binary tree.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/check-completeness-of-a-binary-tree/submissions/
     *
     */
    public static boolean isCompleteTree(Node root){
        boolean foundNull = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            root = q.remove();
            if(root == null){
                foundNull = true;
            }
            else{
                if(foundNull)
                    return false;
                else{
                    q.add(root.left);
                    q.add(root.right);
                }
            }

        }
        return true;
    };

    public static boolean isCompleteTreeAlternative(Node root) {
        int h = getHeight(root);
        int left = 0;
        int right =(1 << h) -1;

        while(left < right){
            int mid = (int) Math.ceil(((float) (left+right) /2));
            if(nodeExists(root, h, mid)){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    };

    private static boolean nodeExists(Node node, int h, int indexToFind){
        int left = 0; int right = (1 << h ) -1;
        int count =0;
        while(count < h){
            int mid = (int) Math.ceil(((float) (left+right) /2));
            if( indexToFind >= mid){
                left = mid;
                node = node.right;
            }
            else{
                right--;
                node = node.left;
            }
            count++;
        }
        return node != null;
    }

    private static int getHeight(Node node){
        int count = -1;
        while(node != null){
            count++;
            node = node.left;
        }
        return count;
    }

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

        System.out.println("----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("is the tree complete? " + isCompleteTree(root));
        isCompleteTreeAlternative(root);

        /*
         *        1
         *     2     3
         *   4   5  6 7
         *  8 9        10
         */
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(10);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        System.out.println("----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("is the tree complete? " + isCompleteTree(root));
        isCompleteTreeAlternative(root);
    }
}
