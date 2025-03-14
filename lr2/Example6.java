package lr2;

interface Shape {
    double getArea();
    double getPerimeter();
}

// Класс Circle (Круг)
class Circle implements Shape {
    private double radius; // Радиус круга

    public Circle(double radius) {
        this.radius = radius;
    }

    // Вычисление площади круга: π * r²
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Вычисление периметра (длины окружности): 2 * π * r
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Класс Square (Квадрат)
class Square implements Shape {
    private double side; // Длина стороны квадрата

    public Square(double side) {
        this.side = side;
    }

    // Площадь квадрата: side²
    @Override
    public double getArea() {
        return side * side;
    }

    // Периметр квадрата: 4 * side
    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}

// Класс Triangle (Треугольник)
class Triangle implements Shape {
    private double a, b, c; // Длины сторон треугольника

    // Конструктор принимает значения для трёх сторон
    public Triangle(double a, double b, double c) {
        // Предполагается, что переданы корректные значения для существования треугольника
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Периметр треугольника: сумма сторон
    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    // Площадь треугольника по формуле Герона:
    // S = √(s*(s - a)*(s - b)*(s - c)), где s — полупериметр
    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

// Главный класс Example6 для демонстрации работы с фигурами
public class Example6{
    public static void main(String[] args) {
        // Создание объектов для каждой фигуры
        Shape circle = new Circle(5.0);              // Круг с радиусом 5.0
        Shape square = new Square(4.0);                // Квадрат со стороной 4.0
        Shape triangle = new Triangle(3.0, 4.0, 5.0);    // Треугольник со сторонами 3.0, 4.0 и 5.0

        // Вывод результатов для круга
        System.out.println("Круг:");
        System.out.println("Площадь = " + circle.getArea());
        System.out.println("Периметр = " + circle.getPerimeter());

        // Вывод результатов для квадрата
        System.out.println("\nКвадрат:");
        System.out.println("Площадь = " + square.getArea());
        System.out.println("Периметр = " + square.getPerimeter());

        // Вывод результатов для треугольника
        System.out.println("\nТреугольник:");
        System.out.println("Площадь = " + triangle.getArea());
        System.out.println("Периметр = " + triangle.getPerimeter());
    }
}
