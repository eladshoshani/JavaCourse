package summery.linkedlists;

public class LinkedList {
    private IntNode head; // the first node in the list

    public LinkedList() {
        head = null;
    }

    public void addFirst(int val) {
        IntNode newNode = new IntNode(val);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    // adds a node with the given val to the end of the list
    public void addLast(int val) {
        IntNode newNode = new IntNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        IntNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;

    }

    // adds a node with the given val to the end of the list
    public void add(int val) {
        addLast(val);
    }

    // deletes the first occurrence of a node with the given val from the list
    public void delete(int val) {
        if (head == null) {
            return;
        }

        if (head.val == val) {
            head = head.next;
            return;
        }

        IntNode curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    public int getFirst() {
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        String s = "";
        IntNode cur = head;
        while (cur != null) {
            s += cur.val + " -> ";
            cur = cur.next;
        }
        return s;
    }

}

