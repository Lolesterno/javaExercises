public class Matrices {
    public static void main(String[] args) {
        // Definicion de una matriz

        final var RENGLONES = 2;
        final var COLUMNAS = 3;
        int[][] matriz = new int[RENGLONES][COLUMNAS];


        // Modificar los valores de la matriz
        matriz[0][0] = 100;
        matriz[0][1] = 200;
        matriz[0][2] = 300;
        matriz[1][0] = 400;
        matriz[1][1] = 500;
        matriz[1][2] = 600;

        // Recorrer una matriz
        for(var i = 0; i < RENGLONES; i++) {
            for(var j = 0; j < COLUMNAS; j++) {
                System.out.println("Valor de la matriz ["+i+"]["+j+"]: " + matriz[i][j]);
            }
        }

        // Nueva Matriz
        var matrizAnidada = new int[][]{
                {100, 300, 500},
                {700, 900, 1100}
        };

        // Recorrer matriz anidada
        for(int mi = 0; mi < matrizAnidada.length; mi++){
            for (int mi2 = 0; mi2 < matrizAnidada[mi].length; mi2++) {
                System.out.println("Valor de la matriz ["+mi+"]["+mi2+"]: " + matrizAnidada[mi][mi2]);
            }
        }
    }
}
