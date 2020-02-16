package ctci.stackAndQueue;

import java.util.Stack;

/* @author Shambhuraj created on 2/16/2020*/
/*
Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMin extends Stack<Integer> {

    Stack<java.lang.Integer> min;

    StackMin() {
        min = new Stack<>();
    }

    public void push(int value) {
        if (value < minimumValue()) {
            min.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int element = super.pop();
        if (element == minimumValue()) {
            min.pop();
        }
        return element;
    }

    private int minimumValue() {
        if (min.isEmpty())
            return java.lang.Integer.MAX_VALUE;
        return (int) min.peek();
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.push(7);
        stackMin.push(4);
        stackMin.push(9);
        System.out.println(stackMin.min.pop());
        stackMin.pop();
        stackMin.push(8);
        stackMin.push(2);
        System.out.println(stackMin.min.pop());
    }
}
