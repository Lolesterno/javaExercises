import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> miLista1 = new ArrayList<>();
        miLista1.add("Lunes");
        miLista1.add("Martes");
        miLista1.add("Miercoles");
        miLista1.add("Jueves");
        miLista1.add("Viernes");
        miLista1.add("Sabado");
        miLista1.add("Domingo");

//        for(String dia : miLista1) {
//            System.out.println(dia);
//        }
        // Funciones Lambda (Funciones anonimas con un codigo muy compacto)
        miLista1.forEach( element -> {
            System.out.println("Elemento: " + element);
        } );

        miLista1.forEach(System.out::println);
    }


}
