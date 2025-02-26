package timus;

import java.util.Scanner;

public class timus_1264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем входные данные
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // Формула для расчета количества строк кода, которое потребуется
        int requiredLines = N * (M + 1);

        // Выводим результат
        System.out.println(requiredLines);
    }
}