package summery.linkedlists;

public class Queue {
    private LinkedList list;

    public Queue() {
        this.list = new LinkedList();
    }

    // adds an element to the back of the queue
    public void enqueue(int data) {
        list.add(data);
    }

    // removes and returns the element at the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        int front = list.getFirst();
        list.delete(front);
        return front;
    }

    // returns the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        return list.getFirst();
    }

    // returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

