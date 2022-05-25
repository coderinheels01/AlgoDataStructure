package algorithm.util.doubly;

public class PrintUtil {
    public static void printDoublyLinkedList(Node node){
        while(node != null){
            System.out.printf("%s," , node.val);
            node = node.next;
        }
        System.out.println();
    }
}
