public class ArgumentosVariables {

    static void imprimirNumeros(int... numeros){ // Argumentos Variables
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    };

    static void variosParametros(String nombre, int... numeros) {
        System.out.println("Nombre: " + nombre);
        imprimirNumeros(numeros);
    }

    public static void main(String[] args) {
        variosParametros("Nicolas", 1, 2, 3, 44, 55, 66, 777);
    }

}
