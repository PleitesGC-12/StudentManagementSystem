import java.util.Date;

public class Student implements java.io.Serializable {
    private String name;
    private int id;

    // 🔥 NEW: This field is NOT serializable and has no default value
    private Date enrollmentDate;  // Problem: no default, breaks deserialization!

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.enrollmentDate = new Date(); // set at creation
    }

    // Getters...
    public String getName() { return name; }
    public int getId() { return id; }
    public Date getEnrollmentDate() { return enrollmentDate; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Enrolled: " + enrollmentDate;
    }
}