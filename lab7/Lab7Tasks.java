package lab7;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lab7Tasks {

    public static void main(String[] args) {
        System.out.println("=== Завдання 1: Predicate (просте число) ===");
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println("Чи є 7 простим? " + isPrime.test(7));
        System.out.println("Чи є 10 простим? " + isPrime.test(10));

        System.out.println("\n=== Завдання 2: Фільтрація масиву студентів (без боргів) ===");
        Student[] students = {
            new Student("Шевченко Тарас", "КН-21", new int[]{90, 85, 95}),
            new Student("Франко Іван", "КН-21", new int[]{50, 75, 80}), // має борг (50)
            new Student("Лисюк Марія", "УНІ-251", new int[]{100, 95, 98})
        };
        
        Predicate<Student> noDebts = s -> {
            for (int mark : s.getMarks()) {
                if (mark < 60) return false; // борг
            }
            return true;
        };
        Student[] successfulStudents = filterStudents(students, noDebts);
        for (Student s : successfulStudents) {
            System.out.println(s);
        }

        System.out.println("\n=== Завдання 3: Фільтрація за двома умовами ===");
        int[] numbers = {10, 15, 20, 25, 30, 35};
        // Умова: число більше 10 І ділиться на 10
        Predicate<Integer> greaterThanTen = n -> n > 10;
        Predicate<Integer> divisibleByTen = n -> n % 10 == 0;
        int[] filteredNumbers = filterByTwo(numbers, greaterThanTen, divisibleByTen);
        System.out.println(Arrays.toString(filteredNumbers));

        System.out.println("\n=== Завдання 4: Consumer (вивід ПРІЗВИЩЕ + ІМ'Я) ===");
        Consumer<Student> printName = s -> System.out.println(s.getName().toUpperCase());
        forEachStudent(students, printName);

        System.out.println("\n=== Завдання 5: Predicate + Consumer ===");
        int[] numsForTask5 = {1, 2, 3, 4, 5, 6};
        // Умова: парне число. Дія: помножити на 10 і вивести
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Consumer<Integer> multiplyAndPrint = n -> System.out.println("Результат: " + (n * 10));
        processIf(numsForTask5, isEven, multiplyAndPrint);

        System.out.println("\n=== Завдання 6: Function (2^n) ===");
        int[] powersArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);
        int[] powersResult = processPowers(powersArray, powerOfTwo);
        System.out.println(Arrays.toString(powersResult));

        System.out.println("\n=== Завдання 7: Stringify (числа у рядки) ===");
        int[] digits = {0, 1, 5, 9, 3, 8};
        Function<Integer, String> intToString = n -> {
            String[] words = {"нуль", "один", "два", "три", "чотири", "п'ять", "шість", "сім", "вісім", "дев'ять"};
            return (n >= 0 && n <= 9) ? words[n] : "невідомо";
        };
        String[] stringified = stringify(digits, intToString);
        System.out.println(Arrays.toString(stringified));
    }

    // Метод для Завдання 2
    public static Student[] filterStudents(Student[] input, Predicate<Student> p) {
        Student[] temp = new Student[input.length];
        int counter = 0;
        for (Student s : input) {
            if (p.test(s)) {
                temp[counter++] = s;
            }
        }
        return Arrays.copyOfRange(temp, 0, counter);
    }

    // Метод для Завдання 3
    public static int[] filterByTwo(int[] input, Predicate<Integer> p1, Predicate<Integer> p2) {
        int[] temp = new int[input.length];
        int counter = 0;
        for (int i : input) {
            if (p1.test(i) && p2.test(i)) {
                temp[counter++] = i;
            }
        }
        return Arrays.copyOfRange(temp, 0, counter);
    }

    // Метод для Завдання 4
    public static void forEachStudent(Student[] input, Consumer<Student> action) {
        for (Student s : input) {
            action.accept(s);
        }
    }

    // Метод для Завдання 5
    public static void processIf(int[] input, Predicate<Integer> p, Consumer<Integer> c) {
        for (int i : input) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
    }

    // Метод для Завдання 6
    public static int[] processPowers(int[] input, Function<Integer, Integer> f) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = f.apply(input[i]);
        }
        return result;
    }

    // Метод для Завдання 7
    public static String[] stringify(int[] input, Function<Integer, String> f) {
        String[] result = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = f.apply(input[i]);
        }
        return result;
    }
}