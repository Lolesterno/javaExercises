package person;

public class Person {
    private String name;
    private String lastName;
    private String email;
    private double phone;

    public Person(String name, String lastName, String email, double phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
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
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + lastName);
    }

    public void sendPhone() {
        System.out.println("Telefono del usuario: " + phone);
    }

    public void sendEmail() {
        System.out.println("Correo electronico: " + email);
    }

}
