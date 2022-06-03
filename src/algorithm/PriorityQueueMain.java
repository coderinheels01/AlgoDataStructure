package algorithm;

public class PriorityQueueMain {
    public static  void main(String ...args){
        MyPriorityQueue<Integer> maxHeap= new MyPriorityQueue<>();
        maxHeap.add(50);
        maxHeap.add(10);
        maxHeap.add(5);
        System.out.println("heap size : " + maxHeap.size());
        System.out.println("peek " +maxHeap.peek());
        maxHeap.add(1000);
        System.out.println("peek " +maxHeap.peek());
        System.out.println("remove " +maxHeap.remove());
        System.out.println("peek " +maxHeap.peek());
        System.out.println("remove " +maxHeap.remove());
        System.out.println("peek " +maxHeap.peek());
        System.out.println("heap size : " + maxHeap.size());
        System.out.println("remove " +maxHeap.remove());
        System.out.println("peek " +maxHeap.peek());
        System.out.println("heap size : " + maxHeap.size());
        System.out.println("remove " +maxHeap.remove());
        System.out.println("peek " +maxHeap.peek());
        System.out.println("heap size : " + maxHeap.size());
        System.out.println("remove " +maxHeap.remove());
        System.out.println("peek " +maxHeap.peek());
        System.out.println("heap size : " + maxHeap.size());

    }
}
