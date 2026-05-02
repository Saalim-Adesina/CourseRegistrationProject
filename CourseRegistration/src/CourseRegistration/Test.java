package CourseRegistration;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeHashTable table = null;

        // Load existing data from file
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"));
            table = (TreeHashTable) in.readObject();
            in.close();
            System.out.println("Data loaded successfully.");
        } catch (Exception e) {
            System.out.println("No existing data found. Starting fresh.");
            table = new TreeHashTable(10);
        }

        int choice = 0;
        while (choice != 7) {
            System.out.println("\n1- Add a new course.");
            System.out.println("2- Add a student to a course.");
            System.out.println("3- Drop a student from a course.");
            System.out.println("4- Raise course's capacity.");
            System.out.println("5- Display students in a course.");
            System.out.println("6- Display student's courses.");
            System.out.println("7- Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter CRN: ");
                        int CRN = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter course name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Enter capacity: ");
                        int capacity = scanner.nextInt();
                        scanner.nextLine();
                        Course course = new Course(CRN, cName, capacity);
                        table.addCourse(course);
                        System.out.println("Course added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter CRN: ");
                        int crn2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        int sid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String sname = scanner.nextLine();
                        Student student = new Student(sid, sname);
                        table.addStudent(crn2, student);
                        System.out.println("Student added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter CRN: ");
                        int crn3 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        int sid3 = scanner.nextInt();
                        scanner.nextLine();
                        table.dropStudent(crn3, sid3);
                        System.out.println("Student dropped successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter CRN: ");
                        int crn4 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter capacity increase: ");
                        int r = scanner.nextInt();
                        scanner.nextLine();
                        table.raiseCapacity(crn4, r);
                        System.out.println("Capacity raised successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter CRN: ");
                        int crn5 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enrolled students:");
                        table.printStudents(crn5);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Enter student ID: ");
                        int sid6 = scanner.nextInt();
                        scanner.nextLine();
                        Course[] courses = table.studentEnrolled(sid6);
                        System.out.println("Courses enrolled in:");
                        for (Course c : courses)
                            System.out.println(c);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                case 7:
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(
                            new FileOutputStream("data.ser"));
                        out.writeObject(table);
                        out.close();
                        System.out.println("Data saved. Goodbye!");
                    } catch (Exception e) {
                        System.out.println("Error saving data: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-7.");
            }
        }
        scanner.close();
    }
}