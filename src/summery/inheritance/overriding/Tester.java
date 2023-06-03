package summery.inheritance.overriding;

public class Tester {
    public static void main(String[] args) {
        A a = new A();
        A b1 = new B1();
        A b2 = new B2();
        B1 b11 = new B1();
        B2 b22 = new B2();
        Object o = b11;

        b1.f(b11);
    }
}
