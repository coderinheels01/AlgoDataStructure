package algorithm.util;

public class SumResult {
    Node head;
    Node tail;


    public SumResult(){
        this.head = new Node();
        this.tail = head;
    }

    public void append(int value){
        Node node = new Node(value);
        this.tail.next = node;
        this.tail = node;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
