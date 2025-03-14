package timus_2;
import java.util.Scanner;
public class timus_1068 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int sum = 0;

            if (N >= 1) {
                // Формула суммы 1 + 2 + ... + N = N*(N+1)/2
                sum = N * (N + 1) / 2;
            } else {
                // Суммируем все числа от N до 1 (включая 0, если N < 0)
                for (int i = N; i <= 1; i++) {
                    sum += i;
                }
            }

            System.out.println(sum);
        }
}

