import java.util.Scanner;
public class MovieManagementSystem {
    
    class MovieNode{
        String title;
        String director;
        int year;
        double rating;
        MovieNode next;
        MovieNode prev;

        MovieNode(String title, String director, int year, double rating){
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }
    private MovieNode head = null;
    private MovieNode tail = null;

    public void addAtBeginning(String title, String director, int year, double rating){
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at the beginning.");
    }

    public void addAtEnd(String title, String director, int year, double rating){
        MovieNode newNode =new MovieNode(title, director, year, rating);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at the end.");
    }

    public void addAtPosition(String title, String director, int year, double rating, int position){
        if(position <= 1 || head == null){
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int count = 1;

        while(current != null && count < position-1){
            current = current.next;
            count++;
        }

        if(current == null || current.next == null){
            addAtEnd(title, director, year , rating);
        }else{
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            System.out.println("Movie added at position "+position+ ".");
        }
    }

    public void removeByTitle(String title){
        if(head == null){
            System.out.println("Movie list is empty.");
            return;
        }
        MovieNode current = head;
        while(current != null && !current.title.equalsIgnoreCase(title)){
            current = current.next;
        }
        if(current == null){
            System.out.println("Movie titled "+title+ " not found.");
            return;
        }
        if(current == tail && current == head){
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
        System.out.println("Movie titled "+title+ "removed successfully.");
    }

    public void searchByDirector(String director){
        if(head == null){
            System.out.println("Movie list is empty.");
        }
        boolean found = false;
        MovieNode current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                if (!found) {
                    System.out.println("\n🎬 Movies directed by " + director + ":");
                }
                System.out.printf("%-20s %-15s %-10d %-6.1f\n",
                        current.title, current.director, current.year, current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found by director " + director + ".");
        }
    }

    public void searchByRating(double ratingThreshold){
        if(head == null){
            System.out.println("Movie list is empty.");
            return;
        }
        boolean found = false;
        MovieNode current = head;
         while (current != null) {
            if (current.rating >= ratingThreshold) {
                if (!found) {
                    System.out.println("\n🎥 Movies with rating >= " + ratingThreshold + ":");
                }
                System.out.printf("%-20s %-15s %-10d %-6.1f\n",
                        current.title, current.director, current.year, current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with rating >= " + ratingThreshold + ".");
        }
    }

    public void updateRating(String title, double newRating){
        if(head == null){
            System.out.println("Movie list is empty.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie '" + title + "' to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie titled '" + title + "' not found.");
    }
    public void displayForward(){
        if(head == null){
            System.out.println("Movie list is empty.");
            return;
        }

        MovieNode current = head;
        while(current != null){
            System.out.printf("%-20s %-15s %-10d %-6.1f\n",current.title, current.director, current.year, current.rating);
            current = current.next;
        }
    }
      public void displayReverse(){
        if(tail == null){
            System.out.println("Movie list is empty.");
            return;
        }

        MovieNode current = tail;
        while(current != null){
            System.out.printf("%-20s %-15s %-10d %-6.1f\n",current.title, current.director, current.year, current.rating);
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagementSystem mms = new MovieManagementSystem();
        int choice;

        do { 
            System.out.println("\n=== 🎞️ Movie Management System ===");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Rating by Movie Title");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating");
                    mms.addAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Title, Director, Year, Rating");
                    mms.addAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter Title, Director, Year, Rating");
                    mms.addAtPosition(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Title to Remove: ");
                    mms.removeByTitle(sc.next());
                    break;

                case 5:
                    System.out.println("Enter Director Name: ");
                    mms.searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Minimum Rating to Search: ");
                    mms.searchByRating(sc.nextDouble());
                    break;

                case 7:
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    mms.updateRating(title, newRating);
                    break;
                case 8:
                    mms.displayForward();
                    break;

                case 9:
                    mms.displayReverse();
                    break;

                case 0:
                    System.out.println("Exition.... Thank you.");
                    break;
                
                default:
                    System.out.println("Invalid Choice. Try again.");

            }

        } while (choice != 8);
        sc.close();
    }
}
