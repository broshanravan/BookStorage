package business;

import beans.Book;
import org.junit.Before;
import org.junit.Test;

public class BasketManagementTst {

    BasketManagement basketManagement = new BasketManagementImpl();
    Book Cyropaedia = null;
    @Before
    public void setupTestData(){
        Cyropaedia = new Book("A7SE4TRF7", "Cyropaedia","Xenphone" , 34.60, 1995, 1);
        Book Shahnameh = new Book("45E343S5D", "Shah-Nameh","Ferdosi" , 52.20, 983, 1);
        basketManagement.addBookToBasket(Cyropaedia);
        basketManagement.addBookToBasket(Shahnameh);

    }

    @Test
    public void addBookToBasketTst(){
        Book welcomeToUniverse = new Book("D45R6TH67", "Welcome To Universe","Neil DeGrass Tyson" , 43.90, 1995, 3);
        basketManagement.addBookToBasket(welcomeToUniverse);
        assert(basketManagement.getBasketContents().contains(welcomeToUniverse));

    }

    @Test
    public void removeBookFromBasketTst(){
        basketManagement.removeBookFromBasket("A7SE4TRF7");
        assert(!basketManagement.getBasketContents().contains(Cyropaedia));

    }

}
