package summery.inheritance.overriding;

public class A {
    public void f(Object o) {
        System.out.println("A-OOO");
    }

    public void f(A a) {
        System.out.println("A-AAA");
    }

    public void f(B1 b1) {
        System.out.println("A-BBB");
    }


}
