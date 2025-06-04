package project2;
import java.util.ArrayList;
import java.util.Scanner;

public class  studentgradetracker {
    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Input grades
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            grades.add(grade);
        }

        // Compute average, highest, and lowest
        if (grades.size() == 0) {
            System.out.println("No grades were entered.");
            scanner.close();
            return;
        }

        double sum = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);

        System.out.println("\nStudent Grades and Letter Grades:");
        for (int i = 0; i < grades.size(); i++) {
            double grade = grades.get(i);
            sum += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;

            // Assign letter grade
            String letterGrade;
            if (grade >= 90) {
                letterGrade = "A";
            } else if (grade >= 80) {
                letterGrade = "B";
            } else if (grade >= 70) {
                letterGrade = "C";
            } else if (grade >= 60) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }
            System.out.printf("Student %d: %.2f - Grade %s\n", i + 1, grade, letterGrade);
        }

        double average = sum / grades.size();

        System.out.printf("\nAverage grade: %.2f\n", average);
        System.out.printf("Highest grade: %.2f\n", highest);
        System.out.printf("Lowest grade: %.2f\n", lowest);

        scanner.close();
    }
}
