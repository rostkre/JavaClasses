package lr4.Exercise2.Example1;

import java.util.Scanner;

public class Example1A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = Integer.parseInt(scanner.nextLine()); // Возможный NumberFormatException

        int[] arr = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            // Возможен NumberFormatException, если введена нечисловая строка
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        // Подсчёт среднего среди положительных
        int sumPos = 0;
        int countPos = 0;
        for (int x : arr) {
            if (x > 0) {
                sumPos += x;
                countPos++;
            }
        }

        // Если countPos == 0, программа упадёт на делении на ноль или
        // на пользовательской проверке (если бы была) – здесь пока не обрабатываем.
        double averagePos = (double) sumPos / countPos;
        System.out.println("Среднее положительных = " + averagePos);
    }
}
