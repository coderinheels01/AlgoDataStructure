package algorithm;

import java.util.Stack;

/*
 * implement a Queue using two stacks.
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 */
public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MyQueue(){
    }

    // push into the stack as usual
    public void push(int x){
        stack1.push(x);
    }

    //when popping, check if stack2 is empty, if yes then move everything from stack1 into stack2 then pop.
    public int pop() {
        if(stack2.isEmpty()){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
         }
        }
        return stack2.pop();
    }

    //when peeking, check if stack2 is empty, if yes then move everything form stack1 into stack2 then peek
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    //if both stack1 and stack2 are empty, then return true. otherwise false.
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
