package beans;

public class Book {
    private String barCode;
    private String name;
    private String author;
    private double price;
    private long yearOfPublish;
    private int scienceIndex;

    public Book(String barCode, String name, String author, double price, long yearOfPublish, int scienceIndex) {
        this.barCode = barCode;
        this.name = name;
        this.author = author;
        this.price = price;
        this.yearOfPublish = yearOfPublish;
        this.scienceIndex = scienceIndex;
    }

    public Book(){

    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(long yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getScienceIndex() {
        return scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        this.scienceIndex = scienceIndex;
    }
}
