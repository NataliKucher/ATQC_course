package basics;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        System.out.println("Enter an integer: ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("You made a mistake entering an integer. Try again.");
            scanner.next();
            return getInt(); //рекурсия
        }
    }

    public static char getOperation() {
        System.out.println("Enter the operation: (+, -, / or *)");
        if (scanner.hasNext()) {
            return scanner.next().charAt(0);
        } else {
            System.out.println("You made a mistake entering the operation. Try again.");
            scanner.next();
            return getOperation(); //рекурсия
        }
    }

    public static double calc(int num1, int num2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = (double) num1 / num2;
                break;
            default:
                System.out.println("Operation not recognized. Please try again.");
                result = calc(num1, num2, getOperation()); //рекурсия
        }
        return result;
    }
}
