package algorithm;

public class MinStackMain {
    public static void main(String ...args){
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(1);
        stack.push(10);
        stack.push(100);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
