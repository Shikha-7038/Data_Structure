import java.util.*;
class Customer{
    private String name;
    private String accountNumber;
    private double balance;

    public Customer(String name, String accountNumber, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void viewBalance(){
        System.out.println(name + " - Account: " + accountNumber + " | Balance: ₹" + balance);
    }
    public void deposit(double amount){
        balance += amount;
        System.out.println(name + " deposited ₹" + amount + ". New balance: ₹" + balance);
    }
    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println(name + " withdrew ₹" + amount + ". Remaining balance: ₹" + balance);
        }else{
            System.out.println(name+ ": Insufficient funds!");
        }
    }
    public String getName(){
        return name;
    }
}   
class Bank{
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName){
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }
    public void openAccount(Customer customer){
        customers.add(customer);
        System.out.println("Account for " + customer.getName() + " opened successfully at " + bankName);
    }
    public void showAllAccounts(){
        System.out.println("\n" + bankName + " - Customer Accounts:");
        for(Customer c: customers){
            c.viewBalance();
        }
    }
}
public class BankAssociationDemo {
    public static void main(String[] args){
        Bank bank1 = new Bank("National Bank");

        Customer c1 = new Customer("Neha", "ACC101", 15000.0);
        Customer c2 = new Customer("Shreya", "ACC1002", 25000.0);
        Customer c3 = new Customer("Naina", "ACC1003", 30000.0);

        bank1.openAccount(c1);
        bank1.openAccount(c2);
        bank1.openAccount(c3);

        bank1.showAllAccounts();

        System.out.println("Customer Actions");
        c1.deposit(5000);
        c2.withdraw(7000);
        c3.viewBalance();
    }
}
