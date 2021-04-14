package basics;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        calculator();
    }

    private static void task1() {
        System.out.println("Task 1: ");
        /*
        Объявите две переменные типа String: admin и name.
        Запишите строку "John" в переменную name.
        Скопируйте значение из переменной name в admin.
        Выведите на экран значение admin, используя метод System.out.println(k); (должно вывести John).
        */
        String admin;
        String name;
        name = "John";
        admin = name;
        System.out.println("String admin = " + admin + "\n");
    }

    private static void task2() {
        System.out.println("Task 2: ");
        /*
        Написать программу, которая выводит на экран разницу двух чисел.
        */
        int a = 777;
        int b = 333;
        int result = a - b;
        System.out.println(a + " - " + b + " = " + result + "\n");
    }

    private static void task3() {
        System.out.println("Task 3: ");
        /*
        Написать программу, которая находит и выводит на экран максимальное из трех чисел.
        */
        int[] numbers = new int[3];
        numbers[0] = 5;
        numbers[1] = 555;
        numbers[2] = 55;

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
        }
        System.out.println("Max value in numbers: " + max + "\n");
    }

    private static void task4() {
        System.out.println("Task 4: ");
        /*
        Написать программу, которая проверяет, является ли число четным или нечетным.
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (num % 2 == 0) {
                System.out.println("You entered an even number: " + num + "\n");
            } else {
                System.out.println("You entered an odd number: " + num + "\n");
            }
        } else {
            System.out.println("You made a mistake entering an integer. Try again.");
            scanner.next();
            task4(); //рекурсия
        }
    }

    private static void task5() {
        System.out.println("Task 5: ");
        /*
        Вывести на экран числа от 5 до 1.
        */
        int decrement = 5;
        while (decrement > 0) {
            System.out.println(decrement--);
        }
    }

    private static void task6() {
        System.out.println("\nTask 6: ");
        /*
        Вывести на экран таблицу умножения на 7.
        Пример вывода на экран:
        7 * 1 = 7
        7 * 2 = 14
        и т.д.
        */
        int i = 7;
        for (int j = 1; j <= 10; j++) {
            System.out.println(i + " * " + j + " = " + (i * j));
        }
    }

    private static void task7() {
        System.out.println("\nTask 7: ");
        /*
        Напишите программу, которая выводит на экран сумму всех чисел массива.
        */
        int[] numbers = new int[10];
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int a = 100;
            numbers[i] = (int) (Math.random() * a);
        }
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Array sum = " + sum);
    }

    private static void calculator() {
        System.out.println("\n  Calculator ");
        /*
        Задача со звездочкой:
        Написать программу-калькулятор, которая производит сложение, вычитание, умножение и деление двух чисел.
        */
        int num1 = Calculator.getInt();
        int num2 = Calculator.getInt();
        char operation = Calculator.getOperation();
        double result = Calculator.calc(num1, num2, operation);
        System.out.println("The result of the operation: " + result);
    }
}