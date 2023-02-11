/**
 *
 * @author Mahmoud Yasser
 */
public class Book {
    private String bookName;
    private String authorName;
    private double bookPrice;
    
    @Override
    public String toString() {
        return "Book name : " + bookName + ", Author : " + authorName + ", Price : " + bookPrice + '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    } 
     
}
