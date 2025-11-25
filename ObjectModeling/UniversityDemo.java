import java.util.ArrayList;
import java.util.List;

class Faculty{
    private String name;

    public Faculty(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class Department{
    private String deptName;

    public Department(String deptName){
        this.deptName = deptName;
    }
    public String getDeptName(){
        return deptName;
    }
}

class University{
    private String universityName;
    private List<Department> departments;
    private List<Faculty> facultyMembers;

    public University(String name){
        this.universityName = name;
        departments = new ArrayList<>();
        facultyMembers = new ArrayList<>();
    }
    public void addDepartment(Department dept){
        departments.add(dept);
    }
    public void addFaculty(Faculty faculty){
        facultyMembers.add(faculty);
    }
    public void showDepartments() {
        System.out.println("Departments in " + universityName + ":");
        for (Department d : departments) {
            System.out.println("  - " + d.getDeptName());
        }
    }

    public void showFaculty() {
        System.out.println("Faculty members of " + universityName + ":");
        for (Faculty f : facultyMembers) {
            System.out.println("  - " + f.getName());
        }
    }

    public void destroyUniversity() {
        System.out.println("\nDestroying the university: " + universityName);
        departments.clear();
        System.out.println("All departments have been deleted (Composition).");
        System.out.println("Faculty still exist independently (Aggregation).");
    }

    public List<Faculty> getFacultyList() {
        return facultyMembers;
    }
}
public class UniversityDemo {
    public static void main(String[] args){
        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Dr. Verma");

        University uni = new University("ABC University");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mechanical Engineering");

        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.showFaculty();
        System.out.println();
        uni.showDepartments();

        uni.destroyUniversity();

        System.out.println();

        System.out.println("Faculty who still exist in the system:");
        System.out.println("  - " + f1.getName());
        System.out.println("  - " + f2.getName());
    }
}
