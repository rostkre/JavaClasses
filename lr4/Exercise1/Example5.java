package lr4.Exercise1;

public class Example5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            // Генерируем RuntimeException
            throw new RuntimeException("ошибка");
        } catch (RuntimeException e) {
            System.out.println("1: " + e.getMessage());
        }
        System.out.println("2");
    }
}
