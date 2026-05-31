public class Author {
    private int authorID;
    private String name;
    private Book[] booksWritten;
    private int bookCount;

    //GETTERS AND SETTERS
    public int getAuthorId() {
        return authorID;
    }
    public int getBookCount() {
        return bookCount;
    }
    public String getName() {
        return name;
    }
    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    //CONSTRUCTORS
    public Author(int authorID, String name){
        this.authorID = authorID;
        this.name = name;
        this.booksWritten = new Book[10];
    }

    public Author(int authorID, String name, int maxBooks){
        this(authorID, name);
        this.booksWritten = new Book[maxBooks];

    }

    //METHODS
    void addBook(Book book){
        if (bookCount < booksWritten.length) {
            booksWritten[bookCount] = book;
            bookCount++;
        }
    }

    void displayAuthorInfo(){
        System.out.println("Author ID: " + getAuthorId() +
                 ", Name: " + getName());
        for(int i = 0; i < bookCount; i++){
            System.out.println(booksWritten[i]);
        }
    }

}
