package lr1;

import java.util.Scanner;

public class example14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int num = scanner.nextInt();

        int numMinusOne = num - 1;
        int numPlusOne = num + 1;
        int sum = numMinusOne + num + numPlusOne;
        int fourthNumber = sum * sum;

        System.out.printf("%d %d %d %d\n", numMinusOne, num, numPlusOne, fourthNumber);

        scanner.close();
    }
}
