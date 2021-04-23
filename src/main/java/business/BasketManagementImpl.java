package business;

import beans.Book;

import java.util.LinkedList;
import java.util.List;

public class BasketManagementImpl implements BasketManagement{


    private List<Book> basketContents = new LinkedList<>();
    private double totalPrice;
    private double totalDiscount;
    private double discountedPrice;


    /**
     * return the total price before discount
     * applied
     * @return
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * returns total discount applied to the basket
     * @return
     */
    public double getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * trturns total price
     * after disount is applied
     * @return
     */
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    /**
     * Adds a new book to the basket
     * array containing selected books
     * @param book
     */
    public void addBookToBasket(Book book){
        basketContents.add(book);
    }

    /**
     * removes unwanted books from the
     * shopping book inside the basket
     * @param barcode
     */
    public void removeBookFromBasket(String barcode){
        for(int i = 0; i< basketContents.size(); i++){
            Book book = basketContents.get(i);
            if(barcode.equalsIgnoreCase(book.getBarCode())){
                basketContents.remove(i);
                break;
            }
        }
    }
}
