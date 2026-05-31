public class Book{

    private int bookID;
    private String title;
    private Author[] authors;
    private double price;
    private boolean isBorrowed;
    private int year;
    private int publisher;

    private int authorCount;

    public int getBookId() {
        return bookID;
    }public double getPrice() {
        return price;
    }
    public int getAuthorCount() {
        return authorCount;
    }
    public Author getAuthorAt(int index) {
        if(index >= 0 && index < authorCount) {
            return authors[index];
        } else {
            return null;
        }
    }

    //CONSTRUCTORS
    public Book(int bookID, String title, double price){
        this.bookID = bookID;
        this.title = title;
        setPrice(price);
        this.authors = new Author[5];
    }

    public Book(int bookID, String title, double price, int maxAuthors){
        this(bookID, title, price);
        this.authors = new Author[maxAuthors];
        setPrice(price);
    }

    //METHODS
    void addAuthor(Author author){
        if(this.authorCount<authors.length){
            authors[authorCount]=author;
            this.authorCount++;

            author.addBook(this);
        }else{
            System.out.println("The list is full!");
        }
    }

    public void setPrice(double price){
        if (price > 0){
            this.price = price;
        }else{
            System.out.println("Price cannot be negative!");
            this.price = 0;
        }
    }

    public void displayBookInfo(){
        System.out.println("ID: " + bookID + ", title: " + title+
                ", price: " + price);
        for (int i = 0; i < this.authorCount; i++) {  //Prints the list of authors using a loop
            System.out.println((i+1) + ". author: " + authors[i].getName());
        }
    }

    public void getReferenceAPA(){
        for(int i = 0; i < authorCount; i++){
            System.out.print(authors[i].getName());

            if(i < authorCount - 1){
                System.out.print(", ");
            }
        }

        System.out.println(" (" + year + "). " + title + ". " + publisher + ".");
    }

    @Override
    public String toString() {
        return "Title: " + title + " (ID: " + bookID + ")";
    }
}