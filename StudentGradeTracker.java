import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CodeAlpha Java Internship - Task 1: Student Grade Tracker
 *
 * Console-based program that:
 *  - Inputs and manages student grades
 *  - Calculates average, highest, and lowest scores
 *  - Uses an ArrayList to store and manage data
 *  - Displays a summary report of all students
 */
public class StudentGradeTracker {

    // Simple data holder for a student and their grade
    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.run();
    }

    public void run() {
        System.out.println("==========================================");
        System.out.println("      STUDENT GRADE TRACKER ");
        System.out.println("==========================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readIntChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    showSummaryReport();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.\n");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n------------------------------------------");
        System.out.println("1. Add Student Grade");
        System.out.println("2. View All Students");
        System.out.println("3. Show Summary Report (Avg/High/Low)");
        System.out.println("4. Delete a Student Record");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int readIntChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number (1-5): ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty. Student not added.");
            return;
        }

        double grade = -1;
        while (true) {
            System.out.print("Enter grade for " + name + " (0-100): ");
            try {
                grade = Double.parseDouble(scanner.nextLine().trim());
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100. Try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a numeric grade.");
            }
        }

        students.add(new Student(name, grade));
        System.out.println("Added: " + name + " -> " + grade);
    }

    private void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found. Add some first!");
            return;
        }

        System.out.println("\n----- ALL STUDENT RECORDS -----");
        System.out.printf("%-5s %-20s %-10s%n", "No.", "Name", "Grade");
        System.out.println("--------------------------------");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%-5d %-20s %-10.2f%n", (i + 1), s.name, s.grade);
        }
    }

    private void showSummaryReport() {
        if (students.isEmpty()) {
            System.out.println("No student records found. Add some first!");
            return;
        }

        double sum = 0;
        Student highest = students.get(0);
        Student lowest = students.get(0);

        for (Student s : students) {
            sum += s.grade;
            if (s.grade > highest.grade) {
                highest = s;
            }
            if (s.grade < lowest.grade) {
                lowest = s;
            }
        }

        double average = sum / students.size();

        System.out.println("\n========== SUMMARY REPORT ==========");
        System.out.println("Total Students : " + students.size());
        System.out.printf("Average Score  : %.2f%n", average);
        System.out.printf("Highest Score  : %.2f (%s)%n", highest.grade, highest.name);
        System.out.printf("Lowest Score   : %.2f (%s)%n", lowest.grade, lowest.name);
        System.out.println("=====================================");

        // Also show the full list alongside the summary
        viewAllStudents();
    }

    private void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No student records to delete.");
            return;
        }

        viewAllStudents();
        System.out.print("Enter the record number to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (index < 0 || index >= students.size()) {
                System.out.println("Invalid record number.");
                return;
            }
            Student removed = students.remove(index);
            System.out.println("Deleted record for: " + removed.name);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid record number.");
        }
    }
}