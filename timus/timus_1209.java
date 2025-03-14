package timus_2;

import java.util.Scanner;

public class timus_1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // число запросов

        for (int i = 0; i < N; i++) {
            long K = sc.nextLong(); // позиция, для которой ищем цифру

            // 1) Находим i такое, что S_{i-1} < K <= S_i, где S_i = i*(i+1)/2.
            // Используем приближенную формулу, а затем при необходимости корректируем.
            long iApprox = (long) Math.floor((-1 + Math.sqrt(1 + 8.0 * K)) / 2);
            if (iApprox * (iApprox + 1) / 2 < K) {
                iApprox++;
            }

            // 2) Смещение внутри i-го блока
            long sPrev = (iApprox - 1) * iApprox / 2; // S_{i-1}
            long offset = K - sPrev;                 // K - S_{i-1}

            // 3) Если offset=1 -> цифра '1', иначе '0'
            if (offset == 1) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }

            // Выводим пробел (или перевод строки) между ответами
            // По условию задачи часто ответы идут либо в одну строку, либо по строкам.
            // Уточните формат вывода в условии. Предположим, что в одной строке:
            System.out.print(" ");
        }

        // В конце можно перевести строку
        System.out.println();
    }
}
