package summery.bst;

public class NodeInt {
    int num;
    NodeInt leftSon;
    NodeInt rightSon;

    public NodeInt(int number) {
        num = number;
        leftSon = null;
        rightSon = null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public NodeInt getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(NodeInt leftSon) {
        this.leftSon = leftSon;
    }

    public NodeInt getRightSon() {
        return rightSon;
    }

    public void setRightSon(NodeInt rightSon) {
        this.rightSon = rightSon;
    }

}
