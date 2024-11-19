import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String studentID;
    private double[] grades;

    
    public Student(String name, String studentID, double[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

   
    public void displayGrades() {
        System.out.print("Grades for " + name + " (" + studentID + "): ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    
    public boolean hasPassed() {
        double average = calculateAverage();
        return average >= 60; 
    }

    
    public String getName() {
        return name;
    }

    
    public double getAverage() {
        return calculateAverage();
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        String continueInput;

        do {
            
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String studentID = scanner.nextLine();
            System.out.print("Enter number of grades: ");
            int numberOfGrades = scanner.nextInt();
            double[] grades = new double[numberOfGrades];

            
            for (int i = 0; i < numberOfGrades; i++) {
                System.out.print("Enter grade " + (i + 1) + ": ");
                grades[i] = scanner.nextDouble();
            }

            
            students.add(new Student(name, studentID, grades));

            System.out.print("Do you want to add another student? (yes/no): ");
            continueInput = scanner.next();
            scanner.nextLine(); 

        } while (continueInput.equalsIgnoreCase("yes"));

       
        double totalAverage = 0;
        for (Student student : students) {
            student.displayGrades();
            double average = student.getAverage();
            System.out.printf("Average: %.2f, Status: %s%n",
                    average, student.hasPassed() ? "Passed" : "Failed");
            totalAverage += average;
        }

        
        double classAverage = totalAverage / students.size();
        System.out.printf("Class Average: %.2f%n", classAverage);

        scanner.close();
    }
}
