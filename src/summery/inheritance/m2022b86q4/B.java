package summery.inheritance.m2022b86q4;

public class B extends A {
    public B(int n) {
        super(n);
    }

    public int f(B b) {
        System.out.println("in B");
        setNum(b.getNum() * 2);
        return getNum();
    }
}
