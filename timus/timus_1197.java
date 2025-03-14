package timus_2;

import java.util.Scanner;

public class timus_1197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // количество тестов
        sc.nextLine();        // считываем перевод строки после числа

        for (int i = 0; i < T; i++) {
            String position = sc.nextLine().trim();

            // Преобразуем, например, 'a1' -> (x=1, y=1), 'h8' -> (x=8, y=8)
            char fileChar = position.charAt(0); // буква (a-h)
            char rankChar = position.charAt(1); // цифра (1-8)

            // Получаем числовые координаты
            int file = fileChar - 'a' + 1;  // 'a' -> 1, 'b' -> 2, ..., 'h' -> 8
            int rank = rankChar - '0';      // '1' -> 1, '2' -> 2, ..., '8' -> 8

            // Все возможные смещения для коня
            int[][] moves = {
                    {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
            };

            int count = 0; // счётчик допустимых ходов

            // Проверяем каждое из восьми возможных направлений
            for (int[] move : moves) {
                int newFile = file + move[0];
                int newRank = rank + move[1];

                // Проверяем, что конь не вышел за границы доски
                if (newFile >= 1 && newFile <= 8 && newRank >= 1 && newRank <= 8) {
                    count++;
                }
            }

            // Выводим результат для текущей позиции
            System.out.println(count);
        }
    }
}
