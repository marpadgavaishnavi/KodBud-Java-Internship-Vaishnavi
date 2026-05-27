import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println("--------------------------------");
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Status  : " + (isIssued ? "Issued" : "Available"));
    }
}

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Count Total Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    issueBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    countBooks();
                    break;
                case 8:
                    System.out.println("Thank you for using Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book added successfully.");
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- All Books ---");
        for (Book book : books) {
            book.displayBook();
        }
    }

    static void searchBook() {
        System.out.print("Enter title to search: ");
        String searchTitle = sc.nextLine();

        boolean found = false;

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("Book found:");
                book.displayBook();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();

        boolean removed = false;

        for (Book book : books) {
            if (book.bookId == id) {
                books.remove(book);
                System.out.println("Book removed successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Book ID not found.");
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.bookId == id) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.bookId == id) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    static void countBooks() {
        System.out.println("Total Books = " + books.size());
    }
}
