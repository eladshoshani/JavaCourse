package summery.inheritance;

public class Zoo {
    private Animal[] animals;
    private int count;

    public Zoo() {
        animals = new Animal[100];
        count = 0;
    }

    public void addAnimal(Animal animal) {
        animals[count] = animal;
        count++;
    }

    public Animal getAnimal(int index) {
        return animals[index];
    }

    public Animal getAnimal(String name) {
        for (int i = 0; i < count; i++) {
            if (animals[i].getName().equals(name))
                return animals[i];
        }
        return null;
    }


    public Animal oldestAnimal() {
        Animal oldestAnimal = animals[0];
        for (int i = 1; i < count; i++) {
            if (animals[i].getAge() > oldestAnimal.getAge())
                oldestAnimal = animals[i];
        }
        return oldestAnimal;
    }

    public void doActions() {
        for (int i = 0; i < count; i++) {
            animals[i].makeSound();
            if (animals[i] instanceof BigDog) {
                ((BigDog) animals[i]).jump();
            }
        }
    }


}
