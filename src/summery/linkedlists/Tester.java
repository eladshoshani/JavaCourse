package summery.linkedlists;

public class Tester {

    public static void main(String[] args) {
        // check LinkedList: --------------------------------
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.delete(2);

        // check DoublyLinkedList: --------------------------------
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        // Add nodes to the list
        doublyLinkedList.addAtHead(3);
        doublyLinkedList.addAtHead(2);
        doublyLinkedList.addAtHead(1);
        doublyLinkedList.addAtTail(4);
        doublyLinkedList.addAtTail(5);

        // Get the size of the list
        int size = doublyLinkedList.getSize(); // returns 5

        // Get the values of nodes in the list
        int val1 = doublyLinkedList.get(0); // returns 1
        int val2 = doublyLinkedList.get(2); // returns 3
        int val3 = doublyLinkedList.get(4); // returns 5

        // Delete a node from the list
        doublyLinkedList.deleteAtIndex(1); // deletes the node with value 2

        // Get the new size of the list
        int newSize = doublyLinkedList.getSize(); // returns 4

        // Get the new values of nodes in the list
        int newVal1 = doublyLinkedList.get(0); // returns 1
        int newVal2 = doublyLinkedList.get(2); // returns 4
        int newVal3 = doublyLinkedList.get(3); // returns 5


        // check Queue: --------------------------------
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // prints "1"
        System.out.println(queue.peek()); // prints "2"
        System.out.println(queue.isEmpty()); // prints "false"

        // check Stack: --------------------------------
        Stack stack = new Stack();
        stack.push(1);
        stack.push(8);
        stack.push(5);
        stack.push(30);
        stack.push(10);
        System.out.println(stack.sortStack());
    }


}
