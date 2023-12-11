import java.util.List;

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = createSampleStudents();

        // Display all students
        System.out.println("All Students:");
        students.forEach(Student::displayStudentDetails);

        // Find and display students enrolled in "Computer Science"
        String targetCourse = "Computer Science";
        System.out.println("Students enrolled in " + targetCourse + ":");
        filterAndDisplayStudents(students, targetCourse);

        // Update the age of a specific student (e.g., Bob)
        String targetStudentID = "S002";
        int newAge = 23;
        updateStudentAge(students, targetStudentID, newAge);

        // Display all students after the update
        System.out.println("All Students after age update:");
        students.forEach(Student::displayStudentDetails);

        // Calculate and display the average age of all students
        double averageAge = calculateAverageAge(students);
        System.out.println("Average Age of all students: " + averageAge);
    }

    private static List<Student> createSampleStudents() {
        return List.of(
                new Student("S001", "Alice", 20),
                new Student("S002", "Bob", 22),
                new Student("S003", "Charlie", 21)
        );
    }

    private static void filterAndDisplayStudents(List<Student> students, String course) {
        students.stream()
                .filter(student -> student.getCourses().contains(course))
                .forEach(Student::displayStudentDetails);
    }

    private static void updateStudentAge(List<Student> students, String studentID, int newAge) {
        students.stream()
                .filter(student -> student.getStudentID().equals(studentID))
                .findFirst()
                .ifPresent(student -> student.setAge(newAge));
    }

    private static double calculateAverageAge(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }
}
