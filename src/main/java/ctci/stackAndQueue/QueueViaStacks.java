package ctci.stackAndQueue;
/* @author Shambhuraj created on 2/18/2020*/
/*Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks. */
import java.util.Stack;

public class QueueViaStacks {

    private Stack pushStack = new Stack<Integer>();
    private Stack popStack = new Stack<Integer>();

    public static void main(String[] args) {
        QueueViaStacks queueViaStacks = new QueueViaStacks();
        queueViaStacks.add(1);
        queueViaStacks.add(2);
        System.out.println(queueViaStacks.peek());
        queueViaStacks.add(3);

        queueViaStacks.remove();
        System.out.println(queueViaStacks.peek());
        queueViaStacks.add(4);
        queueViaStacks.remove();
        queueViaStacks.add(5);
        System.out.println(queueViaStacks.peek());
    }

    public void add(int data) {
        pushStack.push(data);
    }

    public int remove() {
        pushToPopStack();
        return (int) popStack.pop();
    }

    public int peek() {
        pushToPopStack();
        return (int) popStack.peek();
    }

    private void pushToPopStack() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
