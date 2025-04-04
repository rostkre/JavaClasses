package lr4.Exercise2.Example3;

import java.util.Scanner;

public class Example3A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = Integer.parseInt(scanner.nextLine());  // Возможный NumberFormatException

        byte[] arr = new byte[n];
        System.out.println("Введите " + n + " чисел (тип byte):");
        for (int i = 0; i < n; i++) {
            // Может быть NumberFormatException, если число выходит за диапазон -128..127
            arr[i] = Byte.parseByte(scanner.nextLine());
        }

        // Сумма в byte может переполняться, но без исключений
        byte sum = 0;
        for (byte b : arr) {
            sum += b; // арифметическое переполнение НЕ бросает исключение
        }
        System.out.println("Сумма элементов (возможно с переполнением) = " + sum);
    }
}
