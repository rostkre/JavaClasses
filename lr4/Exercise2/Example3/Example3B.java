package lr4.Exercise2.Example3;

import java.util.Scanner;

public class Example3B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        try {
            System.out.print("Введите размер массива: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: введено нечисловое или недопустимое значение размера.");
            return;
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return;
        }

        byte[] arr = new byte[n];

        System.out.println("Введите " + n + " чисел (тип byte в диапазоне -128..127):");
        for (int i = 0; i < n; i++) {
            try {
                // parseByte выкинет NumberFormatException при значении вне -128..127
                arr[i] = Byte.parseByte(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: введённое значение не является корректным byte. Зададим 0.");
                arr[i] = 0;
            }
        }

        byte sum = 0;
        for (byte b : arr) {
            // Чтобы отлавливать переполнение суммы, проверим вручную до сложения:
            int tempSum = sum + b;
            if (tempSum < Byte.MIN_VALUE || tempSum > Byte.MAX_VALUE) {
                // Можем бросить своё исключение
                System.err.println("Внимание! Произошло переполнение при сложении " + sum + " + " + b);
                // Либо выбрасываем исключение, либо обнуляем, либо обрываем программу
                // throw new ArithmeticException("Переполнение byte при сумме");
            }
            sum = (byte) tempSum; // Выполняем сложение (с учётом возможного переполнения)
        }

        System.out.println("Сумма элементов (с учётом ручной проверки) = " + sum);
    }
}
