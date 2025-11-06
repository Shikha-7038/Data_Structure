import java.util.Scanner;
public class TicketReservationSystem{
    class Node{
        int ticketID;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Node next;

        Node(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime){
            this.ticketID = ticketID;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }
    private Node head = null;
    private Node tail = null;

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime){
        Node newNode = new Node(ticketID, customerName, movieName, seatNumber, bookingTime);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }else{
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Ticket booked successfully for "+customerName);
    }
    public void removeTicket(int ticketID){
        if(head == null){
            System.out.println("No tickets found!");
            return;
        }
        Node current = head;
        Node prev = tail;
        boolean found = false;

        do{
            if(current.ticketID == ticketID){
                found = true;
                if(current == head && current == tail){
                    head = null;
                    tail = null;
                }else if(current == head){
                    head = head.next;
                    tail.next = head;
                }else if(current  == tail){
                    tail = prev;
                    tail.next = head;
                }else{
                    prev.next = current.next;
                }
                System.out.println("Ticket ID "+ticketID+ " has beeen canceled.");
                break;
            }
            prev = current;
            current = current.next;
        }while(current!=head);
        if(!found)
            System.out.println("Ticket ID not found!");
    }
    public void displayTickets(){
        if(head == null){
            System.out.println("No tickets booked yet.");
            return;
        }
        Node temp = head;
        System.out.println("Current Booked Tickets: ");
        System.out.println("--------------------------");
        do{
            System.out.println("Ticket ID: " + temp.ticketID);
            System.out.println("Customer Name: " + temp.customerName);
            System.out.println("Movie Name: " + temp.movieName);
            System.out.println("Seat Number: " + temp.seatNumber);
            System.out.println("Booking Time: " + temp.bookingTime);
            System.out.println("------------------------------------------------------------");
            temp = temp.next;
        }while(temp!= head);
    }

    public void countTickets(){
        if(head == null){
            System.out.println("📊 Total Booked Tickets: 0");
            return;
        }
        int count = 0;
        Node current = head;
        do{
            count++;
            current = current.next;
        }while(current!= head);
        System.out.println("📊 Total Booked Tickets: " + count);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int choice;
        do{
            System.out.println("\n=== 🎬 Online Ticket Reservation System ===");
            System.out.println("1. Add Ticket Reservation");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Count Total Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;

                case 2:
                    System.out.println("Enter Ticket ID to remove: ");
                    int removeId = sc.nextInt();
                    system.removeTicket(removeId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    system.countTickets();
                    break;

                case 0:
                    System.out.println("Exiting the system. Have a great day!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
        while(choice != 0);
            sc.close();
    }
}
