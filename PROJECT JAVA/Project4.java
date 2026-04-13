import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private boolean isAvailable;


    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }


    String getTitle() {
        return title;
    }

    boolean isAvailable() {
        return isAvailable;
    }


    void issue() {
        isAvailable = false;
    }


    void returnBook() {
        isAvailable = true;
    }


    void display() {
        System.out.println(title + " by " + author + 
            " - " + (isAvailable ? "Available" : "Issued"));
    }
}


class Library {
    private Book[] books;


    Library() {
        books = new Book[3];

        books[0] = new Book("Java Basics", "James Gosling");
        books[1] = new Book("Data Structures", "Mark Weiss");
        books[2] = new Book("Python Fundamentals", "Guido van Rossum");
    }


    void searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                b.display();
                return;
            }
        }
        System.out.println("Book not found");
    }


    void issueBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {

                if (b.isAvailable()) {
                    b.issue();
                    System.out.println("Book issued successfully");
                } else {
                    System.out.println("Book already issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }


    void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {

                if (!b.isAvailable()) {
                    b.returnBook();
                    System.out.println("Book returned successfully");
                } else {
                    System.out.println("Book was not issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    
    void showBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.print((i + 1) + ". ");
            books[i].display();
        }
    }
}


public class project4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        int choice;

        do {
            System.out.println("\n📚 LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Show Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    lib.showBooks();
                    break;

                case 2:
                    System.out.print("Enter book title to search: ");
                    String search = sc.nextLine();
                    lib.searchBook(search);
                    break;

                case 3:
                    System.out.print("Enter book title to issue: ");
                    String issue = sc.nextLine();
                    lib.issueBook(issue);
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    String ret = sc.nextLine();
                    lib.returnBook(ret);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
