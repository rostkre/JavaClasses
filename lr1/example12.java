package lr1;

import java.util.Scanner;
import java.time.Year;

public class example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        int currentYear = Year.now().getValue();
        int birthYear = currentYear - age;

        System.out.printf("Ваш год рождения: %d.\n", birthYear);

        scanner.close();
    }
}