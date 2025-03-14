package lr2;

// Класс Example7 содержит метод main, демонстрирующий работу с банковскими счетами.
public class Example7 {
    public static void main(String[] args) {
        // Создаем два банковских счета с заданными номерами и начальными балансами
        BankAccount account1 = new BankAccount("ACC123", 1000);
        BankAccount account2 = new BankAccount("ACC456", 500);

        // Выполняем операции: депозит и снятие средств для первого счета
        account1.deposit(200);
        account1.withdraw(150);

        // Выполняем операции для второго счета
        account2.deposit(300);
        account2.withdraw(1000); // Пытаемся снять сумму, которая может быть больше баланса

        // Выводим номера счетов и их текущие балансы
        System.out.println(account1.getAccountNumber() + " баланс: " + account1.getBalance());
        System.out.println(account2.getAccountNumber() + " баланс: " + account2.getBalance());
    }
}

// Интерфейс AccountOperations определяет основные операции для работы с банковским счетом
interface AccountOperations {
    // Метод для внесения депозита
    void deposit(double amount);
    // Метод для снятия средств
    void withdraw(double amount);
    // Метод для получения текущего баланса
    double getBalance();
}

// Класс BankAccount реализует интерфейс AccountOperations и представляет банковский счет
class BankAccount implements AccountOperations {
    private String accountNumber; // Номер счета
    private double balance;       // Текущий баланс счета

    // Конструктор создает банковский счет с заданным номером и начальными средствами.
    // Если начальный баланс меньше 0, он устанавливается в 0.
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, 0);
    }

    // Метод для получения номера счета
    public String getAccountNumber() {
        return accountNumber;
    }

    // Метод для внесения депозита; сумма должна быть положительной
    @Override
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    // Метод для снятия средств; проверяем, что сумма положительная и не превышает баланс
    @Override
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Метод для получения текущего баланса
    @Override
    public double getBalance() {
        return balance;
    }
}
