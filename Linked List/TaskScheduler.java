import java.util.Scanner;
public class TaskScheduler {
    class TaskNode{
        int taskID;
        String taskName;
        String priority;
        String dueDate;
        TaskNode next;

        TaskNode(int taskID, String taskName,String priority, String dueDate){
            this.taskID = taskID;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode currentTask = null;
    // private TaskNode currentTask = null;

    public void addAtBeginning(int id, String name,String priority,String dueDate){
        TaskNode newNode = new TaskNode(id, name,priority,dueDate);
        if(head == null){
            head = tail = newNode;
            newNode.next = head;
            currentTask = head;
        }else{
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        System.out.println("Task added at the beginning.");
    }

    public void addAtEnd(int id, String name,String priority,String dueDate){
        TaskNode newNode = new TaskNode(id, name,priority, dueDate);
        if(head == null){
            head = tail = newNode;
            newNode.next = head;
            currentTask = head;
        }else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Task added at the end.");
    }
    public void addAtPosition(int id, String name,String priority, String dueDate, int position){
        if(position <= 1 || head == null){
            addAtBeginning(id, name,priority,dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(id, name,priority,dueDate);
        TaskNode current = head;
        int count =1;

        while(count < position-1 && current.next != head){
            current = current.next;
            count++;
        }
        if(current.next == head){
            addAtEnd(id, name,priority,dueDate);
            return;
        }else{
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Task added at position "+ position+ ".");
        }
    }
    public void removeByID(int id){
        if(head == null){
            System.out.println("Task List is empty.");
            return;
        }
        TaskNode current = head;
        TaskNode prev = tail;
        boolean found = false;

         do {
            if (current.taskID == id) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Task with ID " + id + " not found.");
            return;
        }
            
        if(head == tail&& head.taskID == id){
            head = tail = currentTask = null;
        }else if(current == head){
            head = head.next;
            tail.next = head;
        }else if(current == tail){
            tail = prev;
            tail.next = head;
        }else{
            prev.next = current.next;
        }
        System.out.println("Task with ID "+id+ " removed successfully.");
    }

    public void viewCurrentTask() {
        if (currentTask == null) {
            System.out.println("No current task selected.");
            return;
        }
        System.out.println("\nCurrent Task ===");
        System.out.printf("%-10d %-15s %-10s %-15s\n",
                currentTask.taskID, currentTask.taskName, currentTask.priority, currentTask.dueDate);
    }

    public void moveToNextTask() {
        if (currentTask == null) {
            System.out.println("No tasks available to move.");
            return;
        }
        currentTask = currentTask.next;
        System.out.println("Moved to the next task:");
        viewCurrentTask();
    }

    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        boolean found = false;
        TaskNode current = head;
        System.out.println("\nTasks with Priority: " + priority + " ===");
        do {
            if (current.priority.equalsIgnoreCase(priority)) {
                System.out.printf("%-10d %-15s %-10s %-15s\n",
                        current.taskID, current.taskName, current.priority, current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    public void displayTasks(){
        if(head == null){
            System.out.println("No task available.");
            return;
        }
        TaskNode current = head;
        do{
            System.out.printf("%-10d %-15s %-15s\n",current.taskID, current.taskName,current.dueDate);
            current = current.next;
        }while(current != head);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do{
            System.out.println("\n=== 🔁 Task Scheduler (Circular Linked List) ===");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by ID");
             System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Display All Tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter Task ID, Name, Due Date: ");
                    scheduler.addAtBeginning(sc.nextInt(),sc.next(),sc.next(),sc.next());
                    break;

                case 2:
                    System.out.println("Enter Task ID, Name, Due Date: ");
                    scheduler.addAtEnd(sc.nextInt(),sc.next(),sc.next(),sc.next());
                    break;

                case 3:
                    System.out.println("Enter Task ID, Name, Due Date, Position: ");
                    scheduler.addAtPosition(sc.nextInt(),sc.next(),sc.next(),sc.next(), sc.nextInt());
                    break;

                case 4:
                    System.out.println("Enter Task ID to remove: ");
                    scheduler.removeByID(sc.nextInt());
                    break;

                case 5:
                    scheduler.viewCurrentTask();
                    break;

                case 6:
                    scheduler.moveToNextTask();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    scheduler.searchByPriority(sc.next());
                    break;

                case 8:
                    scheduler.displayTasks();
                    break;

                case 0:
                    System.out.println("Exiting Task Scheduler. Goodbye");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }while(choice != 0);
        sc.close();
    }
}
