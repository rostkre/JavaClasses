package timus_8;

import java.util.Scanner;

public class timus_1005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            total += w[i];
        }

        int minDiff = Integer.MAX_VALUE;
        // Перебираем все подмножества
        int limit = 1 << n;
        for (int mask = 0; mask < limit; mask++) {
            int sum = 0;
            // складываем те камни, биты которых установлены в mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += w[i];
                }
            }
            // разность: |(total - sum) - sum| = |total - 2*sum|
            int diff = Math.abs(total - 2 * sum);
            if (diff < minDiff) {
                minDiff = diff;
                // ранний выход, если невозможно лучше (0)
                if (minDiff == 0) break;
            }
        }

        System.out.println(minDiff);
    }
}