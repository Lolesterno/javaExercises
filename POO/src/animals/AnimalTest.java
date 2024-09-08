package animals;

public class AnimalTest {
    static void prinSound(Animal animal) {
        animal.sound();
    }

    public static void main(String[] args) {
        System.out.println("Herencia de Java - Animales");

        //Objeto Clase Animal - Padre
        Animal animal = new Animal();
        prinSound(animal);

        Animal perro = new Dog();
        prinSound(perro);

        Animal gato = new Cat();
        prinSound(gato);
    }
}
