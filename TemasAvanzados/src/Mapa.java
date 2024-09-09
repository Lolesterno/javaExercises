import java.util.HashMap;
import java.util.Map;

public class Mapa {
    public static void main(String[] args) {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Nicolas");
        user.put("lastname", "cuadros");
        user.put("age", "24");

        // Imprimir valores del mapa - Diccionario
        System.out.println("Valores del Map: ");
        user.entrySet().forEach(System.out::println);

        // Iterar los elementos del map por separado
        System.out.println("\nIterando los elementos (key, value)");
        user.forEach((key, value) -> {
            System.out.println("Llave: " + key + " Valor: " + value);
        });
    }
}
