package lr4.Exercise2.Example1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        try {
            System.out.print("Введите размер массива: ");
            // Ловим возможное некорректное число
            n = Integer.parseInt(scanner.nextLine());
            if (n <= 0) {
                // Если размер массива некорректен, бросаем исключение
                throw new IllegalArgumentException("Размер массива должен быть > 0");
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: введено нечисловое значение для размера массива.");
            return; // Завершаем программу
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return;
        }

        int[] arr = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            try {
                arr[i] = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: введено нечисловое значение. Элемент массива будет 0.");
                arr[i] = 0; // Можно так “заглушить”, чтобы продолжить работу
            }
        }

        int sumPos = 0;
        int countPos = 0;
        for (int x : arr) {
            if (x > 0) {
                sumPos += x;
                countPos++;
            }
        }

        // Проверяем наличие положительных элементов
        if (countPos == 0) {
            throw new RuntimeException("Нет положительных элементов!");
        } else {
            double averagePos = (double) sumPos / countPos;
            System.out.println("Среднее положительных = " + averagePos);
        }
    }
}
