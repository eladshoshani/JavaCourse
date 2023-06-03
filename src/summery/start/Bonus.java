package summery.start;

import summery.inheritance.Animal;
import summery.inheritance.BigDog;
import summery.inheritance.Cat;
import summery.inheritance.Dog;

import java.util.*;

public class Bonus {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog(90, "Yosi"));
        animals.add(new BigDog(3, "Elad", "white", 52));
        animals.add(new Cat(31, "Itai"));
        animals.add(new Dog(28, "Moshe"));

        Collections.sort(animals, new Animal.CompareByAge());
        System.out.println(animals);

    }

}
