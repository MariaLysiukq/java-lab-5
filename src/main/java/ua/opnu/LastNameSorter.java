package ua.opnu;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class LastNameSorter implements Comparator {
    private boolean ascending;

    public LastNameSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            int result = s1.getLastName().compareTo(s2.getLastName());
            return ascending ? result : -result; // Реверс для додаткових балів
        }
        return 0;
    }
}