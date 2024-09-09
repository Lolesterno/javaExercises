import java.io.Serializable;

/**JavaBeans
 * Es una clase de Java que debe cumplir con las siguientes condiciones:
 *
 * Debe tener un constructor public vacio, aunque puede tener mas constructores
 *
 * Debe aplicar el concepto de polimorfismo, (atributos privados, getter and seeders para el acceso a los atributos)
 *
 * Debe implementar la interface Serializable para enviar objetos por la red o a DD
 * */
public class JavaBeans {
    public static void main(String[] args) {
        Persona persona = new Persona();

        persona.setName("Nicolas");
        persona.setLastname("Cuadros");

        System.out.println(persona);
    }
}

class Persona implements Serializable {
    private String name;
    private String lastname;
    public Persona() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
