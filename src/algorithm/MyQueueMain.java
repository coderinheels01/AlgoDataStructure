package algorithm;

public class MyQueueMain {

    public static void main(String ...args){
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("enque : " + q.pop());
        System.out.println("enque : " + q.peek());
        System.out.println("enque : " + q.pop());
        q.push(4);
        System.out.println("is queue empty? " + q.empty());
        System.out.println("enque : " + q.pop());
        System.out.println("enque : " + q.pop());
        System.out.println("is queue empty? " + q.empty());
    }
}
