package lr3;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем размер массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Создаём массив заданного размера
        int[] arr = new int[size];

        // Рекурсивно заполняем массив
        System.out.println("Введите элементы массива:");
        readArray(scanner, arr, 0);

        // Рекурсивно выводим массив
        System.out.println("Вы ввели массив:");
        printArray(arr, 0);
    }

    private static void readArray(Scanner scanner, int[] arr, int index) {
        // Если достигли конца массива — завершаем рекурсию
        if (index == arr.length) {
            return;
        }
        // Считываем элемент и записываем в массив
        arr[index] = scanner.nextInt();
        // Рекурсивно переходим к следующему элементу
        readArray(scanner, arr, index + 1);
    }

    private static void printArray(int[] arr, int index) {
        // Если достигли конца массива — завершаем рекурсию
        if (index == arr.length) {
            return;
        }
        // Выводим текущий элемент
        System.out.print(arr[index] + " ");
        // Рекурсивно переходим к следующему элементу
        printArray(arr, index + 1);
    }
}