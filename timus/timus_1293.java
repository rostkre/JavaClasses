package timus;

import java.util.Scanner;

public class timus_1293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читаем входные данные
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        // Площадь одной панели
        int areaPerPanel = A * B;

        // Общая площадь с учетом обработки с обеих сторон
        int totalArea = N * areaPerPanel * 2;

        // Выводим результат
        System.out.println(totalArea);
    }
}
