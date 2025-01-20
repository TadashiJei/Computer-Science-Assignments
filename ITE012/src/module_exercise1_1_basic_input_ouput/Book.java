package module_exercise1_1_basic_input_ouput;

/**
 * BARTOLOME,JAVA JAY J. 
 * ITE 012-IT12S13 
 * January 20, 2025
 * Week 1
 * Topic: Basic Input/Output
 */
public class Book {
    private int bookId;
    private String title;
    private String ISBN;
    private String category;

    // Default constructor
    public Book() {
    }

    // Getters and setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
