package pl.polsl.java.andrzej.kowol.phonebook.model;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class which is responsible for remove address from database
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class RemoveAddress {

    /**
     * Method which is responsible for remove address from database
     *
     * @param id Id of deleted address
     * @param con Information about connection to the database
     * @return String with result information
     */
    public String remove(int id, Connection con) {
        String result;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE FROM Book WHERE id = " + id + "");
            result = "Successfully deleted record with id:  " + id;
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            result = "There is an exception: " + e.getMessage();
        }
        return result;
    }
}
