package algorithm.util;

import algorithm.MinHeap;

public class MinHeapMain {

    public static void main(String ...args){
        MinHeap heap = new MinHeap(10);
        heap.add(100);
        heap.add(70);
        heap.add(50);
        heap.add(40);
        heap.add(200);
        heap.add(10);
        System.out.println("heap size " + heap.size());

        int minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());

        minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());

        minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());

        heap.add(5);

        minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());

        minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());

        minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());

        minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());

        minVal = heap.remove();
        System.out.println("remove min value from heap " + minVal);
        System.out.println("heap size " + heap.size());
    }
}
