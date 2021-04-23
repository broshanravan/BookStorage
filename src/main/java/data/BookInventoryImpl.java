package data;

import beans.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BookInventoryImpl implements BookInventory{

    final static Logger logger = Logger.getLogger(BookInventoryImpl.class);

    private static Map<String, Book> booksMap = new TreeMap<>();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String bookJsonString = "";

    /**
     * transfers all the records in the JSON
     * file into a map for manipulation
     * search and eas of access
     */
    static{

        try {
            /** create a reader*/
            File jsonFile = new File("src/main/resources/library.json");

            BufferedReader bufferReader = new BufferedReader(new FileReader(jsonFile));
            Gson gson = new Gson();

            List<Book> bookList = gson.fromJson(bufferReader,new TypeToken<List<Book>>(){}.getType());
            System.out.println("The length of Items list Is: " + bookList.size());

            for (Book  book : bookList) {
                booksMap.put(book.getBarCode(),book);
            }



            /** convert JSON file contents to a map */
        } catch (IOException | NullPointerException ioe ){
            ioe.printStackTrace();
        }

    }

    /**
     * returns booking details using the bar code
     * from the map containing books
     * @param barcode
     * @return
     */
    public Book getBookByBarcode(String barcode){
        Book book = booksMap.get(barcode);

        return book;
    }

    /**
     * Adds details of the new book to
     * both JSON file and the local
     * map holding all books details
     * simultaneously
     * @param book
     */
    public void addBookToInventory(Book book){
        booksMap.put(book.getBarCode(), book);
        updateJsonFile();
    }

    /**
     * updates contents of the JSON  data
     * file according to the new data
     * inside the Map
     */
    private void updateJsonFile(){

        try{

            booksMap.entrySet().stream().forEach(entry -> {addToJson(entry.getValue());});

            FileWriter fileWriter = new FileWriter("src/main/resources/library.json");
            fileWriter.write(bookJsonString);
            fileWriter.flush();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * build up the JSON string
     * accoud
     * @param book
     */
    private void  addToJson(Book book){
        bookJsonString = bookJsonString + gson.toJson(book);
    }

    /**
     * removes details of the the book of
     * both JSON file and the local
     * map holding all books details
     * simultaneousl
     * @param barcode
     */
    public void removeBookFromInventory(String barcode){
        booksMap.remove(barcode);
        /**
         * removing book from
         * the json file
         */


    }

    /**
     * updating the details of an
     * existing book both in the
     * local map and in the JSON inventory
     * @param book
     */
    public void updateBookDetail(Book book){
        booksMap.put(book.getBarCode(), book);

    }


    /**
     * Checking if the barcode is in use
     * in which case the item will not
     * be added and the user gets an error
     * message
     * @param barcode
     * @return
     */
    public boolean isBarCodeInUse(String barcode){
        boolean barcodeInUse=  booksMap.containsKey(barcode);

        return barcodeInUse;
    }

    public String getFileName(String fileKey) {
        Properties properties = new Properties();
        String fileName = "";
        try {
            File file = new File("storage.properties");
            FileInputStream fileInput = new FileInputStream(file);

            properties.load(fileInput);
            fileName =properties.getProperty(fileKey);
            fileInput.close();

        } catch (FileNotFoundException e) {
            logger.error("error, the file storage.properties does not exist");
        } catch (IOException e) {
            logger.error("error,  reading the file storage.properties");
        }
        return fileName;
    }
}
