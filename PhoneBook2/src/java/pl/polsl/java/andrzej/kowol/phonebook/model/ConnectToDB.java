package pl.polsl.java.andrzej.kowol.phonebook.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletConfig;

/**
 * Class which is responsible for connection to the database.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class ConnectToDB {

    private Connection connection = null;

    /**
     * Method which is responsible for connection to the database.
     *
     * @param servletConfig Information about servlet
     * @return Connection into database
     * @throws SQLException Throws exception when there is problem with
     * connection.
     * @throws ClassNotFoundException Throws exception when class is not found.
     */
    public synchronized Connection getConnection(ServletConfig servletConfig) throws SQLException, ClassNotFoundException {
        if (connection == null) {
            if (servletConfig == null) {
            } else {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                connection = DriverManager.getConnection(
                        "jdbc:derby://localhost:1527/" + servletConfig.getInitParameter("url"),
                        servletConfig.getInitParameter("user"),
                        servletConfig.getInitParameter("password"));
            }
        }
        return connection;
    }
}
