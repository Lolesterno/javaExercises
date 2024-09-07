package animals;

public class Dog extends Animal{
    public void sound() {
        System.out.println("El perro esta ladrando");
    }

    // Metodo sobreescrito
    @Override
    protected void sleep() {
        System.out.println("El perro duerme 20 horas diarias");

        // Metodo desde la clase padre con la palabra Super
        super.sleep();
    }

}
