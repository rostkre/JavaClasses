package lr4.Exercise2.Example2;

import java.util.Scanner;

public class Example2A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пусть для примера вручную зададим матрицу
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.print("Введите номер столбца (0..2): ");
        int colIndex = Integer.parseInt(scanner.nextLine()); // Может вызвать NumberFormatException

        // Вывод столбца (может быть ArrayIndexOutOfBoundsException)
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][colIndex]);
        }
    }
}
