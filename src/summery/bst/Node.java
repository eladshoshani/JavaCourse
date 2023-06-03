package summery.bst;

class Node<T extends Comparable<?>> implements BTPrinter2.PrintableNode {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public BTPrinter2.PrintableNode getLeft() {
        return left;
    }

    @Override
    public BTPrinter2.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return data.toString();
    }

    // create a Node<Integer> tree from a NodeInt tree (NodeInt is for the java beginners course)
    public static Node<Integer> copyTree(NodeInt root) {
        if (root == null)
            return null;
        Node<Integer> newRoot = new Node<>(root.getNum());
        newRoot.left = copyTree(root.getLeftSon());
        newRoot.right = copyTree(root.getRightSon());
        return newRoot;
    }

}
