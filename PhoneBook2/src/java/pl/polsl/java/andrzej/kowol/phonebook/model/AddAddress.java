package pl.polsl.java.andrzej.kowol.phonebook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is responsible for adding address into database.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class AddAddress {

    /**
     * Method which is responsible for adding new address into database.
     *
     * @param name String with name
     * @param lastName String with last name
     * @param phoneNumber Integer with information about phone number
     * @param con Information about connection to the database
     * @return String with result information.
     */
    public String add(String name, String lastName, int phoneNumber, Connection con) {
        String result;
        int lastID;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery("SELECT * FROM Book");
            try {
                rs.last();
                lastID = rs.getInt("id");
            } catch (SQLException e) {
                lastID = 0;
            }
            lastID++;

            PreparedStatement ps = con.prepareStatement("INSERT INTO Book VALUES (?, ?, ?, ?)");
            ps.setInt(1, lastID);
            ps.setString(2, name);
            ps.setString(3, lastName);
            ps.setFloat(4, phoneNumber);
            ps.execute();
            result = "You add new address into database";

        } catch (SQLException | ClassNotFoundException e) {
            result = "There is an exception: " + e.getMessage();
        }
        return result;
    }
}
