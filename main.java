import java.util.ArrayList;
import java.util.Scanner;

// Base Class (Parent)
class Employee {
    protected int empId;
    protected String name;

    // Constructor
    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    // Method to calculate salary (to be overridden)
    public double calculateSalary() {
        return 0;
    }

    // Display details
    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
    }
}

// Derived Class 1 (Inheritance)
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int empId, String name, double monthlySalary) {
        super(empId, name);
        this.monthlySalary = monthlySalary;
    }

    // Method Overriding
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Full-Time Employee");
        System.out.println("Salary: " + calculateSalary());
        System.out.println("---------------------------");
    }
}

// Derived Class 2 (Inheritance)
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int empId, String name, int hoursWorked, double hourlyRate) {
        super(empId, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Method Overriding
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Part-Time Employee");
        System.out.println("Salary: " + calculateSalary());
        System.out.println("---------------------------");
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();

                    System.out.print("Enter Monthly Salary: ");
                    double salary = sc.nextDouble();

                    empList.add(new FullTimeEmployee(id1, name1, salary));
                    System.out.println("Full-Time Employee Added!");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();

                    System.out.print("Enter Hours Worked: ");
                    int hours = sc.nextInt();

                    System.out.print("Enter Hourly Rate: ");
                    double rate = sc.nextDouble();

                    empList.add(new PartTimeEmployee(id2, name2, hours, rate));
                    System.out.println("Part-Time Employee Added!");
                    break;

                case 3:
                    System.out.println("\n--- Employee Details ---");
                    
                    // Polymorphism in action
                    for (Employee emp : empList) {
                        emp.displayDetails();  // Calls overridden method
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
