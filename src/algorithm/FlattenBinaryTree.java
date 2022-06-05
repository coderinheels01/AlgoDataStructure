package algorithm;
import algorithm.util.binarytree.Node;

public class FlattenBinaryTree {

    public static void flatten(Node node){
        Node left = dfs(node, null);
        while(left != null){
            System.out.print(left.val + " , ");
            left = left.right;
        }
    }
    /*
     *          1
     *        2     5
     *    3     4     6
     *
     * reverse post-order traversal. right, left, node.
     *
     * 1. keep traversing right. ( be sure to set prev to whatever is returned so it can be passed down to the next recursive call)
     * 2. keep traversing left. ( be sure to set prev to whatever is returned so it can be passed down to the next recursive call )
     * 3. when it gets to the last node,
     *    a) set previous node to the right of the node.  node.right = prev (note: prev is null in the first call. it was passed from
     *       it's parent function)
     *    b) set null to left of the node. node.left = null
     *    c) set node to previous. prev = node;
     * 4. return previous node.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     */
    private static Node dfs(Node node, Node prev){
        if(node == null)
            return prev;

        prev = dfs(node.right, prev);
        prev = dfs(node.left, prev);

        node.right = prev;
        node.left = null;
        prev = node;

        return prev;
    }

    public static void main(String ...args){

        /*
         *          1
         *        2     5
         *    3     4     6
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);
    }
}
