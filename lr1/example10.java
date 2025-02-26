package lr1;

import java.util.Scanner;
import java.time.Year;

public class example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год рождения: ");
        int birthYear = scanner.nextInt();

        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;

        System.out.printf("Ваш возраст: %d лет.\n", age);

        scanner.close();
    }
}
