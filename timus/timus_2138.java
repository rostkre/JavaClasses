package timus_7;

import java.util.Scanner;

public class timus_2138{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        long value = scanner.nextLong();

        // Переводим число в 4 байта
        int[] bytes = new int[4];
        for (int i = 3; i >= 0; i--) {
            bytes[i] = (int) (value & 255);
            value >>= 8;
        }

        // Если исходный тип GOOD, то BAD должен прочитать наоборот
        // Если исходный тип BAD, то GOOD должен прочитать наоборот
        // Поэтому всегда делаем реверс
        for (int i = 0; i < 2; i++) {
            int tmp = bytes[i];
            bytes[i] = bytes[3 - i];
            bytes[3 - i] = tmp;
        }

        // Восстанавливаем число
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) + bytes[i];
        }

        System.out.println(result);
    }
}