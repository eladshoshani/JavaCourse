package summery.inheritance;

import java.io.Serializable;

public class Dog extends Animal {
    protected String color;
    public Dog(int age, String name, String color) {
        super(age, name);
        this.color = color;
    }

    public Dog(int age, String name) {
        this(age, name, "black");
    }

    public void makeSound() {
        System.out.println(name + " hav hav");
    }

    public String toString() {
        return super.toString() + ", color: " + color;
    }
}
