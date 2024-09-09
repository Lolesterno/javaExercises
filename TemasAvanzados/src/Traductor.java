/**Interfaces
 * Una Interface es un tipo de clase similar a la clase abstracta. sin embargo, la interface se enfoca en el comportamiento y la clase abstracta se enfoca en abstaer caracteristicas en comun
 * La interface es mas como cumplir un contrato
 * Los metodos por defecto son public y abstract
 * */

public interface Traductor {
    void traducir();

    // Metodos con implementacion por default
    default void iniciarTraductor() {
        System.out.println("Iniciando traductor...");
    }
}

class Ingles implements Traductor {
    @Override
    public void traducir() {
        System.out.println("Traduciendo al ingles");
    };
}

class Frances implements Traductor {
    @Override
    public void traducir() {
        System.out.println("Traduciendo al frances");
    }

    @Override
    public void iniciarTraductor(){
        System.out.println("Iniciando traductor en frances...");
    }
}

class TestTraductor {
    public static void main(String[] args) {
        Traductor idioma = new Ingles();
        idioma.iniciarTraductor();
        idioma.traducir();

        Traductor francia = new Frances();
        francia.iniciarTraductor();
        francia.traducir();
    }
}