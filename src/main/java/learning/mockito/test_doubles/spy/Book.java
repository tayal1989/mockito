package learning.mockito.test_doubles.spy;

import java.time.LocalDate;

public class Book {
    private String bookId;
    private String bookTitle;
    private double bookPrice;
    private LocalDate publishedDate;

    public Book(String bookId, String bookTitle, double bookPrice, LocalDate publishedDate) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.publishedDate = publishedDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + ", publishedDate=" + publishedDate + '}';
    }

}
