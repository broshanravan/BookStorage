import beans.Book;
import business.BasketManagement;
import business.BasketManagementImpl;
import business.Checkout;
import business.CheckoutImpl;
import data.BookInventory;
import data.BookInventoryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerCheckout {

    public void startPurchase(){

        List<Book> basket = new LinkedList<>();
        BookInventory bookInventory= new BookInventoryImpl();
        Checkout checkout = new CheckoutImpl();
        BasketManagement basketManagement = new BasketManagementImpl();

        double totalPrice = 0;
        double combinedDiscount = 0;
        double finalPrice = 0;


        System.out.println("==========================================Start Shopping======================================================");
        System.out.println("Please enter the barcode");
        System.out.println("Enter 'end' to complete the shopping");

        Scanner scanner = new Scanner(System.in);
        String barCode = scanner.nextLine();
        while(barCode == null || "".equalsIgnoreCase(barCode.trim())){
            System.out.println("No barcode entered, please try again");
            barCode = scanner.nextLine();
        }

        while(!"end".equalsIgnoreCase(barCode)){
            Book book = bookInventory.getBookByBarcode(barCode);
            if(book == null || book.getName() == null ){
                System.out.println("invalid bar code. Tru Again (or 'end' to finish) :\t ");
                barCode = scanner.nextLine();
            }else {
                System.out.print( book.getName());
                System.out.println("\t\t" + book.getPrice());
                totalPrice = totalPrice + book.getPrice();
                basketManagement.addBookToBasket(book);

                System.out.println("Next bar code (or 'end' to finish) :\t ");
                barCode = scanner.nextLine();
            }

        }

        finalPrice = checkout.calculateTotalPrice(basketManagement.getBasketContents());
        combinedDiscount = totalPrice - finalPrice;


        System.out.println("|---------------------------------------------------------------------------------------------------");

        System.out.print(String.format("| " + "%1s", "Total Price"));
        System.out.print(String.format("%41s", "£"+String.format ("%.2f", totalPrice)));
        System.out.println(String.format("%47s", "|"));

        System.out.print(String.format("| "+ "%1s", "Combined Promotional Discount "));
        System.out.print(String.format("%22s", "£" + String.format ("%.2f", combinedDiscount)));
        System.out.println(String.format("%47s", "|"));


        System.out.print(String.format("| " + "%1s", "Final Price "));
        System.out.print(String.format("%40s", "£" +String.format ("%.2f", finalPrice)));
        System.out.println(String.format("%47s", "|"));

        System.out.println("|**************************************************************************************************|");

    }


    public static void main(String[] args){

        CustomerCheckout customerCheckout = new CustomerCheckout();
        customerCheckout.startPurchase();

    }
}
