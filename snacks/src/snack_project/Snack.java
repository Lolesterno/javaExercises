package snack_project;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int countSnacks = 0;
    private int idSnack;
    private String name;
    private double price;

    public Snack() {
        this.idSnack = ++Snack.countSnacks;
    }

    public Snack(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public static int getCountSnacks() {
        return countSnacks;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "idSnack=" + idSnack +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(price, snack.price) == 0 && Objects.equals(name, snack.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, name, price);
    }
}
