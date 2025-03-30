package lr3;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();

        // Если пользователь ввёл 0, выводим сразу и завершаемся
        if (number == 0) {
            System.out.println("Двоичное представление: 0");
        } else {
            // Для отрицательных чисел обрабатываем отдельно знак
            if (number < 0) {
                System.out.print("Двоичное представление: -");
                number = -number;
            } else {
                System.out.print("Двоичное представление: ");
            }
            // Вызов рекурсивного метода
            toBinary(number);
            System.out.println();
        }
    }

    private static void toBinary(int n) {
        if (n == 0) {
            return;
        }
        // Сначала рекурсивно обрабатываем целую часть от деления на 2
        toBinary(n / 2);
        // Затем выводим остаток от деления — это следующая двоичная "цифра"
        System.out.print(n % 2);
    }
}