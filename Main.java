public class Main {
    public static void main(String[] args) {
        // Testing Author(int, String) -> Default capacity 10
        Author author1 = new Author(1, "J.K. Rowling");

        // Testing Author(int, String, int) -> Custom capacity
        Author author2 = new Author(2, "George Orwell", 5);

        // Testing Book(int, String, double) -> Default capacity 5
        Book book1 = new Book(101, "Harry Potter", 25.5);

        // Testing Book(int, String, double, int) -> Custom capacity
        // This also tests the price validation logic
        Book book2 = new Book(102, "1984", 15.0, 3);
        Book book3 = new Book(103, "Animal Farm", -5.0); // Should be set to 0.0

        // Requirement: addAuthor must call author.addBook(this)
        book1.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author2);

        // 4. Initialize Library
        Library myLibrary = new Library("City Central Library", 10);
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        // 5. Display Information and Test Functionalities
        System.out.println("Library Inventory: ");
        myLibrary.displayInventory();

        System.out.println("\n Searching for Books by Author: George Orwell: ");
        // Search by author name requirement
        myLibrary.searchBookByAuthor("George Orwell");

        System.out.println("\nAverage Price Calculation: ");
        // Average price requirement
        System.out.println("Average Price: $" + myLibrary.getAveragePrice());

        System.out.println("\nAPA Reference Style: ");
        // APA 7th edition format test
        book1.getReferenceAPA();

        System.out.println("\nRemoving Book (ID: 102): ");
        // Search by ID, remove, and shift books
        myLibrary.removeBook(102);

        System.out.println("\nFinal Inventory After Removal: ");
        myLibrary.displayInventory();
        System.out.println("New Average Price: $" + myLibrary.getAveragePrice());
    }
}