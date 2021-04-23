package business;

import beans.Book;

import java.util.List;

public interface Checkout {

    public double calculateTotalPrice(List<Book> basketContents);

    public double getTotalDiscount();

    public double getTotalPriceBeforeDiscount();

    public double getTotalPriceAfterDiscount();

}
