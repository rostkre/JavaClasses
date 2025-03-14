package lr2;

public class Example2 {
    public static void main(String[] args) {
        // Размеры массива
        int n = 5;  // количество строк
        int m = 7;  // количество столбцов

        int[][] arr = new int[n][m];
        int value = 1;  // число, которым заполняем

        // Заполняем массив "змейкой" по строкам
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Чётная строка (0, 2, 4...): слева направо
                for (int j = 0; j < m; j++) {
                    arr[i][j] = value++;
                }
            } else {
                // Нечётная строка (1, 3, 5...): справа налево
                for (int j = m - 1; j >= 0; j--) {
                    arr[i][j] = value++;
                }
            }
        }

        // Выводим результат
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }
}