public class AbstractClass {
        public static void main(String[] args) {
            FiguraGeometrica rectangulo = new Rectangulo();
            rectangulo.draw();
            FiguraGeometrica circulo = new Circulo();
            circulo.draw();
        }
}

// Clase Abstracta

/**Clases Abstractas
 * Son aquellas que dejan sin implementar alguno o todos sus metodos, para que las clases hijas o derivadas proporcione la implementacion
 * Esta Clase no se puede Instanciar
 * Las clases Hijas o que heredan de esta clase tienen que implementar los metodos definidos en la clase abstracta
 * Los metodos de la clase abstracta son genericos*/

abstract class FiguraGeometrica {
    public abstract void draw();
}

class Rectangulo extends FiguraGeometrica{
    public void draw() {
        System.out.println("Se Dibuja un rectangulo");
    }
}

class Circulo extends FiguraGeometrica {
    @Override
    public void draw() {
        System.out.println("SE Dibuja un Circulo");
    }
}