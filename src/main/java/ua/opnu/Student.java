package ua.opnu;

public class Student extends Person {
    private String group;
    private String studentId;
    private double averageGrade;

    public Student(String lastName, String firstName, int age, String group, String studentId, double averageGrade) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentId = studentId;
        this.averageGrade = averageGrade;
    }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public double getAverageGrade() { return averageGrade; }
    public void setAverageGrade(double averageGrade) { this.averageGrade = averageGrade; }

    @Override
    public String toString() {
        return "Студент " + getLastName() + " " + getFirstName() + " (група " + group + "), Сер. бал: " + averageGrade;
    }
}