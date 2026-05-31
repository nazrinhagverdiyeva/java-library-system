public class Library {

    private String libraryName;
    private Book[]  inventory;
    private int inventoryCount;

    //SETTER AND GETTERS
    public String getLibraryName() {
        return libraryName;
    }
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    public Book[] getInventory() {
        return inventory;
    }
    public void setInventory(Book[] inventory) {
        this.inventory = inventory;
    }
    public int getInventoryCount() {
        return inventoryCount;
    }
    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }


    //CONSTRUCTOR
    public Library(String libraryName, int capacity){
        this.libraryName = libraryName;
        this.inventory = new Book[capacity];
        this.inventoryCount = 0;
    }

    //METHODS
    void addBook(Book book){
        if (inventoryCount < inventory.length){
            inventory[inventoryCount] = book;
            inventoryCount++;
        } else {
            System.out.println("No space.");
        }
    }

    // Remove book by ID
    public void removeBook(int bookId){
        boolean found = false;
        for(int i = 0; i < inventoryCount; i++){
            if(inventory[i] != null && inventory[i].getBookId() == bookId){
                found = true;
                // Shift remaining books left
                for(int j = i; j < inventoryCount - 1; j++){
                    inventory[j] = inventory[j + 1];
                }
                inventory[inventoryCount - 1] = null;
                inventoryCount--;
                System.out.println("Book with ID " + bookId + " removed.");
                break;
            }
        }
        if(!found){
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }



// Search books by author name
public void searchBookByAuthor(String authorName){
    boolean found = false;
    for(int i = 0; i < inventoryCount; i++){
        Book book = inventory[i];
        if(book != null){
            for(int j = 0; j < book.getAuthorCount(); j++){
                Author author = book.getAuthorAt(j);
                if(author != null && author.getName().equalsIgnoreCase(authorName)){
                    book.displayBookInfo();
                    System.out.println("-----");
                    found = true;
                    break; // kitabın digər müəlliflərinə baxmağa ehtiyac yoxdur
                }
            }
        }
    }
    if(!found){
        System.out.println("No books found for author: " + authorName);
    }
}

// Calculate average price
public double getAveragePrice() {
    if (inventoryCount == 0) return 0.0;
    double total = 0.0;
    for (int i = 0; i < inventoryCount; i++) {
        total += inventory[i].getPrice();
    }
    return total / inventoryCount;
}

// Display all books
public void displayInventory(){
    System.out.println("Library: " + libraryName);
    for(int i = 0; i < inventoryCount; i++){
        if(inventory[i] != null){
            inventory[i].displayBookInfo();
            System.out.println("-----");
        }
    }
}
}