package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.*;

public class LargestValueInEachRow {

    /*
     * Similar to level order printing
     * 1. add the root to the queue
     * 2. to mark the level, loop until queue size become zero
     * 3. keep popping the node and compare the value with the last largest number and replace
     *    if current number is greater than previous largest number then replace it
     *
     * Time Complexity : O(N)
     * Space Compelxity : O(1)
     */
    public static List<Integer> largestValues(Node root) {
        List<Integer> largest = new ArrayList<>();
        if(root == null){
            return largest;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node;
        int size;

        while(!q.isEmpty()){
            size = q.size();
            int largestPerRow = q.peek().val;
            while( size > 0){
                node = q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                if(largestPerRow < node.val){
                    largestPerRow = node.val;
                }
                size--;
            }
            largest.add(largestPerRow);
        }

        return largest;
    }

    public static List<Integer> largestValueRecursive(Node root){
        List<Integer> result = new ArrayList<>();
        largest(root, 0, result);
        return result;
    }

    public static void largest(Node node, int level, List<Integer> result){
        if(level == result.size() ){
            result.add(node.val);
        }
        else{
            result.set(level, Math.max(result.get(level), node.val));
        }
        if(node.left != null)
            largest(node.left, level+1, result);
        if(node.right != null)
            largest(node.right, level+1, result);
    }
    public static void main(String ...args){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);
        System.out.println(" ----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        List<Integer> largest = largestValues(root);
        System.out.println("----- largest values at each row are -----");
        algorithm.util.PrintUtil.printIntArrayList(largest);
        largest = largestValueRecursive(root);
        System.out.println("----- largest values at each row are (Recursive)-----");
        algorithm.util.PrintUtil.printIntArrayList(largest);
    }
}
