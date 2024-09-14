package com.library.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.library.model.DataSource.*;

public class BookCopyDAO {

    // Create
    public void create(BookCopy bookCopy) throws SQLException {
        String sql = "INSERT INTO \"Library\".book_copy (book_id, condition, location, is_available, barcode) VALUES (?, ?, ?, ?, ?)";
        setMatchingFields(bookCopy, sql);
    }

    private void setMatchingFields(BookCopy bookCopy, String sql) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookCopy.getBookId());
            stmt.setString(2, bookCopy.getCondition());
            stmt.setString(3, bookCopy.getLocation());
            stmt.setBoolean(4, bookCopy.isAvailable());
            stmt.setString(5, bookCopy.getBarcode());
            stmt.executeUpdate();
        }
    }

    // Read
    public BookCopy read(String barcode) throws SQLException {
        String sql = "SELECT * FROM \"Library\".book_copy WHERE barcode = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barcode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BookCopy(
                        rs.getInt("book_id"),
                        rs.getString("condition"),
                        rs.getString("location"),
                        rs.getBoolean("is_available"),
                        rs.getString("barcode")
                );
            }
        }
        return null;
    }

    // Update
    public void update(BookCopy bookCopy) throws SQLException {
        String sql = "UPDATE \"Library\".book_copy SET book_id = ?, condition = ?, location = ?, is_available = ? WHERE barcode = ?";
        setMatchingFields(bookCopy, sql);
    }

    // Delete
    public void delete(String barcode) throws SQLException {
        String sql = "DELETE FROM \"Library\".book_copy WHERE barcode = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barcode);
            stmt.executeUpdate();
        }
    }

    // List all BookCopies
    public List<BookCopy> readAll() throws SQLException {
        List<BookCopy> bookCopies = new ArrayList<>();
        String sql = "SELECT * FROM \"Library\".book_copy";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                BookCopy bookCopy = new BookCopy(
                        rs.getInt("book_id"),
                        rs.getString("condition"),
                        rs.getString("location"),
                        rs.getBoolean("is_available"),
                        rs.getString("barcode")
                );
                bookCopies.add(bookCopy);
            }
        }
        return bookCopies;
    }
}
