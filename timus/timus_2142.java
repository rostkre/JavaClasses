package timus_7;

import java.util.Scanner;

public class timus_2142 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод исходных данных
        long A = scanner.nextLong(); // Красные земли
        long B = scanner.nextLong(); // Синие земли
        long C = scanner.nextLong(); // Красно-синие земли

        long X = scanner.nextLong(); // Требуемая красная мана
        long Y = scanner.nextLong(); // Требуемая синяя мана
        long Z = scanner.nextLong(); // Требуется еще столько любого цвета

        // Считаем сколько всего можно получить маны каждого цвета
        long redMana = A + C;    // Каждая красная + каждая красно-синяя может быть красной
        long blueMana = B + C;   // Каждая синяя + каждая красно-синяя может быть синей

        // Проверяем, достаточно ли маны каждого цвета
        long redNeed = Math.max(0, X - redMana);
        long blueNeed = Math.max(0, Y - blueMana);

        // Если базовой маны каждого цвета хватает, считаем, сколько остается для любого
        long anyMana = (A + B + C) - Math.max(X, A + C) - Math.max(Y, B + C);

        // Сначала тратим красную и синюю, оставшееся можно пустить на любое
        long restRed = redMana - X;
        long restBlue = blueMana - Y;
        long remain = 0;
        if (restRed > 0) remain += restRed;
        if (restBlue > 0) remain += restBlue;
        long bothUsed = Math.min(C, (redMana - A) + (blueMana - B));
        remain = (A + B + C) - X - Y;

        // Финальная проверка
        if (redMana >= X && blueMana >= Y && remain >= Z) {
            System.out.println("It is a kind of magic");
        } else {
            System.out.println("There are no miracles in life");
        }
    }
}
