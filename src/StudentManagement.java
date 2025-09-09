import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagement system = new StudentManagement();
        system.run();
    }

    public void run() {
        loadFromFile();
        while(true) {
            System.out.println("\n-- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Add grade to Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // clearing the input buffer

            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    findStudentById();
                    break;
                case 4:
                    addGradeToStudent();
                    break;
                case 5:
                    saveToFile();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try Again");
            }
        }
    }

    private void addStudent() {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // Clearing the buffer
        students.add(new Student(name, id));

        System.out.println("Student added successfully!");
    }

    public void viewAllStudents() {
        if(students.isEmpty()) {
            System.out.println("No students to display");
        } else {
            System.out.println("\n--- All Students ---");
            for(Student s: students) {
                System.out.println(s);
            }
        }
    }

    private void findStudentById() {
        System.out.print("Enter the student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clearing the input buffer

        for(Student s: students) {
            if(s.getId() == id) {
                System.out.println("Found " + s);
                return;
            }
        }

        System.out.println("Student with ID: " + id + " not found");
    }
    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
            System.out.println("Student data saved to file");
        } catch(IOException e) {
            System.out.println("Error saving " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"))) {
            students = (ArrayList<Student>) in.readObject();
            System.out.println("Student data loaded from file");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading " + e.getMessage());
        }
    }

    private void addGradeToStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter subject: ");
                String subject = scanner.nextLine();
                System.out.print("Enter grade (0-100): ");
                int grade = scanner.nextInt();
                scanner.nextLine();
                s.addGrade(subject, grade);
                return;
            }
        }
        System.out.println("Student not found.");
    }









}
