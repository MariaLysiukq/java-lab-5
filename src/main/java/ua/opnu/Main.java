package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[3];        
        people[0] = new Person("Лисюк", "Лор", 45);
        people[1] = new Student("Лисюк", "Марія", 19, "упі-251", "KB123456");
        people[2] = new Lecturer("Микола", "Годовиченко", 35, "ООП", 25000);
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
