import java.util.Scanner;
public class InventoryList {
    class Node{
        String itemName;
        int itemID;
        int quantity;
        double price;
        Node next;

        Node(String itemName, int itemID, int quantity, double price){
            this.itemName = itemName;
            this.itemID = itemID;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }
    Node head;
    public void addAtBeginning(String itemName, int itemID, int quantity, double price){
        Node newNode = new Node(itemName, itemID, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(String itemName, int itemID, int quantity, double price){
        Node newNode = new Node(itemName, itemID, quantity, price);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Item added at the end.");
    }

    public void addAtPosition(String itemName, int itemID, int quantity, double price, int position){
        Node newNode = new Node(itemName, itemID, quantity, price);
        if(position == 1){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i=1; current != null && i < position-1; i++){
            current = current.next;
        }
        if(current == null){
            System.out.println("Position out of range. Item added at the end.");
            addAtEnd(itemName, itemID, quantity, price);
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Item added at position " + position);
    }

    public void removeByID(int itemID){
        if(head == null){
            System.out.println("Inventory is empty.");
            return;
        }
        if(head.itemID == itemID){
            head = head.next;
            System.out.println("Item with ID "+itemID+ " removed successfully.");
            return;
        }
        Node current = head;
        while(current.next!=null && current.next.itemID != itemID){
            current = current.next;
        }
        if(current.next == null){
            System.out.println("Item with ID "+itemID+ " not found.");
        }else{
            current.next = current.next.next;
            System.out.println("Item with ID "+itemID+ " removed successfully.");
        }
    }

    public void updateQuantity(int itemID, int newQuantity) {
        Node current = head;
        while (current != null) {
            if (current.itemID == itemID) {
                current.quantity = newQuantity;
                System.out.println("Quantity for Item ID " + itemID + " updated to " + newQuantity);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemID + " not found.");
    }

    public void searchItem(String keyword) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (String.valueOf(current.itemID).equals(keyword)
                    || current.itemName.equalsIgnoreCase(keyword)) {
                System.out.printf("%-10d %-15s %-10d %-10.2f\n",
                        current.itemID, current.itemName, current.quantity, current.price);
                found = true;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("No item found with ID or Name: " + keyword);
    }
    public void calculateTotalValue(){
        double totalValue = 0;
        Node current = head;
        while(current!=null){
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        System.out.println("Total Inventory Value "+totalValue);
    }

    public void display(){
        if(head == null){
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-10s\n", "ItemID", "Name", "Quantity", "Price");
        System.out.println("---------------------------------------------------");

        Node current = head;
        while(current!= null){
            System.out.printf("%-10d %-15s %-10d %-10.2f\n",current.itemID, current.itemName, current.quantity, current.price);
            current = current.next;
        }
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InventoryList list = new InventoryList();
        int choice;

        do{
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Specific Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by ID/Name");
            System.out.println("7. Display Inventory");
            System.out.println("8. Calculate Total Value");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Item Name, ID, Quantity, Price:");
                    list.addAtBeginning(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Item Name, ID, Quantity, Price:");
                    list.addAtEnd(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter Item Name, ID, Quantity, Price, Position:");
                    list.addAtPosition(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    list.removeByID(sc.nextInt());
                    break;
                
                case 5:
                    System.out.print("Enter Item ID and New Quantity: ");
                    list.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Item ID or Name to search: ");
                    list.searchItem(sc.next());
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    list.calculateTotalValue();
                    break;

                case 0:
                    System.out.println("Exiting... Thank you");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while(choice!=0);
        sc.close();
    }
}
