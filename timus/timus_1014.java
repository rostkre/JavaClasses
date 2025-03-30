package timus_3;

import java.util.*;

public class timus_1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод числа N
        long N = scanner.nextLong();

        // Если N = 0, ответ 10 (минимальное число, произведение цифр которого 0)
        if (N == 0) {
            System.out.println(10);
            return;
        }

        // Список для хранения цифр числа
        List<Integer> digits = new ArrayList<>();

        // Процесс разложения N на цифры, произведение которых равно N
        for (int i = 9; i >= 2; i--) {
            while (N % i == 0) {
                digits.add(i);
                N /= i;
            }
        }

        // Если после разложения N не стало 1, значит такого числа нет
        if (N != 1) {
            System.out.println(-1);
            return;
        }

        // Сортируем цифры по возрастанию для минимального числа
        Collections.sort(digits);

        // Выводим результат
        for (int digit : digits) {
            System.out.print(digit);
        }
    }
}
