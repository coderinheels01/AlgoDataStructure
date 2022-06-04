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
    public static int widthOfBinaryTreeUsingQueue(Node root) {
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

            width = Math.max(width, (last - first) +1);
        }


        return  width ;
    };

    private static Map<Node, Integer> makeMap(Node node, int index){
        return new HashMap<>(){{put(node, index);}};
    }


    /*
     * 1. create a global hashmap to store left most node index at each level. ( key = current depth, value = left most index )
     * 2. create a global maxValue so a maxValue at each level can be stored.
     * 3. call a recursive function with current node, depth and index.
     * 4. computeIfAbsent will take care of left most node index at the current level.
     * 5. recursively call left node first then right node.
     *
     * Time Complexity: O(N)
     * Space Complexity : O(N)
     */
    static Map<Integer, Integer>  leftMostNodesIndex;
    static int   maxNumber;
    public static int widthOfBinaryTreeUsingHashMap(Node root) {
        maxNumber = 0;
        leftMostNodesIndex = new HashMap<>();
        calculateMaxWidth(root, 0, 1 );
        return maxNumber;
    };

    private static void calculateMaxWidth(Node node, int depth, int currentIndex){
        if(node == null)
            return;

        leftMostNodesIndex.computeIfAbsent(depth, pos -> currentIndex);
        maxNumber = Math.max(maxNumber, (currentIndex - leftMostNodesIndex.get(depth))  +1);

        calculateMaxWidth(node.left, depth + 1, (currentIndex * 2) +1);
        calculateMaxWidth(node.right, depth + 1, (currentIndex * 2) + 2);

    }



    public static void main(String ...args){

        /*
         * indexes are in braces.
         *
         * actual tree:
         *          1 (1)
         *    3(2)          2(3)
         *  5(4)   3(5) null(6)  9(7)
         *
         * max width = ( right most index - left most index ) + 1 = ( 7 - 4 ) +1 = 4
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
        System.out.println("(Queue) width of a binary tree " + widthOfBinaryTreeUsingQueue(root));
        System.out.println("(HashMap) width of a binary tree " + widthOfBinaryTreeUsingHashMap(root));


        /*
         *          1 (1)
         *       3(2)   2(3)
         *     5(4)
         *
         * max width at level 1 = 1
         * max width at level 2 = 2
         * max width at level 3 = 1
         *
         * hence max width is 2.
         */
        root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);

        System.out.println("----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Queue) width of a binary tree " + widthOfBinaryTreeUsingQueue(root));
        System.out.println("(HashMap) width of a binary tree " + widthOfBinaryTreeUsingHashMap(root));


        /*
         *
         *                           1(1)
         *              3(2)                             2(3)
         *       5(4)         null(5)            null(6)         9(7)
         *    6(8) null(9) null(10) null(11) null(12) null(13)  7(14)
         *
         *  max width at level 1 : 1
         *  max width at level 2 : 2
         *  max width at level 3 : 4
         *  max width at level 4 : 7
         *
         * so max width is 7
         *
         */

        root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(9);
        root.right.right.left = new Node(7);
        root.left.left = new Node(5);
        root.left.left.left = new Node(6);

        System.out.println("----- ORIGINAL TREE -----");
        PrintUtil.printBinaryTree(root);
        System.out.println("(Queue) width of a binary tree " + widthOfBinaryTreeUsingQueue(root));
        System.out.println("(HashMap) width of a binary tree " + widthOfBinaryTreeUsingHashMap(root));
    }
}
