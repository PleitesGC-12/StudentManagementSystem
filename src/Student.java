import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Student implements java.io.Serializable {

    private String name;
    private int id;
    private Map <String, Integer> grades; // New field

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>(); // Initialize
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Map <String, Integer> getGrades() {
        return grades;
    }

    // Method to add a grade
    public void addGrade(String subject, int grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade: " + grade);
            return;
        }
        grades.put(subject,grade);
        System.out.println("Grade added: " + subject + " -> " + grade);
    }

    @Override
    public String toString() {
        return "ID: " + id + " , Name: " + name;
    }
}
