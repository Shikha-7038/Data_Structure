import java.util.Scanner;

public class LibraryManagementSystem {
    class BookNode{
        String title;
        String author;
        String genre;
        int bookID;
        boolean isAvailable;
        BookNode next;
        BookNode prev;

        BookNode(String title, String author, String genre, int bookID, boolean isAvailable){
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookID = bookID;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }
    private BookNode head = null;
    private BookNode tail = null;

    public void addAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable){
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at the beginning.");
    }

    public void addAtEnd(String title, String author, String genre, int bookID, boolean isAvailable){
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end.");
    }

    public void addAtPosition(String title, String author, String genre, int bookID,boolean isAvailable, int position){
        if(position <=1 || head == null ){
            addAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        BookNode current = head;
        int count = 1;

        while(current!=null && count <position-1){
            current = current.next;
            count++;
        }
        if(current == null || current.next == null){
            addAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }else{
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            System.out.println("Book added at position "+position+ ".");
        }
    }

    public void removeByBookID(int id){
        if(head == null){
            System.out.println("No books in the library.");
            return;
        }
        BookNode current = head;
        while(current!=null && current.bookID!=id){
            current = current.next;
        }
        if(current == null){
            System.out.println("Book with ID "+id+" not found.");
            return;
        }
        if(current == head && current == tail){
            head = tail = null;
        }else if(current == head){
            head = head.next;
            head.prev = null;
        }else if(current == tail){
            tail = tail.prev;
            tail.next = null;
        }else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("Book with ID "+id+" removed successfully.");
    }

     public void searchBook(String keyword) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        boolean found = false;
        BookNode current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                System.out.printf("%-6d %-20s %-15s %-15s %-10s\n",
                        current.bookID, current.title, current.author, current.genre,
                        current.isAvailable ? "Available" : "Issued");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No book found with Title or Author: " + keyword);
        }
    }

    public void updateAvailability(int bookID, boolean status) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;

        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = status;
                System.out.println("Book availability updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    public void displayForward(){
        if(head == null){
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;
        while(current!=null){
            System.out.printf("%-6d %-20s %-15s %-15s %-10s\n", current.bookID, current.title, current.author, current.genre);
            current = current.next;
        }
    }

    public void displayReverse(){
        if(tail == null){
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = tail;
        while(current!=null){
            System.out.printf("%-6d %-20s %-15s %-15s %-10s\n",current.bookID, current.title, current.author, current.genre);
            current = current.prev;
        }
    }

    public void countBooks(){
        int count = 0;
        BookNode current = head;
        while(current!=null){
            count++;
            current = current.next;
        }
        System.out.println("Total Number of Books: "+count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();
        int choice;

        do { 
            System.out.println("\n=== 📚 Library Management System ===");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Specific Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title/Author");
            System.out.println("6. Update Book Availability");
            System.out.println("7. Display Books (Forward)");
            System.out.println("8. Display Books (Reverse)");
            System.out.println("9. Count Total Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1: 
                    System.out.println("Enter Title, Author, Genre, Book ID");
                    library.addAtBeginning(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;

                case 2: 
                    System.out.println("Enter Title, Author, Genre, Book ID");
                    library.addAtEnd(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;

                case 3: 
                    System.out.println("Enter Title, Author, Genre, Book ID");
                    library.addAtPosition(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean(), sc.nextInt());
                    break;

                case 4: 
                    System.out.println("Enter Book ID to remove: ");
                    library.removeByBookID(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Enter Title or Author to search: ");
                    library.searchBook(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Enter Book ID and new Availability (true/false): ");
                    library.updateAvailability(sc.nextInt(), sc.nextBoolean());
                    break;

                case 7:
                    library.displayForward();
                    break;

                case 8: 
                    library.displayReverse();
                    break;

                case 0:
                    System.out.println("Exiting Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);
    }
}
