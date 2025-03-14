package lr2;

public class Example8 {
    public static void main(String[] args) {
        // Создаем объекты для каждого типа животного
        Dog dog = new Dog("Бобик", 3, "Лабрадор");
        Cat cat = new Cat("Мурка", 2, "Рыба");
        Bird bird = new Bird("Чик", 1, true);

        // Демонстрируем работу с объектом Dog
        System.out.println("=== Собака ===");
        System.out.println("Имя: " + dog.getName());
        System.out.println("Возраст: " + dog.getAge());
        System.out.println("Порода: " + dog.getBreed());
        dog.makeSound();

        // Демонстрируем работу с объектом Cat
        System.out.println("\n=== Кошка ===");
        System.out.println("Имя: " + cat.getName());
        System.out.println("Возраст: " + cat.getAge());
        System.out.println("Любимая еда: " + cat.getFavoriteFood());
        cat.makeSound();

        // Демонстрируем работу с объектом Bird
        System.out.println("\n=== Птица ===");
        System.out.println("Имя: " + bird.getName());
        System.out.println("Возраст: " + bird.getAge());
        System.out.println("Умеет летать: " + (bird.canFly() ? "Да" : "Нет"));
        bird.makeSound();
        bird.fly();
    }
}

// Базовый класс Animal, содержащий общие поля и методы для всех животных
class Animal {
    protected String name; // Имя животного
    protected int age;     // Возраст животного

    // Конструктор для инициализации имени и возраста
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Метод для издания звука (будет переопределен в подклассах)
    public void makeSound() {
        System.out.println("Животное издает звук.");
    }
}

// Подкласс Dog, наследующий класс Animal и добавляющий поле породы
class Dog extends Animal {
    private String breed; // Порода собаки

    // Конструктор для инициализации имени, возраста и породы
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    // Геттер для породы
    public String getBreed() {
        return breed;
    }

    // Переопределение метода издания звука для собаки
    @Override
    public void makeSound() {
        System.out.println("Собака гавкает: Гав-гав!");
    }
}

// Подкласс Cat, наследующий класс Animal и добавляющий поле любимой еды
class Cat extends Animal {
    private String favoriteFood; // Любимая еда кошки

    // Конструктор для инициализации имени, возраста и любимой еды
    public Cat(String name, int age, String favoriteFood) {
        super(name, age);
        this.favoriteFood = favoriteFood;
    }

    // Геттер для любимой еды
    public String getFavoriteFood() {
        return favoriteFood;
    }

    // Переопределение метода издания звука для кошки
    @Override
    public void makeSound() {
        System.out.println("Кошка мяукает: Мяу!");
    }
}

// Подкласс Bird, наследующий класс Animal и добавляющий возможность летать
class Bird extends Animal {
    private boolean canFly; // Способность летать

    // Конструктор для инициализации имени, возраста и возможности летать
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    // Геттер для проверки возможности полёта
    public boolean canFly() {
        return canFly;
    }

    // Переопределение метода издания звука для птицы
    @Override
    public void makeSound() {
        System.out.println("Птица чирикает: Чирик-чирик!");
    }

    // Уникальный метод для птицы, демонстрирующий полёт
    public void fly() {
        if (canFly) {
            System.out.println(name + " летит!");
        } else {
            System.out.println(name + " не умеет летать.");
        }
    }
}
