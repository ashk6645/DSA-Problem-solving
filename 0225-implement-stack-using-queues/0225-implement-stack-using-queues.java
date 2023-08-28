import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int topElement;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
        topElement = x;
    }

    public int pop() {
        while (queue1.size() > 1) {
            topElement = queue1.remove();
            queue2.add(topElement);
        }
        int poppedElement = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return poppedElement;
    }

    public int top() {
        return topElement;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

   
}
