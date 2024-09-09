import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        Set<String> conjunto = new TreeSet<>();
        conjunto.add("Cuadrado");
        conjunto.add("Caja");
        conjunto.add("Televisor");
        conjunto.add("Televisor");
        conjunto.add("Lista");
        conjunto.add("Usuario");

        // Eliminar elemento
        conjunto.remove("Caja");

        System.out.println("Elementos del Set");
        conjunto.forEach(System.out::println);
    }
}
