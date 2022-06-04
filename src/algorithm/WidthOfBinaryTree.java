package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBinaryTree {

    /*
     * 1. index at each node. formula :
     *       leftIndex = ((i-1) * 2) +1;
     *       rightIndex = ((i-1) *2 ) + 2;
     *   these indexes will insure that at each level the indexes start from 1 to n.
     * 2. push the first node to queue along with index as a map structure.
     * 3. get the size of current queue, while the size is greater than 0 pop the queue.
     *    1. pop and check left and right nodes. If they exist, then put into a map with node as key and index as value.
     *    2. try to save left most index and right most index by checking current size.
     * 4. once out of the loop, calculate current max value and compare with previous max value then save.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/
     * https://www.youtube.com/watch?v=ZbybYvcVLks
     */
    public static int widthOfBinaryTree(Node root) {
        Queue<Map<Node, Integer>> q  = new LinkedList<>();
        q.add(makeMap(root, 1));
        int leftIndex = 0;
        int rightIndex = 0;
        int parentIndex = 0;
        int width =0;
        int first = 0;
        int last = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size; i++){
                Map<Node, Integer> cord = q.remove();
                Node node = cord.keySet().stream().findFirst().get();
                parentIndex = cord.get(node);
                if(i == 0) {
                    first = parentIndex;
                };
                if(i == size-1 ){
                    last = parentIndex;
                };
                if(node.left != null){
                    leftIndex = ((parentIndex - 1 )  * 2) + 1;
                    q.add(makeMap(node.left, leftIndex));
                }
                if(node.right != null){
                    rightIndex = ((parentIndex - 1 )  * 2) + 2;
                    q.add(makeMap(node.right, rightIndex));
                }
            }

            System.out.println("first "  + first + " last " + last);
            width = Math.max(width, (last - first) +1);
        }


        return  width ;
    };

    private static Map<Node, Integer> makeMap(Node node, int index){
        return new HashMap<>(){{put(node, index);}};
    }

    public static void main(String ...args){

        /*
         *      1
         *    3    2
         *  5   3   9
         *
         *
         */
        Node  root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(9);
        root.left.left = new Node(5);
        root.left.right = new Node(3);

        System.out.println("----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        System.out.println("width of a binary tree " + widthOfBinaryTree(root));

        root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);

        System.out.println("----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        System.out.println("width of a binary tree " + widthOfBinaryTree(root));

        root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(9);
        root.right.right.left = new Node(7);
        root.left.left = new Node(5);
        root.left.left.left = new Node(6);

        System.out.println("----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        System.out.println("width of a binary tree " + widthOfBinaryTree(root));
    }
}
