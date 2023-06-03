package summery.linkedlists;

// two directions linked list
public class DoublyLinkedList {
    private DoublyIntNode head;
    private DoublyIntNode tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addAtHead(int val) {
        DoublyIntNode newNode = new DoublyIntNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        DoublyIntNode newNode = new DoublyIntNode(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        DoublyIntNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        if (curr.prev == null) {
            head = curr.next;
        } else {
            curr.prev.next = curr.next;
        }

        if (curr.next == null) {
            tail = curr.prev;
        } else {
            curr.next.prev = curr.prev;
        }

        size--;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        DoublyIntNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        DoublyIntNode cur = head;
        while (cur != null){
            s += cur.val + " -> ";
            cur = cur.next;
        }
        return s;
    }
}
