package algorithm;

public class MinStack{
    private int size;
    private int current;
    private int[] stack;
    private int[] minStack;
    int min;

    public MinStack() {
        size= 10;
        current =0;
        stack = new int[size];
        minStack = new int[size];
    }

    public void push(int val) {
        if(current == size-1){
            size = stack.length *2;
            int[] temp = new int[size];
            int[] temp2 = new int[size];
            for(int i=0; i< size/2; i++){
                temp[i] = stack[i];
                temp2[i] = minStack[i];
            }
            stack= temp;
            minStack= temp2;
        }

        if(current <= 0){
            minStack[current] = val;
        }
        else{
            minStack[current] = Math.min(val,minStack[current-1]);
        }
        stack[current] = val;
        current++;
    }

    public void pop() {
        if(current <=0 )
            throw new StackOverflowError();
        stack[current] =0;
        minStack[current] = Integer.MAX_VALUE;
        current--;
    }

    public int top() {
        return stack[current];
    }

    public int getMin() {
        return minStack[current-1];
    }
}
