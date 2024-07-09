package com.library.utils;

import com.library.model.BookCopy;
import com.library.model.DataSource;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a utility class with basic operations as methods.
 * <p>
 * This class provides methods utilized for data type conversion, populating tables and other similar ones.
 * </p>
 *
 * @since 1.0
 * @author Loverary team
 */


public final class BasicUtils {

    /**
     * Converts an ArrayList instance into a multidimensional array used to populate a table</BookCopy>.
     * @param arrayList The ArrayList Instance returned by BookCopyDAO.getAllBookCopies().
     * @return String[][] instance.
     * @since 1.0
     */
    public static String[][] getRowArray(List<BookCopy> arrayList){
        int size = arrayList.size();
        var rowArray = new String[size][5];
        String[] bookCopyRow = new String[5];
        for(int i = 0; i < arrayList.size(); i++){
            bookCopyRow[0] = arrayList.get(i).getBarcode();
            bookCopyRow[1] = String.valueOf(arrayList.get(i).getBookId());
            bookCopyRow[2] = arrayList.get(i).getLocation();
            bookCopyRow[3] = arrayList.get(i).getCondition();
            bookCopyRow[4] = arrayList.get(i).isAvailable() ? "Yes" : "No";

            rowArray[i] = bookCopyRow;
        }
        System.out.println(Arrays.deepToString(rowArray));
        return rowArray;

}

/**
 * Retrieves the column names of any table.
 * @param tableName A table name from which we will get the column names from.
 * @return String[] instance
 * @since 1.0
 * @author Loverary team
 * */

public static String[] getColumns(String tableName, String schema) {
    var columns = new ArrayList<String>();
    String[] columnArray;
    try (var connection = DataSource.getConnection();
         var rs = connection.getMetaData().getColumns(null, schema, tableName, null)) {
        while (rs.next()) columns.add(rs.getString("COLUMN_NAME"));
        columnArray = new String[columns.size()];
        columnArray = columns.toArray(columnArray);

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    System.out.println(Arrays.toString(columnArray));
    return columnArray;
}

}