package ua.opnu;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class GradeSorter implements Comparator {
    private boolean ascending;

    public GradeSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            int result = Double.compare(s1.getAverageGrade(), s2.getAverageGrade());
            return ascending ? result : -result;
        }
        return 0;
    }
}