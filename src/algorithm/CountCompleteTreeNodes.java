package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

/*
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {

    public static int countNodes(Node root) {
        int count = 0;
        if(root == null)
            return count;

        int height = countTreeHeight(root); // height of the tree
        int upperCount = (int) Math.pow(2, height) - 1; // ( 2^h -1 ) is the formula to get node count above lowest level
        int left = 0, right = upperCount; // index of the lowest level nodes 0 to 7
        int idxToFind;

        // binary search of right most value that is at the the lowest level child nodes
        while(left < right){
            idxToFind = (int) Math.ceil(((float) (left+right) /2));

            //if the node exists move to the mid node between left and right
            if(nodeExists(idxToFind, height, root)) {
                left = idxToFind;
            } else {
                //if the node does not exist move the right node by 1
                right = idxToFind - 1;
            }

        }

        return upperCount + left +1;
    }
    /*
     * this method is to traverse down the tree
     */
    private static boolean nodeExists(int idxToFind, int height, Node node ){
        int left = 0, right = (int) Math.pow(2, height) - 1, count = 0; // this gives index of the last row 0 to 7

        //we step 4 levels down
        while(count < height) {
            // this will decide middle node of all the leaf nodes that current node has access to.
            int midOfNode = (int) Math.ceil((float) (left + right) / 2);

            // decide should I go to left sub-tree or right sub-tree
            // if the index looking for is greater than current mid node then move to the right and narrow down the
            // left index since we aren't interested in index less than midNode index.
            if(idxToFind >= midOfNode) {
                node = node.right;
                left = midOfNode;
            } else {
                node = node.left;
                right = midOfNode - 1;
            }
            count++;
        }

        return node != null;
    }

    // get the height of the node.  Note: level 1 height being 0, level 4 height being 3.
    // Time Complexity : O(H)
    private static int countTreeHeight(Node node){
       int height =0;

       while(node.left != null){
           height++;
           node =node.left;
       }

       return height;
    }
    /*
     *          1
     *      2           3
     *   4    5      6    7
     *  8 9 10 11  12 13
     *
     *
     * 1. check if the left sub-tree of the right sub-tree height is h-1 where h is whole tree height.
     *    a) if yes? then the left sub-tree is the complete binary tree. hence  full binary tree node count = ( 2^h ) -1  plus root 1.
     *       so the -1 cancel each other out so formula is 2^h.
     *    b) if no. then the right sub-tree is the complete binary tree with h-2. hence full binary tree node count = ( 2 ^ h-1 ) -1 plus root 1.
     *
     *   (1 << h) = 2 ^ h-1
     *   (2 << h) = 2 ^ h
     * Since I halve the tree in every recursive step, I have O(log(n)) steps. Finding a height costs O(log(n)). So overall O(log(n)^2).
     */
    static int height(Node root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public static int countNodes2(Node root) {
        int nodes = 0, h = height(root);
        while (root != null) {

            // if the height of the right sub-tree is h-1 ( h = whole tree height), then the last node of the last row is in
            // the right sub-tree. so left sub tree nodes = (2 ^ h) -1  + root node = 1 so formula = ( 2^h ). Now we are done with
            // the left sub-tree, so we go to the right sub-tre node = node.right.
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                // if the right sub-tree length is not h-1. Then the last node of the last tree row is in the left sub-tree, so the right sub-tree
                // is a full sub-tree of ( 2^h-1 ) -1, but we add the root node so it is 2^h-1. now we are done with the right sub tree. so we move on
                // to the left sub-tree
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    public static int countNodes3(Node root) {
        if(root == null)
            return 0;
        int leftHeight = countLeftTreeHeight(root);
        int rightHeight = countRightTreeHeight(root);
        if(leftHeight == rightHeight)
            return  (2 << leftHeight) -1;

        return countNodes3(root.left) + countNodes3(root.right) +1;
    };

    private static int countLeftTreeHeight(Node node){
        int height =0;

        while(node.left != null){
            height++;
            node =node.left;
        }

        return height;
    }

    private static int countRightTreeHeight(Node node){
        int height =0;

        while(node.right != null){
            height++;
            node =node.right;
        }

        return height;
    }

    public static void main(String ...args){
        /*
         *          1
         *      2           3
         *   4    5      6    7
         *  8 9 10 11  12 13
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        countNodes2(root);
        countNodes3(root);
        System.out.println(" ----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);
        System.out.println(" ----- METHOD 1 ----- ");
        System.out.println("total node is :  " + countNodes(root));
        System.out.println(" ----- METHOD 2 ----- ");
        System.out.println("total node is :  " + countNodes2(root));
        System.out.println(" ----- METHOD 3 ----- ");
        System.out.println("total node is :  " + countNodes3(root));

        int h =4;

        int temp1 = 1 << h;
        int temp2 = 2 << h;
        System.out.println(" 1 << h : " + temp1);
        System.out.println(" 2 << h : " + temp2);
    }
}
