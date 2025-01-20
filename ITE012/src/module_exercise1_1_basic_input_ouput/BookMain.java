package module_exercise1_1_basic_input_ouput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        try {
            // Create instances of input classes
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            // Create a Book instance
            Book book = new Book();
            
            // Get input using Scanner
            System.out.print("Enter Book ID: ");
            book.setBookId(scanner.nextInt());
            scanner.nextLine(); // Clear buffer
            
            System.out.print("Enter Title: ");
            book.setTitle(scanner.nextLine());
            
            // Get input using BufferedReader
            System.out.print("Enter ISBN: ");
            book.setISBN(reader.readLine());
            
            System.out.print("Enter Category: ");
            book.setCategory(reader.readLine());
            
            // Display the entered values
            System.out.println("\nEntered Book Details:");
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Category: " + book.getCategory());
            
            scanner.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
