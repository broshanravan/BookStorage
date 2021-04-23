package business;

import beans.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class CheckoutTst {

    Checkout chechout = new CheckoutImpl();
    List<Book> basket_1 = new LinkedList<>();
    List<Book> basket_2 = new LinkedList<>();
    List<Book> basket_3 = new LinkedList<>();
    List<Book> basket_4 = new LinkedList<>();


    @Before
    public void setupTestData(){
        Book Cyropaedia = new Book("A7SE4TRF7", "Cyropaedia","Xenphone" , 34.60, 1995, 1);
        Book Shahnameh = new Book("45E343S5D", "Shah-Nameh","Ferdosi" , 52.20, 983, 1);
        Book welcomeToUniverse = new Book("D45R6TH67", "Welcome To Universe","Neil DeGrass Tyson" , 43.90, 1995, 3);
        basket_1.add(Cyropaedia);

        basket_2.add(Cyropaedia);
        basket_2.add(Shahnameh);

        basket_3.add(welcomeToUniverse);
        basket_3.add(Cyropaedia);
        basket_3.add(Cyropaedia);

        basket_4.add(Cyropaedia);
        basket_4.add(Shahnameh);
        basket_4.add(welcomeToUniverse);
        basket_4.add(Cyropaedia);

    }


    @Test
    public void testGetPrice(){
        double price = chechout.calculateTotalPrice(basket_1);
        assert (price == 34.6);
    }

    @Test
    public void testGetScientificPrice(){
       double price = chechout.calculateTotalPrice(basket_3);
       assert(price == 200.9);
    }

    @Test
    public void testAntiquePrice(){
        double price = chechout.calculateTotalPrice(basket_2);
        assert(price == 137.6);
    }

    @Test
    public void testCombinedPrice(){
        double price = chechout.calculateTotalPrice(basket_4);
        assert(price == 303.9);

    }


}
