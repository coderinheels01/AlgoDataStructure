package algorithm;

public class MinHeap {
    int[] heap;
    int current;
    public MinHeap(int size){
        heap = new int[size];
        current=-1;
    }
    private int getParent(int idx){
        return (int) Math.floor( (float)( (idx -1)/2 )  );
    }

    private int getLeftChild(int idx){
        return idx * 2 +1;
    }
    private int getRightChild(int idx){
        return idx *2 +2;
    }

    public int add(int value){
        ++current;
        heap[current]= value;
        bubbleUp();
        return value;
    }

    public int remove(){
        int value =  heap[0];
        if(current < 0)
            throw new IndexOutOfBoundsException("you can't remove more from an empty heap!");
        swap(0, current);
        heap[current] = 0;
        current--;
        if(size() > 2 ){
            bubbleDown();
        }
        else if( size() == 2 && heap[0] < heap[current -1]){
            swap(0, current);
        }

        return value;
    }

    private void bubbleUp(){
        int parentIdx = getParent(current);
        int idx = current;
        while(heap[idx] < heap[parentIdx]){
            swap(idx, parentIdx);
            idx= parentIdx;
            parentIdx = getParent(idx);
        }

    }

    private void bubbleDown(){
        int parent = 0;
        int left = getLeftChild(parent);
        int right = getRightChild(parent);

        while( heap[right] < heap[parent] || heap[left]  < heap[parent]){
            int smallerChild =  (heap[right] < heap[left]) ? right: left;
            if( right > current || left > current)
                break;
            swap(parent, smallerChild);
            parent = smallerChild;
            left = getLeftChild(parent);
            right = getRightChild(parent);
        }
    }

    public int size(){
        return current+1;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
