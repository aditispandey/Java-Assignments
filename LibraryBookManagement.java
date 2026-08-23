import java.util.Scanner;
interface BookOperations{
    void displayBookDetails();
    void issueBook();
    void returnBook();
    double calculateDiscount(double percentage);
}
class Book implements BookOperations{
    final long isbn;
    String Title;
    String Author;
    float price;
    boolean issued;
    Book(long isbn, String Title ,String Author, float price){
        this.isbn = isbn;
        this.Title = Title;
        this.Author = Author;
        this.price = price;
        this.issued = false;
    }
    public void displayBookDetails(){
        System.out.println();
        System.out.println("--- BOOK DETAILS ---");
        System.out.println("ISBN   : "+isbn);
        System.out.println("Title  : "+Title);
        System.out.println("Author : "+Author);
        System.out.println("Price  : "+price);
        if(issued){
            System.out.println("Status : Issued");
        }
        else{
            System.out.println("Status : Available");
        }
        System.out.println("---------------------");
        System.out.println();
    };
    public void issueBook(){
        System.out.println();
        if(!issued){
            issued = true;
            System.out.println("Book issued successfully.");
        }
        else{
            System.out.println("Book is already issued.");
        }
        System.out.println();
    }
    public void returnBook(){
        System.out.println();
        if(issued){
            issued = false;
            System.out.println("Book returned successfully.");
        }
        else{
            System.out.println("Book was not issued.");
        }
        System.out.println();
    }
    public double calculateDiscount(double percentage){
        if (percentage > 0 && percentage <= 100){
            double discount = price*percentage /100;
            return price - discount;
        }
        else{
            System.out.println("Invalid discount percentage.");
            return price;
        }
    }
}
public class LibraryBookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book = new Book(9783060311279L, "Speak","Laurie Halse Anderson",678 );
        int choice;
        do { 
            System.out.println("======== LIBRARY BOOK MANAGEMENT ========");
            System.out.println("1. Display Book Details");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Calculate Discounted prince");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            System.out.println();
            switch(choice){
                case 1:
                    book.displayBookDetails();
                    break;
                case 2:
                    book.issueBook();
                    break;
                case 3:
                    book.returnBook();
                    break;
                case 4:
                    System.out.print("Enter discount percentage : ");
                    double percentage = sc.nextDouble();
                    double finalprice = book.calculateDiscount(percentage);
                    System.out.println("Price after discount : "+finalprice);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting Library Book Management System.");
            }
        } while (choice != 5);
        sc.close();
    }
}

