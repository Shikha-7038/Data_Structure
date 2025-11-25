import java.util.ArrayList;
import java.util.List;

class Employee{
    private String name;

    public Employee(String name){
        this.name = name;
    }
    public void showEmployee(){
        System.out.println("Employee: "+name);
    }
}
class Department{
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName){
        this.deptName = deptName;
        employees = new ArrayList<>();
    }
    public void addEmployee(String empName){
        employees.add(new Employee(empName));
    }
    public void showDepartment(){
        System.out.println("Department: "+deptName);
        for(Employee e : employees){
            e.showEmployee();
        }
    }
}
class Company{
    private String companyName;
    private List<Department> departments;

    public Company(String name){
        this.companyName = name;
        departments = new ArrayList<>();
    }
    public void addDepartment(Department dept){
        departments.add(dept);
    }
    public void showCompanyDetails(){
        System.out.println("Company: "+companyName);
        for(Department d : departments){
            d.showDepartment();
        }
    }
    public void closeCompany(){
        System.out.println("Closing Company: "+companyName);
        departments.clear();
        System.out.println("All Departments and Employees deleted!");
    }
}
public class CompanyDemo{
    public static void main(String[] args){
        Company c = new Company("ABC");

        Department d1 = new Department("HR");
        d1.addEmployee("A");
        d1.addEmployee("B");

        Department d2 = new Department("IT");
        d2.addEmployee("C");
        d2.addEmployee("D");

        c.showCompanyDetails();

        c.closeCompany();
    }
}