package snack_project.service;

import snack_project.domain.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServiceSnacksList implements IsSnacks {
    private static final List<Snack> snacks;

     // Bloque estatico inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas Fritas", 2500));
        snacks.add(new Snack("Coca-Cola", 3500));
        snacks.add(new Snack("Galletas", 1500));
     }

     @Override
     public void addSnack(Snack snack) {
        snacks.add(snack);
     }
    @Override
     public void viewSnacks() {
        String invSnacks = "";
        for (var snack: snacks) {
            invSnacks += snack.toString() + "\n";
        }
         System.out.println("-- Inventario Actual de Snacks --");
         System.out.println(invSnacks);
     }

     @Override
     public List<Snack> getSnacks(){
        return snacks;
     }
}
