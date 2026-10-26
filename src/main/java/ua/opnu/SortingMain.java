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
        students.forEach(System.out::println);

        System.out.println("\nСортування за прізвищем (пряме)");
        students.sort((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
        students.forEach(System.out::println);

        System.out.println("\nСортування за прізвищем (зворотне)");
        students.sort((s1, s2) -> s2.getLastName().compareTo(s1.getLastName()));
        students.forEach(System.out::println);

        System.out.println("\nСортування за середнім балом (за зростанням)");
        students.sort((s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
        students.forEach(System.out::println);
    }
}