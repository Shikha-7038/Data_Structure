import java.util.Scanner;
public class TextEditorUndoRedo{
    class Node{
        String textContent;
        Node prev;
        Node next;

        Node(String textContent){
            this.textContent = textContent;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head = null;
    private Node current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String text){
        Node newNode = new Node(text);
        if(current != null && current.next!=null){
            Node temp = current.next;
            while(temp!=null){
                Node next = temp.next;
                temp.prev = temp.next = null;
                temp = next;
                size--;
            }
            current.next = null;
        }
        if(head == null){
            head = newNode;
            current = newNode;
        }else{
            current.next = newNode;
            newNode.prev = current;
            current  = newNode;
        }
        size++;
        if(size>MAX_HISTORY){
            head = head.next;
            head.prev = null;
            size--;
        }
        System.out.println("New state added successfully.");
    }
    public void undo(){
        if(current ==  null || current.prev == null){
            System.out.println("No more undo operations available.");
            return;
        }
        current = current.prev;
        System.out.println("Undo successful. Current text: " + current.textContent);
    }
    public void redo(){
        if(current == null || current.next == null){
            System.out.println("No more redo operations available.");
            return;
        }
        current = current.next;
        System.out.println("Redo successful. Current text: " + current.textContent);
    }
    public void displayCurrentState(){
        if(current == null){
            System.out.println("The editor is empty.");
        }else{
            System.out.println("Current Text: "+current.textContent);
        }
    }
    public void displayHistory(){
        if(head == null){
            System.out.println("No history available.");
            return;
        }
        System.out.println("\nEditor History (Oldest → Newest):");
        Node temp = head;
        while(temp!=null){
            if(temp!= current){
                System.out.println("[CURRENT] " + temp.textContent);
            }else{
                 System.out.println("   " + temp.textContent);
            }
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        int choice;

        do { 
            System.out.println("\nText Editor: Undo/Redo System ===");
            System.out.println("1. Type/Add New Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Show All History (Debug)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter new text content: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrentState();
                    break;

                case 5:
                    editor.displayHistory();
                    break;

                case 0:
                    System.out.println("Exiting text editor. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice!=0);
        sc.close();
    }
}