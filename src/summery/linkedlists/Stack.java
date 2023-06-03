package summery.linkedlists;

public class Stack {
    private LinkedList list;

    public Stack() {
        this.list = new LinkedList();
    }

    // adds an element to the top of the stack
    public void push(int data) {
        list.addFirst(data);
    }

    // removes and returns the element at the top of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }

        int top = list.getFirst();
        list.delete(top);
        return top;
    }

    // returns the element at the top of the stack without removing it
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }

        return list.getFirst();
    }

    // returns true if the stack is empty, false otherwise
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Stack sortStack() {
        Stack sortedStack = new Stack();
        while (!this.isEmpty()) {
            int cur = this.pop();
            int count = 0;
            while (!sortedStack.isEmpty() && cur < sortedStack.top()) {
                this.push(sortedStack.pop());
                count++;
            }
            sortedStack.push(cur);
            for (int i = 0; i < count; i++) {
                sortedStack.push(this.pop());
            }
        }
        return sortedStack;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

