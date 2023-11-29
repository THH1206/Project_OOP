import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        int choice;

        do {
            System.out.println("\t\t\t\t***STUDENT MANAGEMENT SYSTEM***");

            System.out.println("1. Add new student\t\t\t\t\t2. Delete student by id");
            System.out.println("3. Update student by id\t\t\t\t4. List all students");
            System.out.println("5. Find students by major\t\t\t6. Find students by id");
            System.out.println("7. Sort students by id\t\t\t\t8. Sort students by GPA");
            System.out.println("9. Sort students by first name\t\t10. Sort students by last name");
            System.out.println("11. Find student with highest GPA\t\t\t");
            System.out.println("20. Save to file\t\t\t\t\t21. Load from file");
            System.out.println("0. Exit");

            System.out.print("Enter your choice (0-9): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.deleteStudent();
                    break;
                case 3:
                    system.updateStudent();
                    break;
                case 4:
                    system.listAllStudents();
                    break;
                case 5:
                    system.sortStudentsByName();
                    break;
                case 6:
                    system.sortStudentsByGPA();
                    break;
                case 7:
                    system.findStudentWithHighestGPA();
                    break;
                case 8:
                    if (system.isStudentListEmpty()) {
                        System.out.println("The student list is empty. Do you want to continue? (y/n): ");
                        String continueChoice = scanner.nextLine().toLowerCase();

                        if (!continueChoice.equals("y")) {
                            break; // Exit the switch statement and go back to the main menu
                        }
                    }
                    System.out.print("Do you want to replace all data in the file? (y/n): ");
                    String replaceChoice = scanner.nextLine().toLowerCase();
                    if (replaceChoice.equals("y"))
                        system.saveToFileAtAll();
                    else if (replaceChoice.equals("n"))
                        system.saveToFileAtEnd();
                    else {
                        System.out.println("Invalid choice. Please enter 'y' to replace all data or 'n' to append.");
                    }
                    break;

                case 9:
                    system.loadFromFile();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 21.");
            }
        } while (choice != 0);

        scanner.close();
    }
}