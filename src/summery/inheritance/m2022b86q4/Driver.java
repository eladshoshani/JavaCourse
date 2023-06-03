package summery.inheritance.m2022b86q4;

public class Driver {
    public static void main(String[] args) {
        A ab = new B(2);
        B bb = new B(3);
        A ac = new C(4);
        B bc = new C(5);

        System.out.println(bc.f((A) bb));
    }
}
