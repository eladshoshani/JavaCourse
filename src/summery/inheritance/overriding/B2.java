package summery.inheritance.overriding;

public class B2 extends A {
    public void f(Object o) {
        System.out.println("B2-OOO");
    }

    public void f(A a) {
        System.out.println("B2-AAA");
    }

    public void f(B2 b2) {
        System.out.println("B2-BBB");
    }

}
