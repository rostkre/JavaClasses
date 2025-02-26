package timus;

import java.util.Scanner;

public class timus_1409 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем входные данные
        int a = scanner.nextInt(); // банки, простреленные Гарри
        int b = scanner.nextInt(); // банки, простреленные Ларри

        // Общее количество банок
        int totalCans = a + b - 1;

        // Количество банок, которые не прострелил каждый
        int harryMissed = totalCans - a;
        int larryMissed = totalCans - b;

        // Выводим результат
        System.out.println(harryMissed + " " + larryMissed);
    }
}
