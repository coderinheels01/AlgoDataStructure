package algorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T> {
    private List<Integer> heap;
    private Comparator<Integer> defaultComparator;

    public PriorityQueue(){
        heap = new ArrayList<>();
        defaultComparator = (a, b) ->  (a > b) ?  0 : 1;
    };

    public PriorityQueue(Comparator<Integer> comparator){
        heap = new ArrayList<>();
        defaultComparator = comparator;
    }
    private int parent(int index){
        return (int) Math.floor( (float) (index  -1 ) /2);
    }
    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }
    private void swap(int indexOne, int indexTwo){
        int temp = heap.get(indexOne);
        heap.set(indexOne, heap.get(indexTwo));
        heap.set(indexTwo, temp);
    }


    private boolean compare(int indexOne, int indexTwo){
        int maxIndex =  heap.size()-1;
        return (indexOne <= maxIndex ) && (indexTwo <=maxIndex ) && this.defaultComparator.compare(heap.get(indexOne), heap.get(indexTwo)) == 1;
    }
    private void bubbleUp(){
        int childIndex = heap.size()-1;
        int parentIndex = parent(childIndex);
        while(parentIndex >=0 && compare(parentIndex, childIndex)){
            swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = parent(childIndex);
        }
    }

    private void bubbleDown(){
        int parentIndex = 0;
        int leftChildIndex = leftChild(parentIndex);
        int rightChildIndex = rightChild(parentIndex);

        while(compare(parentIndex, leftChildIndex) || compare(parentIndex, rightChildIndex)){
            int greaterThanChildIndex = compare(leftChildIndex, rightChildIndex) ? rightChildIndex : leftChildIndex;
            swap(parentIndex, greaterThanChildIndex );
            parentIndex  = greaterThanChildIndex;
            leftChildIndex = leftChild(parentIndex);
            rightChildIndex = rightChild(parentIndex);
        }
    }

    public int size(){
        return heap.size();
    }
    public boolean isEmpty(){
        return heap.size() == 0;
    }
    public Integer peek(){
        return heap.size() > 1 ? heap.get(0) : null;
    }

    public int add(Integer value){
        heap.add(value);
        bubbleUp();
        return heap.size();
    }

    public Integer remove(){
        int lastChildIndex = heap.size()-1;
        Integer removedValue = heap.size() > 0?  heap.get(0) : null;
        if(lastChildIndex > 0){
            swap(0, lastChildIndex);
            heap.remove(heap.get(lastChildIndex));
            bubbleDown();
        }
        else if( heap.size() == 1){
            heap.remove(0);
        }
        return removedValue;
    }
}
