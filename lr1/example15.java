package lr1;

import java.util.Scanner;

public class example15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        int difference = num1 - num2;

        System.out.printf("Сумма: %d\n", sum);
        System.out.printf("Разность: %d\n", difference);

        scanner.close();
    }
}