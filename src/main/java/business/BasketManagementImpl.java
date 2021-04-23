package business;

import beans.Book;

import java.util.LinkedList;
import java.util.List;

public class BasketManagementImpl implements BasketManagement{


    private List<Book> basketContents = new LinkedList<>();;

    public List<Book> getBasketContents() {
        return basketContents;
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
