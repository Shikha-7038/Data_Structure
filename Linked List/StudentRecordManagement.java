import java.util.Scanner;
class Student{
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNo, String name, int age, String grade){
        this.rollNo = rollNo;
        this.name= name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentLinkedList{
    private Student head;
    public void addAtBeginning(int rollNo, String name, int age, String grade){
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("Student added at beginning successfully.");
    }

    public void addAtEnd(int rollNo, String name, int age, String grade){
        Student newStudent = new Student(rollNo, name, age, grade);
        if (head == null){
            head = newStudent;
        }else{
            Student current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newStudent;
        }
        System.out.println("Student added at end successfully.");
    }

    public void addAtPosition(int position, int rollNo, String name, int age, String grade){
        if(position == 1){
            addAtBeginning(rollNo, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNo, name, age, grade);
        Student current = head;
        for(int i=1; current!=null && i<position-1;i++){
            current = current.next;
        }
        if(current == null){
            System.out.println("Invalid Position! Adding at the end instead. ");
            addAtEnd(rollNo, name, age, grade);
        }else{
            newStudent.next = current.next;
            current.next = newStudent;
            System.out.println("Student added at position "+position+ " successfully.");
        }
    }

    public void deleteRollNumber(int rollNo){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }
        if(head.rollNo == rollNo){
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }
        Student current = head;
        while(current.next!=null && current.next.rollNo!=rollNo){
            current = current.next;
        }
        if(current.next==null){
            System.out.println("Student with Roll Number "+rollNo+ " not found.");
        }else{
            current.next = current.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    public void searchByRollNumber(int rollNo){
        Student current = head;
        while(current!=null){
            if(current.rollNo == rollNo){
                System.out.println("Student Found: ");
                System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name +", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.nextt;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }

    public void updateGrade(int rollNo, String newGrade){
        Student current = head;
        while(current!=null){
            if(current.rollNo == rollNo){
                current.grade = newGrade;
                System.out.println("Grade updated successfully for Roll No: " + rollNo);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }
    public void displayAll(){
        if(head == null){
            System.out.println("No student records to display.");
            return;
        }
        System.out.println("Student Records: ");
        Student current = head;
        while(current!=null){
            System.out.println("Roll No: "+current.rollNo+ ", Name: "+current.name+", Age: "+current.age+ ", Grade: "+current.grade);
            current = current.next;
        }
    }
}
public class StudentRecordManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do{
            System.out.println("-----------Student Record Management----------");
            System.out.println("1. Add Student At Beginning");
            System.out.println("2. Add Student At End");
            System.out.println("3. Add Student At Specific Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade by Roll Number");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade1 = sc.nextLine();
                    list.addAtBeginning(roll1, name1, age1, grade1);
                    break;

                case 2:
                    System.out.print("Enter Roll No: ");
                    int roll2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade2 = sc.nextLine();
                    list.addAtEnd(roll2, name2, age2, grade2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Roll No: ");
                    int roll3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade3 = sc.nextLine();
                    list.addAtPosition(pos, roll3, name3, age3, grade3);
                    break;

                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    int roll4 = sc.nextInt();
                    list.deleteRollNumber(roll4);
                    break;

                case 5:
                    System.out.println("Enter Roll No to Search: ");
                    int roll5 = sc.nextInt();
                    list.searchByRollNumber(roll5);
                    break;

                case 6:
                    System.out.println("Enter Roll No to Update Grade: ");
                    int roll6 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter New Grade: ");
                    String newGrade = sc.nextLine();
                    list.updateGrade(roll6, newGrade);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}