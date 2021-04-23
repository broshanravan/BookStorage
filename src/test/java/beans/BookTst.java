package beans;

import org.junit.Test;

public class BookTst {

    @Test
    public void testConstructor(){
        Book book = new Book("ASE4TRF7", "Cyropaedia","Xenphone" , 34.60, 1995, 1);
        assert ("ASE4TRF7".equals(book.getBarCode()));
        assert("Cyropaedia".equals(book.getName()));
        assert("Xenphone".equals(book.getAuthor()));
        assert(book.getPrice() == 34.6);
        assert(book.getYearOfPublish() ==1995);
        assert(book.getScienceIndex() == 1);

    }

}
