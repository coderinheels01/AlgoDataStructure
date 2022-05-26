package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node current;
        int size=0;

        List<List<Integer>> treeList = new ArrayList<>();
        List<Integer> subLevel;
        while(!q.isEmpty()){
            size = q.size();
            subLevel = new ArrayList<>();
            while(size > 0){
                current = q.remove();
                q.add(current.left);
                q.add(current.right);
                subLevel.add(current.val);
                size--;
            }
            treeList.add(subLevel);
        }

        return treeList;
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
    }
}
