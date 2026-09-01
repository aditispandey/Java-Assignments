package library;
public class Book {
    int bookId;
    String title;
    String author;
    String category;
    double price;
    public Book(int bookId, String title, String author, String category, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }
    public double calculateDiscount() {
        if (price >= 1000) {
            return price * 0.15;
        } else if (price >= 500) {
            return price * 0.10;
        } else {
            return price * 0.05;
        }
    }
    public double calculateFinalPrice() {
        return price - calculateDiscount();
    }
    public void displayBook() {
        System.out.println("\n========== BOOK DETAILS ==========");
        System.out.println("Book ID       : " + bookId);
        System.out.println("Title         : " + title);
        System.out.println("Author        : " + author);
        System.out.println("Category      : " + category);
        System.out.println("Original Price: ₹" + price);
        System.out.println("Discount      : ₹" + calculateDiscount());
        System.out.println("Final Price   : ₹" + calculateFinalPrice());
        System.out.println("==================================");
    }
}