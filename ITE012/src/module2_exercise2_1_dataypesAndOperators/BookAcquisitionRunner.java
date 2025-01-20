package module2_exercise2_1_dataypesAndOperators;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * BARTOLOME, JAVA JAY J.
 * ITE 012-IT12S13
 * January 20, 2025
 * Topic: Application of Data Types and Operators
 */
public class BookAcquisitionRunner {
    public byte bookQuantity;
    public Float discountedBookPrice;
    public boolean orderBook = false;
    public float totalPrice;

    public static void main(String[] args) {
        BookAcquisitionRunner runner = new BookAcquisitionRunner();
        Supplier supplier = new Supplier();
        Book book = new Book();
        Author author = new Author();
        Scanner scanner = new Scanner(System.in);

        // Set orderBook to true to accept values
        runner.orderBook = true;

        if (runner.orderBook) {
            // Accept Supplier details using Scanner
            System.out.println("Enter Supplier Details:");
            System.out.print("Supplier ID: ");
            supplier.setSupplierId(scanner.nextInt());
            scanner.nextLine(); // Clear buffer

            System.out.print("Supplier Name: ");
            supplier.setSupplierName(scanner.nextLine());

            System.out.print("Supplier Address: ");
            supplier.setSupplierAddress(scanner.nextLine());

            System.out.print("Supplier Telephone Number: ");
            supplier.setSupplierTelephoneNumber(scanner.nextLong());
            scanner.nextLine(); // Clear buffer

            // Accept Book details using JOptionPane
            book.bookId = Short.parseShort(JOptionPane.showInputDialog("Enter Book ID:"));
            book.bookTitle = JOptionPane.showInputDialog("Enter Book Title:");
            book.bookPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter Book Price:"));
            book.bookCategory = JOptionPane.showInputDialog("Enter Book Category (single character):").charAt(0);

            // Accept Author details using Scanner
            System.out.println("\nEnter Author Details:");
            System.out.print("Author Last Name: ");
            author.bookAuthorLastname = scanner.nextLine();

            System.out.print("Author First Name: ");
            author.bookAuthorFirstname = scanner.nextLine();

            // Accept Book Quantity using JOptionPane
            runner.bookQuantity = Byte.parseByte(JOptionPane.showInputDialog("Enter Book Quantity:"));

            // Calculate discounts
            double baseDiscount = 0.0;
            // Quantity based discount using conditional operator
            baseDiscount = runner.bookQuantity >= 6 ? 0.50 : (runner.bookQuantity >= 4 ? 0.25 : 0.0);

            // Additional discounts using logical operators
            boolean sameBookAndAuthor = true; // This would normally be compared with existing data
            boolean sameCategoryAndAuthor = true; // This would normally be compared with existing data

            double additionalDiscount = 0.0;
            if (sameBookAndAuthor && sameCategoryAndAuthor) {
                additionalDiscount = 0.30; // Combined 10% + 20%
            } else if (sameBookAndAuthor) {
                additionalDiscount = 0.10;
            } else if (sameCategoryAndAuthor) {
                additionalDiscount = 0.20;
            }

            // Calculate total discount
            double totalDiscount = baseDiscount + additionalDiscount;
            runner.discountedBookPrice = (float)(book.bookPrice * totalDiscount);

            // Calculate total price with typecasting
            int quantityAsInt = (int)runner.bookQuantity;
            runner.totalPrice = quantityAsInt * (float)(book.bookPrice - runner.discountedBookPrice);
            double totalPriceAsDouble = (double)runner.totalPrice;

            // Display results
            String result = String.format("""
                \nOrder Summary:
                Supplier: %s
                Book: %s
                Author: %s %s
                Quantity: %d
                Original Price: $%.2f
                Discount Amount: $%.2f
                Total Price: $%.2f
                """,
                supplier.getSupplierName(),
                book.bookTitle,
                author.bookAuthorFirstname,
                author.bookAuthorLastname,
                quantityAsInt,
                book.bookPrice,
                runner.discountedBookPrice,
                totalPriceAsDouble
            );

            JOptionPane.showMessageDialog(null, result, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(result);
        }

        scanner.close();
    }
}
