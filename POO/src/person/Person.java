package person;

public class Person {
    private static int countPersons = 0;
    private int id;
    private String name;
    private String lastName;
    private String email;
    private double phone;

    public Person(String name, String lastName, String email, double phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;

        // Incrementar el atributo Statico
//        Person.countPersons++;
        this.id = ++Person.countPersons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public void viewPerson() {
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + lastName);
    }

    public void sendPhone() {
        System.out.println("Telefono del usuario: " + phone);
    }

    public void sendEmail() {
        System.out.println("Correo electronico: " + email);
    }

    public static int viewCountPersons() {
        return Person.countPersons;
    }

    //Sobreescribir toString
    @Override
    public String toString() {
        return "Id: " + this.id + ", Nombre: " + this.name + ", Apellido: " + this.lastName;
    }

}
