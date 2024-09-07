import java.util.Scanner;

public class MatrizDinamica {
    public static void main(String[] args) {
        int rows, cols;
        var console = new Scanner(System.in);

        // Define the matrix
        System.out.print("Proporciona el numero de filas de tu matriz: ");
        rows = Integer.parseInt(console.nextLine());
        System.out.print("Proporcione el numero de columnas de tu matriz: ");
        cols = Integer.parseInt(console.nextLine());

        var matrix = new int[rows][cols];

        // Values
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print("Inserte el valor de la matriz [" + row + "][" + col + "]: ");
                matrix[row][col] = Integer.parseInt(console.nextLine());
            }
        }
        // Send the Matriz with sum
        int diagonalsSum = 0;
        for (int rowIt = 0; rowIt < rows; rowIt++){
            for (int colIt = 0; colIt < cols; colIt++){
                if(rowIt == colIt) {
                    diagonalsSum += matrix[rowIt][colIt];
                }
                System.out.println("Tu matriz es [" + rowIt + "][" + colIt + "]: " + matrix[rowIt][colIt]);
            }
        }

        System.out.println("La suma de las diagonales de tu matriz es: " + diagonalsSum);

    }
}
