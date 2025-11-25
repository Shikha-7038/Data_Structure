import java.util.ArrayList;
class Book{
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public void displayBook(){
        System.out.println("Book Title: "+title);
        System.out.println("Book Author: "+author);
    }
}
class Library{
    private String name;
    private ArrayList<Book> books;

    public Library(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }

    public void displayLibrary(){
        System.out.println("Library: "+name);
        System.out.println("Books in this library.");
        for(Book book : books){
            book.displayBook();
        }
    }
}
public class LibraryAggregationDemo{
    public static void main(String[] args){
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Clean Code", "Robert C. Martin");
        Book b4 = new Book("The Pragmatic Programmer", "Andrew Hunt");

        Library cityLibrary = new Library("City Central Library");
        Library collegeLibrary = new Library("College Library");

        cityLibrary.addBook(b3);
        cityLibrary.addBook(b2);

        collegeLibrary.addBook(b3);
        collegeLibrary.addBook(b4);
        collegeLibrary.addBook(b1);

        cityLibrary.displayLibrary();
        collegeLibrary.displayLibrary();
    }
}