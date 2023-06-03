package summery.inheritance;

public class Main {

    public static void main(String[] args) {
        Object o = new Object();
        Animal dog1 = new Dog(9, "Yosi");
        Animal cat1 = new Cat(9, "MMM");
        Animal dog2 = new Dog(8, "Elad");
        Animal bigDog1 = new BigDog(13, "Itai", "white", 40);
        Animal cat2 = new Cat(3, "Maor");

        Animal[] animals = {dog1, dog2, bigDog1, cat1, cat2};
        for (int i = 0; i < animals.length; i++) {
            animals[i].makeSound();
        }


//        Zoo zoo = new Zoo();
//        zoo.addAnimal(dog1);
//        zoo.addAnimal(dog2);
//        zoo.addAnimal(bigDog1);
//        zoo.addAnimal(cat);
//        zoo.addAnimal(bigDog2);
//
//        zoo.doActions();

    }
}
