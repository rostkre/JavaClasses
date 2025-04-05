package timus_5;

import java.util.Scanner;

public class timus_1209 {
    // Максимально возможный n нам нужен такой, чтобы n(n+1)/2 мог покрывать K вплоть до 2^31-1 (~2.1e9).
    private static final int MAX_N = 46340;

    // Массив для хранения префиксных сумм вида sumDigits[i] = 1 + 2 + ... + i
    // sumDigits[i] = i*(i+1)/2
    private static long[] sumDigits = new long[MAX_N + 1];

    public static void main(String[] args) {
        // Предварительно вычислим частичные суммы, чтобы затем быстро находить нужный n бинарным поиском
        precomputeSums();

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // Массив для ответов (чтобы потом вывести разом, если нужно)
        char[] answers = new char[N];

        for (int i = 0; i < N; i++) {
            long K = in.nextLong();
            answers[i] = getDigitAtPosition(K);
        }

        // Выводим ответы через пробел
        for (int i = 0; i < N; i++) {
            System.out.print(answers[i]);
            if (i < N - 1) {
                System.out.print(' ');
            }
        }
        System.out.println();
    }

    // Предварительное заполнение массива sumDigits
    private static void precomputeSums() {
        for (int i = 1; i <= MAX_N; i++) {
            sumDigits[i] = sumDigits[i - 1] + i;
        }
    }

    // Бинарный поиск по массиву sumDigits, чтобы найти минимальное n, для которого sumDigits[n] >= K.
    private static int findN(long K) {
        // границы диапазона для n
        int left = 1, right = MAX_N;
        while (left < right) {
            int mid = (left + right) >>> 1; // (left+right)/2
            if (sumDigits[mid] >= K) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // Здесь left == right — искомое n
    }

    // Находим, какая цифра находится в позиции K
    private static char getDigitAtPosition(long K) {
        // 1) Ищем n:  sumDigits[n-1] < K <= sumDigits[n]
        int n = findN(K);

        // 2) Считаем offset = K - sumDigits[n-1]
        long offset = K - sumDigits[n - 1];

        // 3) Если offset == 1, то цифра '1', иначе '0'
        return (offset == 1) ? '1' : '0';
    }
}
