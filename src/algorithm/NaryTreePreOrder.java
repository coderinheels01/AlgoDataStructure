package algorithm;
import java.util.*;

public class NaryTreePreOrder {
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
     * Recursive approach, add root to the result. As long as node have children,  traverse children from left to right and keep
     * calling recursive function.
     *
     * Time Complexity : O(N^2)
     * Space Complexity: O(N)
     */
    public static List<Integer> preorderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(Node root, List<Integer> result){
        if(root == null)
            return;
        result.add(root.val);
        if(root.children != null){
            for(Node child: root.children){
                preorder(child, result);
            }
        }
    }


    /*
     * similar to post order approach the only extra step is to reverse the children nodes.
     *
     * 1. push the root to the stack
     * 2. pop the stack and reverse it's children
     * 4. add the popped node value to the result list
     * 3. push the reversed children into the stack
     *
     * Time Complexity - O(N^2)
     * Space Complexity - O(N)
     */
    public static List<Integer> preorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null)
            return result;

        stack.push(root);
        while(!stack.isEmpty()){
            Node n = stack.pop();
            result.add(n.val);
           if(n.children != null){
               Collections.reverse(n.children);
               for(Node child: n.children){
                   stack.push(child);
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
        System.out.println(preorderRecursive(root));

        System.out.println(" ---------- METHOD 2 ( iterative ) ---------- ");
        System.out.println(preorderIterative(root));

    }

}
