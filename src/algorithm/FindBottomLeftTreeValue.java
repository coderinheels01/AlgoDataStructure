package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    /*
     * 1. using a queue, loop add the root and it's right sub-tree first then it's left sub-tree second.
     * 2. pop the queue until it is empty. since q is first in first out, it is important that root.right is added first.
     *    so we will be left with root assigned with root.left at the end
     * 3. if the root is null then return 0
     * 4. otherwise return root.val which is the left most node of the tree.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int findBottomLeftValue(Node root) {
        if(root == null)
            return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            root = q.remove();
            if(root.right != null)
                q.add(root.right);
            if(root.left != null)
                q.add(root.left);
        }


        return root.val;
    }
    public static void main(String ...args){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        System.out.println("----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("left most node of the tree is " + findBottomLeftValue(root));


        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.left = new Node(5);
        root.right.left.left = new Node(7);

        System.out.println("----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println("left most node of the tree is " + findBottomLeftValue(root));
    }
}
