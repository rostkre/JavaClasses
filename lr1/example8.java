package lr1;

import java.util.Scanner;

public class example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите день недели: ");
        String dayOfWeek = scanner.nextLine();

        System.out.print("Введите месяц: ");
        String month = scanner.nextLine();

        System.out.print("Введите число: ");
        int day = scanner.nextInt();

        System.out.printf("Сегодня: %s, %d %s\n", dayOfWeek, day, month);

        scanner.close();
    }
}
