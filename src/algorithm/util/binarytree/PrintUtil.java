package algorithm.util.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintUtil {

    //https://www.youtube.com/watch?v=7uG0gLDbhsI
    public static void printBinaryTree(Node node){
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(node);
        while(!q1.isEmpty()){
            emptyQ( q1, q2);
            emptyQ(q2, q1);
        }
    }

    private static void emptyQ(Queue<Node> q1, Queue<Node> q2) {
        while(!q1.isEmpty()){
            Node n = q1.remove();
            if(n.left != null)
                q2.add(n.left);
            if(n.right != null)
                q2.add(n.right);
            System.out.print(n.val + " ");
            if(q1.isEmpty()){
                System.out.println();
            }
        }
    }
}
