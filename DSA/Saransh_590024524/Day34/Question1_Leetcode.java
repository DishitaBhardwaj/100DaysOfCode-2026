package DSA.Saransh_590024524.Day34;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        transfer();
        return outStack.pop();
    }
    
    public int peek() {
        transfer();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void transfer() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}