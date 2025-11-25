import java.util.ArrayList;
import java.util.List;

class Course{
     private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.courseName = name;
        enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println("Professor " + p.getName() + " assigned to " + courseName);
    }

    public void enrollStudent(Student s) {
        enrolledStudents.add(s);
        System.out.println(s.getName() + " enrolled in " + courseName);
    }

    public void showCourseInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "None"));
        System.out.println("Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("  - " + s.getName());
        }
    }
    public String getName() {
        return courseName;
    }
}
class Student{
    private String name;
    private List<Course> myCourses;

    public Student(String name) {
        this.name = name;
        myCourses = new ArrayList<>();
    }

    public String getName() { return name; }

    public void enrollCourse(Course c) {
        myCourses.add(c);
        c.enrollStudent(this);
    }

    public void showMyCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : myCourses) {
            System.out.println("  - " + c.getName());
        }
    }
}
class Professor{
    private String name;
    public Professor(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class University{
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String name) {
        this.name = name;
        students = new ArrayList<>();
        professors = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(Student s) { students.add(s); }
    public void addProfessor(Professor p) { professors.add(p); }
    public void addCourse(Course c) { courses.add(c); }

    public void showUniversityDetails() {
        System.out.println("\n--- " + name + " University Details ---");

        System.out.println("\nStudents:");
        for (Student s : students) System.out.println("  - " + s.getName());

        System.out.println("\nProfessors:");
        for (Professor p : professors) System.out.println("  - " + p.getName());

        System.out.println("\nCourses:");
        for (Course c : courses) {
            c.showCourseInfo();
            System.out.println();
        }
    }
}
public class UniversityManagementDemo {
    public static void main(String[] args) {
        University uni = new University("Global University");

        Student s1 = new Student("Riya");
        Student s2 = new Student("Kabir");

        Professor p1 = new Professor("Dr. Sen");
        Professor p2 = new Professor("Dr. Meera");

        Course c1 = new Course("Computer Science");
        Course c2 = new Course("Mathematics");

        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addProfessor(p1);
        uni.addProfessor(p2);
        uni.addCourse(c1);
        uni.addCourse(c2);

        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c2);

        uni.showUniversityDetails();
    }
}
