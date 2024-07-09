package com.library.model;
import java.util.Objects;

public class BookCopy {

    private int bookId;
    private String condition;
    private String location;
    private boolean isAvailable;
    private String barcode;

    // Constructor
    public BookCopy(int bookId, String condition, String location, boolean isAvailable, String barcode) {
        this.bookId = bookId;
        this.condition = condition;
        this.location = location;
        this.isAvailable = isAvailable;
        this.barcode = barcode;
    }

    // Default constructor
    public BookCopy() {
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "BookCopy{" +
                "bookId=" + bookId +
                ", condition='" + condition + '\'' +
                ", location='" + location + '\'' +
                ", isAvailable=" + isAvailable +
                ", barcode='" + barcode + '\'' +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCopy bookCopy = (BookCopy) o;
        return bookId == bookCopy.bookId &&
                isAvailable == bookCopy.isAvailable &&
                Objects.equals(condition, bookCopy.condition) &&
                Objects.equals(location, bookCopy.location) &&
                Objects.equals(barcode, bookCopy.barcode);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(bookId, condition, location, isAvailable, barcode);
    }
}
