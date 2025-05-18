import java.util.Scanner;
public class Main{
    public static void main(String[] agrs){
        // обявление
        Scanner scanner = new Scanner(System.in);
        String string;
        String[] parts;

        while (true){
            // ввод в массив
            System.out.println("Введите выражения типа 2 + 3");
            string = scanner.nextLine();
            parts = string.split(" ");

            try {
                // Проверка формата ввода
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Неверный формат ввода. Используйте формат 'a + b'");
                }

                // Парсинг чисел
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[2]);
                String operator = parts[1];

                // Проверка диапазона чисел
                if (a < 1 || a > 10 || b < 1 || b > 10) {
                    throw new IllegalArgumentException("Числа должны быть от 1 до 10");
                }

                // Вычисление результата
                int result;
                switch (operator) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("Деление на ноль");
                        }
                        result = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("Неверная операция. Допустимы +, -, *, /");
                }

                System.out.println("Результат: " + result);

            } catch (NumberFormatException e) {
                System.err.println("Ошибка: введены не целые числа");
                System.exit(1);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.err.println("Ошибка: " + e.getMessage());
                System.exit(1);
            }

            // Очистка
            string = "";
            parts = new String[0];
        }
    }
}