package pl.polsl.java.andrzej.kowol.phonebook.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class which is responsible for get information from database
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class GetAddresses {

    /**
     * Method which is responsible for get addresses from database
     *
     * @param con Information about connection to the database
     * @return String with result information
     */
    public String getData(Connection con) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Book");
            try {
                stringBuilder.append("<b><pre></tr><tr><td colspan=\"5\">");
                stringBuilder.append("ID");
                stringBuilder.append("\tName");
                stringBuilder.append("\t\t\t\tLast Name");
                stringBuilder.append("\t\t\t\tPhone Number");
                stringBuilder.append("</td></tr></pre></b>");
                while (rs.next()) {
                    stringBuilder.append("<pre></tr><tr><td colspan=\"3\">");
                    stringBuilder.append(rs.getString("id"));
                    stringBuilder.append("\t");
                    stringBuilder.append(rs.getString("name"));
                    stringBuilder.append("\t\t\t");
                    stringBuilder.append(rs.getString("lastName"));
                    stringBuilder.append("\t\t\t");
                    stringBuilder.append(rs.getString("phoneNumber"));
                    stringBuilder.append("</td></tr></pre>");
                };
                rs.close();
                statement.close();
            } catch (SQLException e) {
                stringBuilder.append("There is an exception with message: ").append(e.getMessage());
            } catch (Exception e) {
                stringBuilder.append("There is an exception with message: ").append(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {
            stringBuilder.append("There is an exception with message: ").append(e.getMessage());
        }
        return stringBuilder.toString();
    }
}
