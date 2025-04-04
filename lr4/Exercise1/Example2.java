package lr4.Exercise1;

public class Example2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            // При необходимости можно добавить строку "1" до throw:
            // System.out.println("1");

            throw new RuntimeException("Непроверяемая ошибка");

            // Здесь ничего писать нельзя: всё будет недостижимо
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}

