package lr4.Exercise2.Example2;

import java.util.Scanner;

public class Example2B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Матрица 3x3:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Введите номер столбца (0..2): ");
        try {
            int colIndex = Integer.parseInt(scanner.nextLine());

            // Проверяем корректность индекса
            if (colIndex < 0 || colIndex >= matrix[0].length) {
                throw new IndexOutOfBoundsException("Нет столбца с таким индексом: " + colIndex);
            }
            // Если всё нормально, выводим столбец
            System.out.println("Столбец № " + colIndex + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][colIndex]);
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка ввода: требуется целое число.");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
