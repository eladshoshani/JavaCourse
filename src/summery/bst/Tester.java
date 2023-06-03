package summery.bst;

import complexity.Utils;

public class Tester {
    private static Node<Integer> test1() {
        Node<Integer> root = new Node<Integer>(2);
        Node<Integer> n11 = new Node<Integer>(7);
        Node<Integer> n12 = new Node<Integer>(5);
        Node<Integer> n21 = new Node<Integer>(2);
        Node<Integer> n22 = new Node<Integer>(6);
        Node<Integer> n23 = new Node<Integer>(3);
        Node<Integer> n24 = new Node<Integer>(6);
        Node<Integer> n31 = new Node<Integer>(5);
        Node<Integer> n32 = new Node<Integer>(8);
        Node<Integer> n33 = new Node<Integer>(4);
        Node<Integer> n34 = new Node<Integer>(5);
        Node<Integer> n35 = new Node<Integer>(8);
        Node<Integer> n36 = new Node<Integer>(4);
        Node<Integer> n37 = new Node<Integer>(5);
        Node<Integer> n38 = new Node<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static Node<Integer> test2() {
        Node<Integer> root = new Node<Integer>(2);
        Node<Integer> n11 = new Node<Integer>(7);
        Node<Integer> n12 = new Node<Integer>(5);
        Node<Integer> n21 = new Node<Integer>(2);
        Node<Integer> n22 = new Node<Integer>(6);
        Node<Integer> n23 = new Node<Integer>(9);
        Node<Integer> n31 = new Node<Integer>(5);
        Node<Integer> n32 = new Node<Integer>(8);
        Node<Integer> n33 = new Node<Integer>(4);
//        Node<Integer> n41 = new Node<Integer>(1);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;
//        n33.left = n41;

        return root;
    }

    public static NodeInt testBinaryTree() {
        // level 0
        NodeInt root = new NodeInt(35);
        // level 1
        NodeInt l11 = new NodeInt(7);
        NodeInt l12 = new NodeInt(2);
        // level 2
        NodeInt l21 = new NodeInt(10);
        NodeInt l22 = new NodeInt(37);
        NodeInt l23 = new NodeInt(60);
        NodeInt l24 = new NodeInt(28);
        // level 3
        NodeInt l31 = new NodeInt(-8);
        NodeInt l32 = new NodeInt(44);
        NodeInt l33 = new NodeInt(8);
        // level 4
        NodeInt l41 = new NodeInt(30);
        NodeInt l42 = new NodeInt(24);
        NodeInt l43 = new NodeInt(24);
        // level 5
        NodeInt l51 = new NodeInt(6);

        // the relationship between the nodes:
        root.leftSon = l11;
        root.rightSon = l12;
        l11.leftSon = l21;
        l11.rightSon = l22;
        l12.leftSon = l23;
        l12.rightSon = l24;
        l21.rightSon = l31;
        l22.leftSon = l32;
        l23.rightSon = l33;
        l32.leftSon = l41;
        l32.rightSon = l42;
        l33.leftSon = l43;
        l41.leftSon = l51;

        return root;
    }

    public static NodeInt testBinarySearchTree() {
        // level 0
        NodeInt root = new NodeInt(35);
        // level 1
        NodeInt l11 = new NodeInt(17);
        NodeInt l12 = new NodeInt(200);
        // level 2
        NodeInt l21 = new NodeInt(10);
        NodeInt l22 = new NodeInt(32);
        NodeInt l23 = new NodeInt(60);
        NodeInt l24 = new NodeInt(280);
        // level 3
        NodeInt l31 = new NodeInt(12);
        NodeInt l32 = new NodeInt(24);
        NodeInt l33 = new NodeInt(80);
        // level 4
        NodeInt l41 = new NodeInt(19);
        NodeInt l42 = new NodeInt(28);
        NodeInt l43 = new NodeInt(74);
        // level 5
        NodeInt l51 = new NodeInt(16);

        // the relationship between the nodes:
        root.leftSon = l11;
        root.rightSon = l12;
        l11.leftSon = l21;
        l11.rightSon = l22;
        l12.leftSon = l23;
        l12.rightSon = l24;
        l21.rightSon = l31;
        l22.leftSon = l32;
        l23.rightSon = l33;
        l32.leftSon = l41;
        l32.rightSon = l42;
        l33.leftSon = l43;
        l41.leftSon = l51;

        return root;
    }

    public static void preorder(NodeInt root) {
        if (root == null)
            return;

        System.out.print(root.num + ", ");
        preorder(root.leftSon);
        preorder(root.rightSon);
    }

    public static void inorder(NodeInt root) {
        if (root == null)
            return;

        inorder(root.leftSon);
        System.out.print(root.num + ", ");
        inorder(root.rightSon);
    }

    public static void postorder(NodeInt root) {
        if (root == null)
            return;

        postorder(root.leftSon);
        postorder(root.rightSon);
        System.out.print(root.num + ", ");
    }

    public static int depth(NodeInt root) {
        if (root == null)
            return -1;

        int goLeft = 1 + depth(root.leftSon);
        int goRight = 1 + depth(root.rightSon);
        return Math.max(goLeft, goRight);
    }

    public static int delimiter(NodeInt root) {
        if (root == null)
            return -1;
        int curDelimiter = depth(root.leftSon) + depth(root.rightSon) + 2;
        int leftBest = delimiter(root.leftSon);
        int rightBest = delimiter(root.rightSon);

        return Math.max(Math.max(leftBest, rightBest), curDelimiter);
    }

    public static int[] sumLevels(NodeInt root) {
        int n = depth(root);
        int[] a = new int[n + 1];
        sumLevels(root, a, 0);
        return a;
    }
    public static void sumLevels(NodeInt root, int[] a, int level) {
        if (root == null)
            return;

        a[level] += root.num;
        sumLevels(root.leftSon, a, level + 1);
        sumLevels(root.rightSon, a, level + 1);
    }




    public static void main(String[] args) {
        NodeInt root = testBinarySearchTree();
        BTPrinter2.printTree(root);
        Utils.printArray(sumLevels(root));

//        BTPrinter2.printTree(testBinaryTree());
//        BTPrinter2.printTree(testBinarySearchTree());
    }
}


