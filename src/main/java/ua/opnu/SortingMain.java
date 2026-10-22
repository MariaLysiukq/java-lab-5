package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class SortingMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Лисюк", "Марія", 19, "уні-251", "KB123456", 95.0));
        students.add(new Student("Шевченко", "Тарас", 20, "КН-21", "ST101", 91.5));
        students.add(new Student("Франко", "Іван", 21, "КН-21", "ST102", 88.0));

        System.out.println("Початковий список");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nСортування за прізвищем (пряме)");
        students.sort(new LastNameSorter(true));
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nСортування за прізвищем (зворотне)");
        students.sort(new LastNameSorter(false));
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nСортування за середнім балом (за зростанням)");
        students.sort(new GradeSorter(true));
        for (Student s : students) {
            System.out.println(s);
        }
    }
}