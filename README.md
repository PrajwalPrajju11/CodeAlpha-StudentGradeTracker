# CodeAlpha_StudentGradeTracker

A console-based Java application that inputs and manages student grades, built for the **CodeAlpha Java Programming Internship (Task 1)**.

## Features

- Add student names and grades (validated to be between 0 and 100)
- View all student records in a formatted table
- Calculate **average**, **highest**, and **lowest** scores
- Display a **summary report** of all students
- Delete a student record
- Input validation for invalid numbers, empty names, and out-of-range grades

## Concepts Used

- Java `ArrayList` for storing and managing data
- Object-oriented programming (`Student` class)
- `Scanner` for console input
- Loops, conditionals, and exception handling

## How to Run

Make sure Java (JDK 8 or higher) is installed.

```bash
javac StudentGradeTracker.java
java StudentGradeTracker
```

## Menu Options

| Option | Action |
|--------|--------|
| 1 | Add Student Grade |
| 2 | View All Students |
| 3 | Show Summary Report (Avg/High/Low) |
| 4 | Delete a Student Record |
| 5 | Exit |

## Sample Output

```
==========================================
      STUDENT GRADE TRACKER - CodeAlpha
==========================================

------------------------------------------
1. Add Student Grade
2. View All Students
3. Show Summary Report (Avg/High/Low)
4. Delete a Student Record
5. Exit
Enter your choice: 1
Enter student name: Alice
Enter grade for Alice (0-100): 88
Added: Alice -> 88.0

Enter your choice: 3

========== SUMMARY REPORT ==========
Total Students : 3
Average Score  : 85.00
Highest Score  : 95.00 (Charlie)
Lowest Score   : 72.00 (Bob)
=====================================

----- ALL STUDENT RECORDS -----
No.   Name                 Grade
--------------------------------
1     Alice                88.00
2     Bob                  72.00
3     Charlie              95.00
```

## Author

Built as part of the CodeAlpha Java Programming Internship.
