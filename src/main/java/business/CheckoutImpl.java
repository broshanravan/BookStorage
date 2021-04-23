package business;

import beans.Book;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class CheckoutImpl implements Checkout{

    private double totalDiscount;
    private double totalPriceBeforeDiscount;
    private double totalPriceAfterDiscount;

    /**
     * returns the total discount
     * on basket items
     * @return
     */
    public double getTotalDiscount(){
        return totalDiscount;
    }

    /**
     * returns total gross
     * price Before any
     * discounts are applied
     * @return
     */
    public double getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    /**
     * returns total net price after
     * all discounts are applied
     * @return
     */
    public double getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    /**
     * calculoating the price
     * the price according the books
     * year of publish and scientific factor
     * @return
     */
    public double calculateTotalPrice(List<Book> basketContents){
        double finalPrice = 0;
        for(Book book : basketContents){
            if(book.getScienceIndex() >1 && book.getYearOfPublish()<1900){
                finalPrice += calculateCombinedPrice(book);
                finalPrice = getTwoDecimalValue(finalPrice);
            } else if (book.getScienceIndex() > 1){
                finalPrice += calculateScientificPrice(book);
                finalPrice = getTwoDecimalValue(finalPrice);
            }else if(book.getYearOfPublish()<1900){
                finalPrice += calculateAntiquePrice(book);
                finalPrice = getTwoDecimalValue(finalPrice);
            } else{
                finalPrice += book.getPrice();
                finalPrice = getTwoDecimalValue(finalPrice);
            }
        }

        return  finalPrice;
    }

    /**
     * calcumates the price when the book
     * is antique
     * @param book
     * @return
     */
    private double calculateAntiquePrice(Book book){
        double antiquePrice = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        antiquePrice = (currentYear - book.getYearOfPublish())/10;
        antiquePrice = getTwoDecimalValue(antiquePrice);

        return antiquePrice;
    }

    /**
     * calculate price when the book is
     * Scientific
     * @param book
     * @return
     */
    private double calculateScientificPrice(Book book){
        double scientificTypePrice = book.getPrice();
        scientificTypePrice = scientificTypePrice * book.getScienceIndex();
        scientificTypePrice = getTwoDecimalValue(scientificTypePrice);

        return scientificTypePrice;
    }

    /**
     * calculates the price when the book is both
     * scientific and Antique
     * @param book
     * @return
     */
    private double calculateCombinedPrice(Book book){
        double scientificBookPrice = calculateScientificPrice(book);
        book.setPrice(scientificBookPrice);
        double combinedBookPrice = calculateAntiquePrice(book);
        combinedBookPrice = getTwoDecimalValue(combinedBookPrice);

        return combinedBookPrice;
    }

    private double getTwoDecimalValue(double priceIn){
        DecimalFormat decimalformat = new DecimalFormat("#.##");
        String num = String.valueOf(priceIn);
        String formatedStr = decimalformat.format(num);
        double price = Double.parseDouble(formatedStr);
        return price;
    }

}
