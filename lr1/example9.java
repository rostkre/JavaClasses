package lr1;

import java.util.Scanner;

public class example9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название месяца: ");
        String month = scanner.nextLine();

        System.out.print("Введите количество дней в месяце: ");
        int days = scanner.nextInt();

        System.out.printf("Месяц %s содержит %d дней.\n", month, days);

        scanner.close();
    }
}