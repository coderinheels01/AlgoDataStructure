package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    /*
     * using level order traversal and bfs.
     * 1. add the nodes to the queue
     * 2. get the current size of the queue at each level.
     * 3. check each node children and add them to queue until the size becomes 0.
     * 4. when the size is 1, add that node to the result list because we only want the last node at each level
     * 5. return the result array.
     *
     * Time Complexity: O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/binary-tree-right-side-view/
     *
     */
    public static List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        Node current;
        while(!q.isEmpty()){
            size = q.size();
            while(size > 0){
                current = q.remove();
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
                if(size == 1)
                    result.add(current.val);
                size--;
            }
        }
        return result;
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
        System.out.println(" ----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("----- RIGHT SIDE OF THE TREE ----- ");
        algorithm.util.PrintUtil.printIntArrayList(rightSideView(root));

    }
}
