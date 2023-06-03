package summery.inheritance;

public class Cat extends Animal {

    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meaw meaw");
    }


}
