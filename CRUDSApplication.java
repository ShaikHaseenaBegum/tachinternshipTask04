package internsavy_task4;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

		public class CRUDSApplication {
		    private static List<Student> studentList = new ArrayList<>();
		    private static int nextId = 1;

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        int choice;

		        do {
		            System.out.println("1. Create");
		            System.out.println("2. Read");
		            System.out.println("3. Update");
		            System.out.println("4. Delete");
		            System.out.println("5. Exit");
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    createStudent(scanner);
		                    break;
		                case 2:
		                    readStudents();
		                    break;
		                case 3:
		                    updateStudent(scanner);
		                    break;
		                case 4:
		                    deleteStudent(scanner);
		                    break;
		                case 5:
		                    System.out.println("Exiting...");
		                    break;
		                default:
		                    System.out.println("Invalid choice");
		            }
		        } while (choice != 5);

		        scanner.close();
		    }

		    private static void createStudent(Scanner scanner) {
		        System.out.print("Enter student name: ");
		        String name = scanner.next();
		        Student student = new Student(nextId++, name);
		        studentList.add(student);
		        System.out.println("Student created successfully");
		    }

		    private static void readStudents() {
		        if (studentList.isEmpty()) {
		            System.out.println("No students found");
		        } else {
		            System.out.println("Student List:");
		            for (Student student : studentList) {
		                System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
		            }
		        }
		    }

		    private static void updateStudent(Scanner scanner) {
		        System.out.print("Enter student ID to update: ");
		        int id = scanner.nextInt();

		        for (Student student : studentList) {
		            if (student.getId() == id) {
		                System.out.print("Enter new name: ");
		                String newName = scanner.next();
		                studentList.set(studentList.indexOf(student), new Student(id, newName));
		                System.out.println("Student updated successfully");
		                return;
		            }
		        }

		        System.out.println("Student not found");
		    }

		    private static void deleteStudent(Scanner scanner) {
		        System.out.print("Enter student ID to delete: ");
		        int id = scanner.nextInt();

		        for (Student student : studentList) {
		            if (student.getId() == id) {
		                studentList.remove(student);
		                System.out.println("Student deleted successfully");
		                return;
		            }
		        }

		        System.out.println("Student not found");
		    }
		}

