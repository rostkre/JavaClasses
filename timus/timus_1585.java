package timus_5;

import java.util.Scanner;

public class timus_1585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // Пропускаем перевод строки после числа n

        // Счётчики для каждого вида пингвинов
        int empCount = 0;
        int littleCount = 0;
        int macCount = 0;

        for (int i = 0; i < n; i++) {
            String penguinType = sc.nextLine();
            if (penguinType.equals("Emperor Penguin")) {
                empCount++;
            } else if (penguinType.equals("Little Penguin")) {
                littleCount++;
            } else if (penguinType.equals("Macaroni Penguin")) {
                macCount++;
            }
        }

        // Так как по условию гарантируется единственный победитель:
        if (empCount > littleCount && empCount > macCount) {
            System.out.println("Emperor Penguin");
        } else if (littleCount > empCount && littleCount > macCount) {
            System.out.println("Little Penguin");
        } else {
            System.out.println("Macaroni Penguin");
        }
    }
}
