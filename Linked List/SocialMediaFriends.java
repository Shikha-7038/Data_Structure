import java.util.*;
public class SocialMediaFriends {
    class UserNode{
        int userID;
        String name;
        int age;
        ArrayList<Integer> friends;
        UserNode next;

        UserNode(int userID, String name, int age){
            this.userID = userID;
            this.name= name;
            this.age = age;
            this.friends = new ArrayList<>();
            this.next = null;
        }
    }
    private UserNode head = null;

    public void addUser(int userID, String name, int age){
        UserNode newUser = new UserNode(userID, name, age);
        if(head == null){
            head = newUser;
        }else{
            UserNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newUser;
        }
        System.out.println("User "+name+ " added successfully!");
    }

    private UserNode findUser(int userID){
        UserNode current = head;
        while(current!=null){
            if(current.userID == userID)
                return current;
            current = current.next;
        }
        return null;
    }
    public void addFriendConnection(int user1ID,int user2ID){
        UserNode user1 = findUser(user1ID);
        UserNode user2 = findUser(user2ID);

        if(user1 == null || user2 == null){
            System.out.println("One or both users not found!");
            return;
        }
        if(user1ID == user2ID){
            System.out.println("A user cannot be friends with themselves!");
            return;
        }
        if(!user1.friends.contains(user2ID)){
            user1.friends.add(user2ID);
        }
        if(!user2.friends.contains(user1ID)){
            user2.friends.add(user1ID);
        }
        System.out.println("Friendship created between " + user1.name + " and " + user2.name);
    }

    public void removeFriendConnection(int user1ID, int user2ID){
        UserNode user1 = findUser(user1ID);
        UserNode user2 = findUser(user2ID);

        if(user1 == null || user2 == null){
            System.out.println("One or both users not found!");
        }
        if (user1.friends.remove(Integer.valueOf(user2ID)) &&
            user2.friends.remove(Integer.valueOf(user1ID))) {
            System.out.println("Friendship removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Friendship does not exist between the users.");
        }
    }

    public void displayFriends(int userID){
        UserNode user = findUser(userID);
        if(user == null){
            System.out.println("User not found.");
            return;
        }
        System.out.println("\n User: " + user.name + " (ID: " + user.userID + ")");
        if(user.friends.isEmpty()){
            System.out.println("No friends yet.");
            return;
        }
        System.out.println("Friends: ");
        for(int friendID : user.friends){
            UserNode friend = findUser(friendID);
            if(friend!=null){
                System.out.println(" - " + friend.name + " (ID: " + friend.userID + ")");
            }
        }
    }

    public void countFriendsForAllUsers(){
        if(head == null){
            System.out.println("No users in the network.");
            return;
        }
        System.out.println("\n Friend Count for Each User:");
        UserNode current = head;
        while(current!=null){
            System.out.println(current.name + " (" + current.userID + ") ➜ " + current.friends.size() + " friends");
            current = current.next;
        }
    }

    public void displayAllUsers(){
        if(head == null){
            System.out.println("No user found.");
            return;
        }
        System.out.println("\n All Users in Network:");
        UserNode current = head;
        while(current!= null){
            System.out.println("ID: " + current.userID + " | Name: " + current.name + " | Age: " + current.age);
            current = current.next;
        }
    }

    public void searchUser(String key) {
        UserNode current = head;
        boolean found = false;
        while (current != null) {
            if (String.valueOf(current.userID).equals(key) || current.name.equalsIgnoreCase(key)) {
                System.out.println("✅ User Found: ID = " + current.userID + ", Name = " + current.name + ", Age = " + current.age);
                found = true;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("⚠️ No user found with key: " + key);
    }

    public void findMutualFriends(int user1ID, int user2ID) {
        UserNode user1 = findUser(user1ID);
        UserNode user2 = findUser(user2ID);

        if (user1 == null || user2 == null) {
            System.out.println("⚠️ One or both users not found!");
            return;
        }

        System.out.println("\n👬 Mutual Friends between " + user1.name + " and " + user2.name + ":");
        boolean hasMutual = false;
        for (int f1 : user1.friends) {
            if (user2.friends.contains(f1)) {
                UserNode mutual = findUser(f1);
                if (mutual != null) {
                    System.out.println(" - " + mutual.name + " (ID: " + mutual.userID + ")");
                    hasMutual = true;
                }
            }
        }
        if (!hasMutual)
            System.out.println("No mutual friends found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMediaFriends network = new SocialMediaFriends();
        int choice;

        do{
            System.out.println("\nSocial Media Friend Connection System ===");
            System.out.println("1. Add New User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display All Users");
            System.out.println("5. Display Friends of a User");
            System.out.println("6. Count Friends for All Users");
            System.out.println("7. Search for a User (by ID or Name)");
            System.out.println("8. Find Mutual Friends Between Two Users");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter User ID, Name, Age:");
                    network.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;

                case 2:
                    System.out.println("Enter two User ID to connect:");
                    network.addFriendConnection(sc.nextInt(), sc.nextInt());
                    break;

                case 3:
                    System.out.println("Enter two User ID to disconnect:");
                    network.removeFriendConnection(sc.nextInt(), sc.nextInt());
                    break;

                case 4:
                    network.displayAllUsers();
                    break;

                case 5:
                    System.out.println("Enter User ID to display friends:");
                    network.displayFriends(sc.nextInt());
                    break;

                case 6:
                    network.countFriendsForAllUsers();
                    break;

                case 7:
                    System.out.println("Enter User ID or Name to search:");
                    network.searchUser(sc.next());
                    break;
                case 8:
                    System.out.println("Enter two User IDs to find mutual friends:");
                    network.findMutualFriends(sc.nextInt(), sc.nextInt());
                    break;

                case 0:
                    System.out.println("Exiting.... Goodbye");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }while(choice!=0);
        sc.close();
    }
}

