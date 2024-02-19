import java.util.Scanner;

class DateOfJoining {
    private int day, month, year;

    public DateOfJoining(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

class Employee {
    private static int empIDCounter = 1001;
    private int empID;
    private String empName;
    private String dept;
    private DateOfJoining dateOfJoining;
    private double salary;

    public Employee(String empName, String dept, DateOfJoining dateOfJoining, double initialSalary) {
        this.empID = empIDCounter++;
        this.empName = empName;
        this.dept = dept;
        this.dateOfJoining = dateOfJoining;
        this.salary = Math.max(initialSalary, 300);
    }
    public Employee(String empName, String dept, DateOfJoining dateOfJoining) {
        this(empName, dept, dateOfJoining, 300);
    }

    public void addIncentives(double incentives) {
        salary += incentives;
        System.out.println("Incentives added successfully. New Salary: $" + salary);
    }

    public void changeDept(String newDept) {
        this.dept = newDept;
        System.out.println("Department changed successfully. New Department: " + dept);
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Department: " + dept);
        System.out.println("Date of Joining: " + dateOfJoining);
        System.out.println("Salary: $" + salary);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	Employee newEmployee = null;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. New Employee");
            System.out.println("2. Add Incentives");
            System.out.println("3. Change Dept");
            System.out.println("4. Display Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String empName = scanner.next();
                    System.out.print("Enter Department (Sales/Marketing/Production): ");
                    String dept = scanner.next();
                    System.out.print("Enter Date of Joining (day month year): ");
                    int day = scanner.nextInt();
                    int month = scanner.nextInt();
                    int year = scanner.nextInt();
                    DateOfJoining dateOfJoining = new DateOfJoining(day, month, year);
                    System.out.print("Enter Initial Salary: ");
                    double initialSalary = scanner.nextDouble();

                    newEmployee = new Employee(empName, dept, dateOfJoining, initialSalary);
                    if(newEmployee !=null)
			{System.out.println("Employee created successfully."); 
			newEmployee.displayDetails();
			}
                    break;

                case 2:
                    System.out.print("Enter Incentives Amount: ");
                    double incentives = scanner.nextDouble();
                    if(newEmployee !=null)
			newEmployee.addIncentives(incentives);
                    break;

                case 3:
                    System.out.print("Enter New Department: ");
                    String newDept = scanner.next();

                    if(newEmployee !=null)
			newEmployee.changeDept(newDept);
                    break;

                case 4:
                    if(newEmployee !=null)
			newEmployee.displayDetails();
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}