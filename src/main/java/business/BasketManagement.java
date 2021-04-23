package business;

import beans.Book;

import java.util.List;

public interface BasketManagement {

    public List<Book> getBasketContents();

    public void addBookToBasket(Book book);

    public void removeBookFromBasket(String barcode);
}
