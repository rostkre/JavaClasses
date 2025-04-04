package timus_4;

import java.util.Scanner;

public class timus_2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // Количество экзаменов
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();  // Считываем оценки
        }

        boolean hasThree = false;
        boolean allFives = true;
        double sum = 0.0;

        // Проходим по списку оценок:
        // 1) Проверяем наличие хотя бы одной оценки 3
        // 2) Проверяем, все ли оценки 5
        // 3) Накапливаем сумму для среднего балла
        for (int grade : grades) {
            if (grade <= 3) {
                hasThree = true;
            }
            if (grade != 5) {
                allFives = false;
            }
            sum += grade;
        }

        // Если есть «3» или меньше — стипендия не выплачивается
        if (hasThree) {
            System.out.println("None");
            return;
        }

        // Если все оценки «5» — именная стипендия
        if (allFives) {
            System.out.println("Named");
            return;
        }

        // Проверяем средний балл
        double avg = sum / n;
        if (avg >= 4.5) {
            System.out.println("High");
        } else {
            System.out.println("Common");
        }
    }
}
