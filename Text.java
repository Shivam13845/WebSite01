import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getDetails() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}

public class Text {

    private static ArrayList<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    searchBookByTitle(scanner);
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year of publication: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Book newBook = new Book(title, author, year);
        library.add(newBook);
        System.out.println("Book added successfully!");
    }

    public static void viewAllBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\nAll Books in Library:");
            for (Book book : library) {
                System.out.println(book.getDetails());
            }
        }
    }

    public static void searchBookByTitle(Scanner scanner) {
        System.out.print("Enter the title of the book to search: ");
        String title = scanner.nextLine();
        boolean found = false;

        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getDetails());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void deleteBook(Scanner scanner) {
        System.out.print("Enter the title of the book to delete: ");
        String title = scanner.nextLine();
        boolean removed = false;

        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                library.remove(book);
                System.out.println("Book removed successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Book not found.");
        }
    }
}
