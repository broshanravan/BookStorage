package data;

import beans.Book;

public interface BookInventory {

    public Book getBookByBarcode(String barcode);

    public void addBookToInventory(Book Book);

    public void removeBookFromInventory(String barcode);

    public void updateBookDetail(Book book);

    public boolean isBarCodeInUse(String barcode);
}
