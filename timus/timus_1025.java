package timus_2;

import java.util.Arrays;
import java.util.Scanner;

public class timus_1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();          // Количество групп
        int[] groups = new int[K];

        // Считываем размеры групп
        for (int i = 0; i < K; i++) {
            groups[i] = sc.nextInt();
        }

        // Сортируем по возрастанию
        Arrays.sort(groups);

        // Нужно набрать голоса в floor(K/2) + 1 группах
        int needed = K / 2 + 1;

        int answer = 0;
        // Складываем стоимость "убедить" самые маленькие needed групп
        for (int i = 0; i < needed; i++) {
            // Для группы размером s нужно (s // 2) + 1
            // (операция // в Java — это обычное целочисленное деление)
            answer += (groups[i] / 2) + 1;
        }

        System.out.println(answer);
    }
}
