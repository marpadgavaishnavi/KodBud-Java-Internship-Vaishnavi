import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class UltimateConsoleCalculator {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> history = new ArrayList<>();
    static double memory = 0;

    public static void main(String[] 
    args) {
        int choice;

        do {
            System.out.println("\n===== ULTIMATE CONSOLE CALCULATOR =====");
            System.out.println("1. Basic Calculator");
            System.out.println("2. Scientific Calculator");
            System.out.println("3. Programmer Calculator");
            System.out.println("4. Statistics");
            System.out.println("5. Matrix Operations");
            System.out.println("6. Equation Solver");
            System.out.println("7. Unit Converter");
            System.out.println("8. Financial Calculator");
            System.out.println("9. View History");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> basicCalculator();
                case 2 -> scientificCalculator();
                case 3 -> programmerCalculator();
                case 4 -> statisticsCalculator();
                case 5 -> matrixCalculator();
                case 6 -> equationSolver();
                case 7 -> unitConverter();
                case 8 -> financialCalculator();
                case 9 -> showHistory();
                case 0 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    static void basicCalculator() {
        System.out.println("\n--- Basic Calculator ---");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Percentage");
        System.out.println("6. Square Root");
        System.out.println("7. Memory Add");
        System.out.println("8. Memory Recall");
        System.out.println("9. Memory Clear");
        System.out.print("Choose: ");

        int ch = sc.nextInt();
        double a, b, result;

        switch (ch) {
            case 1 -> {
                System.out.print("Enter two numbers: ");
                a = sc.nextDouble();
                b = sc.nextDouble();
                result = a + b;
                printResult(a + " + " + b, result);
            }
            case 2 -> {
                System.out.print("Enter two numbers: ");
                a = sc.nextDouble();
                b = sc.nextDouble();
                result = a - b;
                printResult(a + " - " + b, result);
            }
            case 3 -> {
                System.out.print("Enter two numbers: ");
                a = sc.nextDouble();
                b = sc.nextDouble();
                result = a * b;
                printResult(a + " * " + b, result);
            }
            case 4 -> {
                System.out.print("Enter two numbers: ");
                a = sc.nextDouble();
                b = sc.nextDouble();
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    result = a / b;
                    printResult(a + " / " + b, result);
                }
            }
            case 5 -> {
                System.out.print("Enter number: ");
                a = sc.nextDouble();
                result = a / 100;
                printResult(a + "%", result);
            }
            case 6 -> {
                System.out.print("Enter number: ");
                a = sc.nextDouble();
                result = Math.sqrt(a);
                printResult("sqrt(" + a + ")", result);
            }
            case 7 -> {
                System.out.print("Enter number to add to memory: ");
                memory += sc.nextDouble();
                System.out.println("Memory = " + memory);
            }
            case 8 -> System.out.println("Memory value = " + memory);
            case 9 -> {
                memory = 0;
                System.out.println("Memory cleared.");
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    static void scientificCalculator() {
        System.out.println("\n--- Scientific Calculator ---");
        System.out.println("1. sin");
        System.out.println("2. cos");
        System.out.println("3. tan");
        System.out.println("4. log10");
        System.out.println("5. natural log");
        System.out.println("6. power");
        System.out.println("7. square");
        System.out.println("8. cube");
        System.out.println("9. cube root");
        System.out.println("10. factorial");
        System.out.println("11. π value");
        System.out.println("12. e value");
        System.out.println("13. 10^x");
        System.out.println("14. e^x");
        System.out.print("Choose: ");

        int ch = sc.nextInt();
        double a, b, result;

        switch (ch) {
            case 1 -> {
                System.out.print("Enter angle in degrees: ");
                a = sc.nextDouble();
                result = Math.sin(Math.toRadians(a));
                printResult("sin(" + a + ")", result);
            }
            case 2 -> {
                System.out.print("Enter angle in degrees: ");
                a = sc.nextDouble();
                result = Math.cos(Math.toRadians(a));
                printResult("cos(" + a + ")", result);
            }
            case 3 -> {
                System.out.print("Enter angle in degrees: ");
                a = sc.nextDouble();
                result = Math.tan(Math.toRadians(a));
                printResult("tan(" + a + ")", result);
            }
            case 4 -> {
                System.out.print("Enter number: ");
                a = sc.nextDouble();
                result = Math.log10(a);
                printResult("log10(" + a + ")", result);
            }
            case 5 -> {
                System.out.print("Enter number: ");
                a = sc.nextDouble();
                result = Math.log(a);
                printResult("ln(" + a + ")", result);
            }
            case 6 -> {
                System.out.print("Enter base and power: ");
                a = sc.nextDouble();
                b = sc.nextDouble();
                result = Math.pow(a, b);
                printResult(a + "^" + b, result);
            }
            case 7 -> {
                System.out.print("Enter number: ");
                a = sc.nextDouble();
                result = a * a;
                printResult(a + "^2", result);
            }
            case 8 -> {
                System.out.print("Enter number: ");
                a = sc.nextDouble();
                result = a * a * a;
                printResult(a + "^3", result);
            }
            case 9 -> {
                System.out.print("Enter number: ");
                a = sc.nextDouble();
                result = Math.cbrt(a);
                printResult("cbrt(" + a + ")", result);
            }
            case 10 -> {
                System.out.print("Enter integer: ");
                int n = sc.nextInt();
                long fact = 1;
                for (int i = 1; i <= n; i++) fact *= i;
                System.out.println("Result = " + fact);
                history.add(n + "! = " + fact);
            }
            case 11 -> System.out.println("π = " + Math.PI);
            case 12 -> System.out.println("e = " + Math.E);
            case 13 -> {
                System.out.print("Enter x: ");
                a = sc.nextDouble();
                result = Math.pow(10, a);
                printResult("10^" + a, result);
            }
            case 14 -> {
                System.out.print("Enter x: ");
                a = sc.nextDouble();
                result = Math.exp(a);
                printResult("e^" + a, result);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    static void programmerCalculator() {
        System.out.println("\n--- Programmer Calculator ---");
        System.out.println("1. Decimal to Binary/Octal/Hex");
        System.out.println("2. Bitwise AND");
        System.out.println("3. Bitwise OR");
        System.out.println("4. Bitwise XOR");
        System.out.println("5. Left Shift");
        System.out.println("6. Right Shift");
        System.out.print("Choose: ");

        int ch = sc.nextInt();
        int a, b;

        switch (ch) {
            case 1 -> {
                System.out.print("Enter decimal number: ");
                a = sc.nextInt();
                System.out.println("Binary = " + Integer.toBinaryString(a));
                System.out.println("Octal = " + Integer.toOctalString(a));
                System.out.println("Hex = " + Integer.toHexString(a).toUpperCase());
            }
            case 2 -> {
                System.out.print("Enter two integers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println("Result = " + (a & b));
            }
            case 3 -> {
                System.out.print("Enter two integers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println("Result = " + (a | b));
            }
            case 4 -> {
                System.out.print("Enter two integers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println("Result = " + (a ^ b));
            }
            case 5 -> {
                System.out.print("Enter number and shift value: ");
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println("Result = " + (a << b));
            }
            case 6 -> {
                System.out.print("Enter number and shift value: ");
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println("Result = " + (a >> b));
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    static void statisticsCalculator() {
        System.out.print("How many numbers? ");
        int n = sc.nextInt();

        double[] arr = new double[n];
        double sum = 0, min = Double.MAX_VALUE, max = Double.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
            sum += arr[i];
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        double mean = sum / n;
        double variance = 0;

        for (double x : arr) {
            variance += Math.pow(x - mean, 2);
        }

        variance /= n;

        System.out.println("Mean = " + mean);
        System.out.println("Variance = " + variance);
        System.out.println("Standard Deviation = " + Math.sqrt(variance));
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

    static void matrixCalculator() {
        System.out.println("\n--- 2x2 Matrix Determinant ---");

        double[][] m = new double[2][2];

        System.out.println("Enter 2x2 matrix values:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = sc.nextDouble();
            }
        }

        double determinant = (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
        System.out.println("Determinant = " + determinant);
    }

    static void equationSolver() {
        System.out.println("\n--- Quadratic Equation Solver ---");
        System.out.println("Equation: ax² + bx + c = 0");

        System.out.print("Enter a: ");
        double a = sc.nextDouble();

        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        double d = b * b - 4 * a * c;

        if (d > 0) {
            double r1 = (-b + Math.sqrt(d)) / (2 * a);
            double r2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Roots = " + r1 + " and " + r2);
        } else if (d == 0) {
            double r = -b / (2 * a);
            System.out.println("Root = " + r);
        } else {
            System.out.println("No real roots.");
        }
    }

    static void unitConverter() {
        System.out.println("\n--- Unit Converter ---");
        System.out.println("1. Length meter to kilometer");
        System.out.println("2. Temperature Celsius to Fahrenheit");
        System.out.println("3. Mass kg to grams");
        System.out.println("4. Area square meter to square feet");
        System.out.println("5. Time hours to minutes");
        System.out.println("6. Data MB to GB");
        System.out.println("7. Discount Calculator");
        System.out.println("8. Volume liter to milliliter");
        System.out.println("9. Speed km/h to m/s");
        System.out.println("10. Date Difference");
        System.out.print("Choose: ");

        int ch = sc.nextInt();
        double value, result;

        switch (ch) {
            case 1 -> {
                System.out.print("Enter meters: ");
                value = sc.nextDouble();
                result = value / 1000;
                System.out.println("Kilometers = " + result);
            }
            case 2 -> {
                System.out.print("Enter Celsius: ");
                value = sc.nextDouble();
                result = (value * 9 / 5) + 32;
                System.out.println("Fahrenheit = " + result);
            }
            case 3 -> {
                System.out.print("Enter kg: ");
                value = sc.nextDouble();
                result = value * 1000;
                System.out.println("Grams = " + result);
            }
            case 4 -> {
                System.out.print("Enter square meters: ");
                value = sc.nextDouble();
                result = value * 10.7639;
                System.out.println("Square feet = " + result);
            }
            case 5 -> {
                System.out.print("Enter hours: ");
                value = sc.nextDouble();
                result = value * 60;
                System.out.println("Minutes = " + result);
            }
            case 6 -> {
                System.out.print("Enter MB: ");
                value = sc.nextDouble();
                result = value / 1024;
                System.out.println("GB = " + result);
            }
            case 7 -> {
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter discount percentage: ");
                double discount = sc.nextDouble();
                result = price - (price * discount / 100);
                System.out.println("Final price = " + result);
            }
            case 8 -> {
                System.out.print("Enter liters: ");
                value = sc.nextDouble();
                result = value * 1000;
                System.out.println("Milliliters = " + result);
            }
            case 9 -> {
                System.out.print("Enter km/h: ");
                value = sc.nextDouble();
                result = value * 5 / 18;
                System.out.println("m/s = " + result);
            }
            case 10 -> {
                sc.nextLine();
                System.out.print("Enter first date yyyy-mm-dd: ");
                LocalDate d1 = LocalDate.parse(sc.nextLine());
                System.out.print("Enter second date yyyy-mm-dd: ");
                LocalDate d2 = LocalDate.parse(sc.nextLine());
                long days = ChronoUnit.DAYS.between(d1, d2);
                System.out.println("Difference = " + Math.abs(days) + " days");
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    static void financialCalculator() {
        System.out.println("\n--- Financial Calculator ---");
        System.out.println("1. Simple Interest");
        System.out.println("2. Compound Interest");
        System.out.println("3. EMI Calculator");
        System.out.print("Choose: ");

        int ch = sc.nextInt();

        switch (ch) {
            case 1 -> {
                System.out.print("Enter principal, rate, time: ");
                double p = sc.nextDouble();
                double r = sc.nextDouble();
                double t = sc.nextDouble();
                double si = (p * r * t) / 100;
                System.out.println("Simple Interest = " + si);
            }
            case 2 -> {
                System.out.print("Enter principal, rate, time: ");
                double p = sc.nextDouble();
                double r = sc.nextDouble();
                double t = sc.nextDouble();

                double amount = p * Math.pow((1 + r / 100), t);
                System.out.println("Compound Amount = " + amount);
                System.out.println("Compound Interest = " + (amount - p));
            }
            case 3 -> {
                System.out.print("Enter loan amount: ");
                double p = sc.nextDouble();

                System.out.print("Enter annual interest rate: ");
                double annualRate = sc.nextDouble();

                System.out.print("Enter time in months: ");
                double months = sc.nextDouble();

                double monthlyRate = annualRate / (12 * 100);
                double emi = (p * monthlyRate * Math.pow(1 + monthlyRate, months))
                        / (Math.pow(1 + monthlyRate, months) - 1);

                System.out.println("Monthly EMI = " + emi);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

   static void printResult(String expression, double result) {
    result = Math.round(result * 1000000.0) / 1000000.0;
    System.out.println("Result = " + result);
    history.add(expression + " = " + result);
}

    static void showHistory() {
        System.out.println("\n--- History ---");

        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            for (String h : history) {
                System.out.println(h);
            }
        }
    }
}