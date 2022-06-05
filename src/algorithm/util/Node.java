package algorithm.util;

public class Node {
    int value;
    Node next;


    public Node() {};
    public Node(int value){
        this.value = value;
    }
    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public void addNext(int value){
        this.next = new Node(value);
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

}
