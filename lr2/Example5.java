package lr2;

public class Example5 {
    public static void main(String[] args) {
        // Создаём несколько объектов класса Rectangle
        Rectangle rect1 = new Rectangle(5.0, 3.0);
        Rectangle rect2 = new Rectangle(10.0, 2.5);

        // Выводим информацию о прямоугольниках
        System.out.println("=== Первый прямоугольник ===");
        System.out.println("Длина: " + rect1.getLength());
        System.out.println("Ширина: " + rect1.getWidth());
        System.out.println("Площадь: " + rect1.getArea());
        System.out.println("Периметр: " + rect1.getPerimeter());

        System.out.println("\n=== Второй прямоугольник ===");
        System.out.println("Длина: " + rect2.getLength());
        System.out.println("Ширина: " + rect2.getWidth());
        System.out.println("Площадь: " + rect2.getArea());
        System.out.println("Периметр: " + rect2.getPerimeter());

        // Изменяем значения полей у второго прямоугольника
        rect2.setLength(7.5);
        rect2.setWidth(4.0);

        System.out.println("\nПосле изменения значений у второго прямоугольника:");
        System.out.println("Длина: " + rect2.getLength());
        System.out.println("Ширина: " + rect2.getWidth());
        System.out.println("Площадь: " + rect2.getArea());
        System.out.println("Периметр: " + rect2.getPerimeter());
    }
}

// Класс Rectangle
class Rectangle {
    private double length; // Длина
    private double width;  // Ширина

    // Конструктор с параметрами
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Геттеры (методы для получения значений)
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Сеттеры (методы для установки значений)
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Метод для вычисления площади
    public double getArea() {
        return length * width;
    }

    // Метод для вычисления периметра
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
