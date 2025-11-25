import java.util.ArrayList;
import java.util.List;
class Course{
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String name){
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
    }
    public void enrolledStudents(Student s){
        enrolledStudents.add(s);
    }
    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("  - " + s.getName());
        }
    }
    public String getCourseName(){
        return courseName;
    }
}

class Student{
    private String name;
    private List<Course> courses;

    public Student(String name){
        this.name = name;
        courses = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void enrollInCourse(Course c){
        courses.add(c);
    }
    public void showMyCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("  - " + c.getCourseName());
        }
    }
}
class School{
    private String schoolName;
    private List<Student> students;

    public School(String schoolName){
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }
    public void addStudent(Student s){
        students.add(s);
    }
    public void showStudents(){
        System.out.println("Students of " + schoolName + ":");
        for (Student s : students) {
            System.out.println("  - " + s.getName());
        }
    }
}
public class SchoolDemo {
    public static void main(String[] args) {
        School school = new School("ABC");
        Student s1 = new Student("A");
        Student s2 = new Student("B");

        school.addStudent(s1);
        school.addStudent(s2);

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        s1.enrollInCourse(c1);
        s1.enrollInCourse(c2);

        s2.enrollInCourse(c1); 

        school.showStudents();

        System.out.println();

        s1.showMyCourses();
        s2.showMyCourses();

        System.out.println();

        c1.showEnrolledStudents();
        c2.showEnrolledStudents();
    }
}
