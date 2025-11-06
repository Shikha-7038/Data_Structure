import java.util.Scanner;
public class RoundRobinScheduler {
    class ProcessNode{
        int processID;
        int burstTime;
        int priority;
        int waitingTime;
        int turnaroundTime;
        ProcessNode next;

        ProcessNode(int id, int bt, int p){
            processID = id;
            burstTime = bt;
            priority = p;
            waitingTime = 0;
            turnaroundTime = 0;
            next = null;
        }
    }
    private ProcessNode head = null;
    private ProcessNode tail = null;

    public void addProcess(int id, int burstTime, int priority){
        ProcessNode newNode = new ProcessNode(id, burstTime, priority);
        if(head == null){
            head = tail = newNode;
            newNode.next = head;
        }else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Process "+id+ " added to the queue.");
    }

    public void removeProcess(int id){
        if(head == null) return;
        ProcessNode current = head;
        ProcessNode prev = tail;

        do { 
            if(current.processID == id){
                if(current == head && current == tail){
                    head = tail = null;
                }else if(current == head){
                    head = head.next;
                    tail.next = head;
                }else if(current == tail){
                    tail=prev;
                    tail.next = head;
                }else{
                    prev.next = current.next;
                }
                System.out.println("Process "+id+ " completed and removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current!=head);
    }

    public void displayQueue(){
        if(head == null){
            System.out.println("Queue is empty.");
            return;
        }
        ProcessNode current = head;
        do { 
            System.out.printf("%-10d %-15d %-10d\n",current.processID, current.burstTime, current.priority);
            current = current.next;
        } while (current!=head);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        int choice;

        do { 
            System.out.println("\n=== ⚙️ Round Robin Scheduler (Circular Linked List) ===");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process By Process ID");
            System.out.println("3. Display Queue");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    scheduler.addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    scheduler.removeProcess(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    scheduler.displayQueue();
                    break;

                case 0:
                    System.out.println("Exiting Scheduler. Goodbye");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice!=0);
        sc.close();
    }
}
