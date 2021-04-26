package java8;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


public class Homework4 {

    static int a;
    static int b;
    static String s;

    public static void main(String[] args) {
        // @FunctionalInterface, lambda, method reference
        task1();
        task2();
        task3();
        task4(); // stream API
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        // stream API
        task12();
        task13();
        task14();
    }

    private static void task1() {
        System.out.println("Task 1: ");
        /*
        Выведите на экран значение name, используя метод System.out.println(k); (должно вывести John).
         */
        String name = "John";
        // @FunctionalInterface Consumer
        Consumer<String> printer = x -> System.out.printf("String name = %s \n", x);
        printer.accept(name);
    }

    private static void task2() {
        System.out.println("\nTask 2: ");
        /*
        Написать лямбда выражение для интерфейса Printable, который содержит один метод void print()
         */
        s = "Print using @FunctionalInterface Printable";
        // @FunctionalInterface Printable
        // Method reference
        Printable<String> printer = System.out::println;
        printer.print(s);
    }

    private static void task3() {
        System.out.println("\nTask 3: ");
        /*
        Написать программу, которая выводит на экран разницу двух чисел.
        */
        a = 777;
        b = 333;
        // @FunctionalInterface IntBinaryOperator
        IntBinaryOperator operation = (x, y) -> x - y;
        int result = operation.applyAsInt(a, b);

        System.out.println(a + " - " + b + " = " + result + "\n");
    }

    private static void task4() {
        System.out.println("Task 4: ");
        /*
        Написать программу, которая находит и выводит на экран максимальное из трех чисел.
        */
        List<Integer> nums = Arrays.asList(5, 55, 555);
        // stream API
        OptionalInt maxNum = nums.stream().mapToInt(v -> v).max();
        System.out.println("Max value in numbers: " + maxNum.getAsInt() + "\n");
    }

    private static void task5() {
        System.out.println("\nTask5 : ");
        /*
        Создать лямбда выражение, которое возвращает значение true, если строка не null,
        используя функциональный интерфейс Predicate.
         */
        s = "String not null";
        Predicate<String> notNull = Objects::nonNull;
        System.out.println(notNull.test(s));
    }

    private static void task6() {
        System.out.println("\nTask 6: ");
        /*
        Написать программу проверяющую, что строка не null и не пуста,
        используя метод and() функционального интерфейса Predicate
         */
        s = "String not null, not empty";
        Predicate<String> notNull = Objects::nonNull;
        Predicate<String> notEmpty = x -> !x.equals("");
        if (notNull.and(notEmpty).test(s)) {
            System.out.println(s);
        }
    }

    private static void task7() {
        System.out.println("\nTask 7 : ");
        /*
        Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается “A”.
        Используем функциональный интерфейс Predicate.
         */
        s = "";
        Predicate<String> start = x -> x.startsWith("J");
        Predicate<String> start2 = x -> x.startsWith("N");
        Predicate<String> end = x -> x.endsWith("A");
        System.out.println(start.or(start2).and(end).test(s));
    }

    private static void task8() {
        System.out.println("\nTask 8: ");
        /*
        Написать программу, которая проверяет, является ли число четным или нечетным.
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num;
        // @FunctionalInterface IntUnaryOperator
        IntUnaryOperator operation = x -> x % 2;

        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (operation.applyAsInt(num) == 0) {
                System.out.println("You entered an even number: " + num + "\n");
            } else {
                System.out.println("You entered an odd number: " + num + "\n");
            }
        } else {
            System.out.println("You made a mistake entering an integer. Try again.");
            scanner.next();
            task8();
        }
    }

    private static void task9() {
        System.out.println("\nTask 9: ");
        /*
        Вывести на экран таблицу умножения на 7.
        Пример вывода на экран:
        7 * 1 = 7
        7 * 2 = 14
        и т.д.
        */

        int i = 7;
        for (int j = 1; j <= 10; j++) {
            // @FunctionalInterface IntBinaryOperator
            IntBinaryOperator operation = (x, y) -> x * y;
            int result = operation.applyAsInt(i, j);
            System.out.println(i + " * " + j + " = " + result);
        }
    }

    private static void task10() {
        System.out.println("\nTask 10: ");
        /*
        Написать лямбда выражение, которое принимает на вход объект типа HeavyBox и выводит на консоль сообщение
        “Отгрузили ящик с весом n”. “Отправляем ящик с весом n”
        Используем функциональный интерфейс Consumer и метод по умолчанию andThen.
         */
        Consumer<HeavyBox> shipped = x -> System.out.printf("Отгрузили ящик с весом %dт.", x.getWeight());
        Consumer<HeavyBox> sent = x -> System.out.printf("Отправили ящик с весом %dт. ", x.getWeight());

        shipped.andThen(sent).accept(new HeavyBox(10));

    }

    private static void task11() {
        System.out.println("\nTask 11: ");
        /*
        Написать лямбда выражение, которое принимает на вход число и возвращает значение “Положительное число”,
        “Отрицательное число” или  “Ноль”. Используем функциональный интерфейс Function.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");

        int num;
        String positive = " is positive number";
        String negative = " is negative number";
        String zero = " - zero";
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isNegative = x -> x < 0;
        Function<Integer, String> convert = String::valueOf;

        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (isPositive.test(num)) {
                System.out.println(convert.apply(num) + positive);
            } else if (isNegative.test(num)) {
                System.out.println(convert.apply(num) + negative);
            } else {
                System.out.println(convert.apply(num) + zero);
            }
        } else {
            System.out.println("You made a mistake entering an integer. Try again.");
            scanner.next();
            task11();
        }

    }

    private static void task12() {
        System.out.println("\nTask 12: ");
        /*
        Создать коллекцию с целыми числами, создать из нее стрим, отфильтровать только нечетные числа,
        отсортировать по возрастанию, выбрать только неповторяющиеся значения и вернуть новый ArrayList
         */

        List<Integer> nums = Arrays.asList(500, 15, 55, 20, 555, 10, 7, 20, 70, 500);
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        ArrayList<Integer> oddNums = nums.stream().filter(oddPredicate).sorted().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(oddNums);
    }

    private static void task13() {
        System.out.println("\nTask 13: ");
        /*
        Создать коллекцию со строками, сделать из нее стрим, отфильтровать все строки, начинающиеся, например,
        с буквы “А”, преобразовать все строки в Upper-case и вывести значения на экран.
         */
        List<String> solarSystem = Arrays.asList("mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune");
        solarSystem.stream().filter(x -> x.startsWith("m")).map(String::toUpperCase).forEach(System.out::println);

    }

    private static void task14() {
        System.out.println("\nTask 14: ");
        /*
        Создать массив стрингов, образовать из него стрим, найти первый элемент, который равен какому-либо значению
        (это значение может быть в массиве, а может и не быть - на ваше усмотрение).
        Если значение не найдено -  вернуть строку “No such element exception”;
         */
        String[] array = {"Java", "Python", "C++"};
        Optional<String> optional = Arrays.stream(array).filter(Predicate.isEqual("C++")).findFirst();
        System.out.println(optional.orElse("No such element exception"));
    }
}