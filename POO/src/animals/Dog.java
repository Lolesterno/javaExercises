package animals;

public class Dog extends Animal{

    // Metodo sobreescrito
    @Override
    protected void sleep() {
        System.out.println("El perro duerme 20 horas diarias");

        // Metodo desde la clase padre con la palabra Super -> Polimorfismo
        super.sleep();
    }

    @Override
    protected void sound() {
        System.out.println("El perro Ladra.. Guauff Guauff");
    }

}
