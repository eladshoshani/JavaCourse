package summery.inheritance.m2022b86q4;

public class A {
    private int _num;

    public A(int num) {
        _num = num;
    }

    public int getNum() {
        return _num;
    }

    public void setNum(int num) {
        _num = num;
    }

    public int f(A a) {
        System.out.println("in A");
        _num = a._num;
        return _num;
    }
}
