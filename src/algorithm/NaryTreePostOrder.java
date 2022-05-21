package algorithm;
import java.util.*;

public class NaryTreePostOrder {
    static class Node{
        public int val;
        public List<Node> children;

        public Node(int val){
            this.val = val;
        }
        public Node(int val, List<Node> children){
            this.val = val;
            this.children = children;
        }
    }


    /*
     * Recursive approach, as long as node have children,  traverse children from left to right and keep
     * calling recursive function.
     *
     * Time Complexity : O(N^2)
     * Space Complexity: O(N)
     */
    public static List<Integer> postorderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(Node root, List<Integer> result){
        if(root == null)
            return;
        if(root.children != null){
            for(Node child: root.children){
                postOrder(child, result);
            }
        }
        result.add(root.val);
    }


    /*
     * 1. add the root to stack and it's children to stack.
     * 2. pop the stack and add to LinkedList as first child, so the list won't need to be reversed.
     *
     * Time Complexity: O(N^2)
     * Space Complexity : O(N)
     *
     * https://www.youtube.com/watch?v=Ds5e1A88j7Q&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=7
     *
     */
    public static List<Integer> postOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null)
            return result;

        stack.add(root);
        while(!stack.isEmpty()){
            Node n = stack.pop();
            result.addFirst(n.val);
            if(n.children != null){
                for(Node child: n.children){
                    stack.add(child);
                }
            }
        }

        return result;

    }


    public static void main(String ...args){
        Node two = new Node (2);
        Node four = new Node ( 4);
        Node five = new Node ( 5);
        Node six = new Node ( 6);
        Node three = new Node ( 3, new ArrayList<>(Arrays.asList(five, six)));
        Node root = new Node(1, new ArrayList<>(Arrays.asList(three, two, four)));

        System.out.println(" ---------- METHOD 1 ( recursive ) ---------- ");
        System.out.println(postorderRecursive(root));

        System.out.println(" ---------- METHOD 2 ( iterative + extra data structure)---------- ");
        System.out.println(postOrderIterative(root));
    }

}
