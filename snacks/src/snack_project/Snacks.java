package snack_project;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

     // Bloque estatico inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas Fritas", 2500));
        snacks.add(new Snack("Coca-Cola", 3500));
        snacks.add(new Snack("Galletas", 1500));
     }

     public static void addSnack(Snack snack) {
        snacks.add(snack);
     }

     public static void viewSnacks() {
        String invSnacks = "";
        for (var snack: snacks) {
            invSnacks += snack.toString() + "\n";
        }
         System.out.println("-- Inventario Actual de Snacks --");
         System.out.println(invSnacks);
     }

     public static List<Snack> getSnacks(){
        return snacks;
     }
}
