package algorithm;

import algorithm.util.binarytree.Node;
import algorithm.util.binarytree.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricBinaryTree {
    /*
     * https://www.youtube.com/watch?v=-5E5Jt_HKLc&t=24s
     *
     * 1. if the left and right sub trees are both null then return true
     * 2. if only one of the sub trees are null then return false
     * 3. otherwise, check the value of left and right subtree and recursively call left the function with t1.left, t2.right and t1.right t2.left.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static boolean symmetricRecursive(Node root){
        return isMirror(root, root);
    }

    private static boolean isMirror(Node t1, Node t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        return t1.val == t2.val && isMirror(t1.left , t2.right) && isMirror(t1.right , t2.left);
    }

/*
 * 1. base case, if the root is null, then the tree is symmetric
 * 2. add the left and right nodes to the queue.
 * 3. if the left and right nodes are null then continue.
 * 4. otherwise check if the left is null, or the right is null, then return false.
 * 5. if the values aren't the same then return false too.
 * 6. otherwise, add the left node of the left and the right node of teh right to the queue and the right node of the
 *    left and the left node of the right into queue.
 *
 * https://www.youtube.com/watch?v=7yXBnlHZ0tY
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
  public static boolean symmetricIterative(Node root){
      Queue<Node> q  = new LinkedList<>();
      if(root == null)
          return true;

      q.add(root.left);
      q.add(root.right);
      Node left;
      Node right;

      while(!q.isEmpty()){
          left = q.remove();
          right = q.remove();

          if(left == null && right == null)
              continue;
          if(left == null || right == null || left.val != right.val)
              return false;

          q.add(left.left);
          q.add(right.right);
          q.add(left.right);
          q.add(right.left);
      }
      return true;
  }

    public static void main(String ...args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(" ----- ORIGINAL TREE ----- ");
        PrintUtil.printBinaryTree(root);

        System.out.println(" -----  METHOD 1 ( Recursive ) ----- ");
        System.out.println("is the tree symmetric? " + symmetricRecursive(root));

        System.out.println(" -----  METHOD 2 ( Iterative ) ----- ");
        System.out.println("is the tree symmetric? " + symmetricIterative(root));
    }
}
