package timus_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class timus_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Считываем входные данные: N, M, Y
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Y = sc.nextInt();

        List<Integer> result = new ArrayList<>();

        // Ищем все X в [0, M-1], удовлетворя (X^N) mod M = Y
        for (int x = 0; x < M; x++) {
            int value = 1;  // будем накапливать (x^N) mod M
            for (int i = 0; i < N; i++) {
                value = (value * x) % M;
            }
            if (value == Y) {
                result.add(x);
            }
        }

        // Если подходящих X нет, выводим -1
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            // Иначе выводим все найденные X через пробел
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
