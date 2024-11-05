package unit09.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class that represents a student with a first and last na
 */
public class Student {
    /**
     * The student's first name.
     */
    private final String firstName;

    /**
     * The student's last name.
     */
    private final String lastName;

    /**
     * Creates a new student.
     * 
     * @param firstName The new student's first name.
     * @param lastName The new student's last name.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + this.lastName + ", " + this.firstName + "}";
    }

    public static int compareByFirstName(Student a, Student b){
        return a.getFirstName().compareTo(b.getFirstName());
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alan", "White"));
        students.add(new Student("Jon", "Anderson"));
        students.add(new Student("Rick", "Wakeman"));
        students.add(new Student("Steve", "Howe"));
        students.add(new Student("Chris", "Squire"));

        System.out.println("\nstudents as entered:");
        System.out.println(students);

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a , Student b){
                return a.getLastName().compareTo(b.getLastName());
            }
        });

        
        System.out.println("\nstudents sorted by last name: ");
        System.out.println(students);
        
        System.out.println("\nstudents sorted by last name descending: ");
        students.sort((Student a,Student b) -> b.getLastName().compareTo(a.getLastName()));
        System.out.println(students);

        students.sort((a,b)-> b.getFirstName().compareTo(a.getFirstName()));
        System.out.println("\nstudents sorted by first name descending: ");
        System.out.println(students);

        students.sort(Student::compareByFirstName);
        System.out.println("\nstudents sorted by first name: ");
        System.out.println(students);

        //streams
        System.out.println("\nstreamed student list:");
        students.stream().forEach(s -> 
        System.out.println(s.getFirstName() + " " + s.getLastName()));

        System.out.println("\nstreamed students with 'r' in their names:");
        students.stream().filter(s ->s.toString().toLowerCase().contains("r"))
        .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

        System.out.println();


    }
}
