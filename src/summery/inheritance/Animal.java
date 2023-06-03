package summery.inheritance;

import java.util.Comparator;

public abstract class Animal {
    protected int age;
    protected String name;

    public static class CompareByAge implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            if (o1.age > o2.age)
                return 1;
            if (o1.age < o2.age)
                return -1;
            return 0;
        }
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void makeSound();

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Animal))
            return false;
        Animal other = (Animal) obj;
        return equals(other);
    }

    public boolean equals(Animal other) {
        return age == other.age && name.equals(other.name);
    }
}