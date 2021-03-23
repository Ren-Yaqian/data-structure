package 力扣155最小栈;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> normal = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        normal.push(val);
        if(val<=min.peek()){
            min.push(val);
        }else{

        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }


    public void push1(int val) {
        normal.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }

    public void pop1() {
        normal.pop();
        min.pop();
    }

    public int top1() {
        return normal.peek();
    }

    public int getMin1() {
        return min.peek();
    }
}
