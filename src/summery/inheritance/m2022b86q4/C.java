package summery.inheritance.m2022b86q4;

public class C extends B {
    public C(int n) {
        super(n);
    }

    public int f(A a) {
        System.out.println("in C");
        if (a instanceof C)
            return a.getNum() + 1;
        return super.f(a);
    }
}
