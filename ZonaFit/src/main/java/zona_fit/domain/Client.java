package zona_fit.domain;

import java.util.Objects;

public class Client {
    private int id;
    private String name;
    private String lastname;
    private int membresia;

    public Client() {

    }

    public Client(int id) {
        this.id = id;
    }

    public Client(String name, String lastname, int membresia) {
        this.name = name;
        this.lastname = lastname;
        this.membresia = membresia;
    }

    public Client(int id, String name, String lastname, int membresia) {
        this(name, lastname, membresia);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", membresia=" + membresia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && membresia == client.membresia && Objects.equals(name, client.name) && Objects.equals(lastname, client.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, membresia);
    }
}
