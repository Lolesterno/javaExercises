import aritmetric.Aritmetric;
import person.Person;

/**
 * Resumen de la programacion Orientada a Objetos
 * Encapsulamiento: Definir metodos y variables a una clase y definir cuales de ellas se pueden modificar desde otra clase o archivo, encapsular la entidad que se quiere reflejar en el programa
 * Herencia: Capacidad de heredar metodos a otras clases anidadas, es decir, crear una clase general y hacer subclases que puedan usar los metodos de esta clase general
 * Polimorfismo: la capacidad de que las clases puedan realizar multiples comportamientos de las clases heredadas, sobreescribir los metodos de las clases padre
 *
 * */

public class Main {
    public static void main(String[] args) {

        // Objeto persona
        Person usuario1 = new Person("Nicolas", "Cuadros", "correo@correo.com", 3132803746d);

        Person usuario2 = new Person("Samaris", "Ceuta", "correo@correo2.com", 3132222233d);

        // Println llama automaticamente al metodo Object.toString()
        System.out.println(usuario1);
        System.out.println(usuario2);

        // Objeto Aritmetrica
        Aritmetric operation = new Aritmetric(10, 50);

        System.out.println();
    }
}