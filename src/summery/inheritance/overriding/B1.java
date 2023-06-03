package summery.inheritance.overriding;

public class B1 extends A {
    public void f(Object o) {
        System.out.println("B1-OOO");
    }

    public void f(A a) {
        System.out.println("B1-AAA");
    }

    public void f(B1 b1) {
        System.out.println("B1-BBB");
    }

}
