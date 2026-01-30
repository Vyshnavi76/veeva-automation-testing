import java.util.*;
class Employee {
String name;
String job;
double salary;
String dateOfJoining; 
Employee(String name, String job, double salary, String dateOfJoining) {
this.name = name;
this.job = job;
this.salary = salary;
this.dateOfJoining = dateOfJoining;
}
public String toString() {
 return "Name:"+name+"|Job:"+job+"|Salary:"+salary+"|DOJ:"+dateOfJoining;
}
}
public class EmployeeManagement {
static ArrayList<Employee> empList=new ArrayList<>();
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int choice;
do {
System.out.println("Main menu");
System.out.println("1. Add Employee");
System.out.println("2. Display All Employees");
System.out.println("3. Sort Employees");
System.out.println("4. Exit");
System.out.print("Enter your choice: ");
choice = sc.nextInt();
sc.nextLine();
switch (choice) {
case 1:addEmployee(sc);
        break;
case 2:displayEmployees();
       break;
case 3:sortMenu(sc);
       break;
case 4:System.out.println("Exiting Program...");
 break;
default: System.out.println("Invalid choice!");
}
} while (choice != 4);
sc.close();
}
public static void addEmployee(Scanner sc) {
System.out.print("Enter Name: ");
String name = sc.nextLine();
System.out.print("Enter Job: ");
String job = sc.nextLine();
System.out.print("Enter Salary: ");
double salary = sc.nextDouble();
sc.nextLine();
System.out.print("Enter Date of Joining: ");
String doj = sc.nextLine();
empList.add(new Employee(name, job, salary, doj));
System.out.println("Employee added successfully!");
}
public static void displayEmployees() {
if (empList.isEmpty()) {
System.out.println("No employee records available!");
return;
}
for(Employee emp:empList) {
System.out.println(emp);
 }
}
public static void sortMenu(Scanner sc) {
int subChoice;
do {
System.out.println("sorting");
System.out.println("1. Sort by Name asce");
System.out.println("2. Sort by Salary desc)");
System.out.println("3. Sort by Date of Joining desc");
System.out.println("4. Back to Main Menu");
System.out.print("Enter your choice: ");
subChoice = sc.nextInt();
sc.nextLine();
switch (subChoice) {
case 1:Collections.sort(empList, Comparator.comparing(e -> e.name));
       System.out.println("Sorted by Name asce");
       displayEmployees();
      break;
case 2:Collections.sort(empList,
        Comparator.comparingDouble((Employee e) -> e.salary).reversed());
         System.out.println("Sorted by Salary desc");
         displayEmployees();
          break;
 case 3:Collections.sort(empList,
Comparator.comparing((Employee e) -> e.dateOfJoining).reversed());
System.out.println("Sorted by Date of Joining desc");
displayEmployees();
break;
case 4:break;
default:System.out.println("Invalid choice!");
}} while (subChoice != 4);
}
}
