package summery.inheritance;

public class BigDog extends Dog {
    double weight;

    public BigDog(int age, String name, String color, double weight) {
        super(age, name, color);
        this.weight = weight;
    }

    public void makeSound() {
        System.out.println(name + " HAV HAV");
    }

    public void jump() {
        System.out.println(name + " jumps");
    }

    @Override
    public String toString() {
        return super.toString() + ", weight: " + weight;
    }
}
