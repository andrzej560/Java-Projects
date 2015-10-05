package pl.polsl.java.andrzej.kowol.phonebook.controller;


import pl.polsl.java.andrzej.kowol.phonebook.model.GetAddresses;
import pl.polsl.java.andrzej.kowol.phonebook.model.AddAddress;
import pl.polsl.java.andrzej.kowol.phonebook.model.ConnectToDB;
import pl.polsl.java.andrzej.kowol.phonebook.model.RemoveAddress;
import pl.polsl.java.andrzej.kowol.phonebook.view.View;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Main servlet of application
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/PhoneBook"})
public class PhoneBook extends HttpServlet {

    private String action;
    final int time = 1800; //time of session in seconds

    /**
     * Method which handles the HTTP GET method.
     *
     * @param request Request of servlet
     * @param response Response of servlet
     * @throws ServletException if there is an error with servlet
     * @throws IOException if there is any problem with input/output
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Method which handles the HTTP POST method.
     *
     * @param request Request of servlet
     * @param response Response of servlet
     * @throws ServletException if there is an error with servlet
     * @throws IOException if there is any problem with input/output
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ConnectToDB connectToDB = new ConnectToDB();
        String getParameter = request.getParameter("data");
        HttpSession session = request.getSession();
        Connection connection = null;
        String result = "";

        response.setContentType("text/html; charset=ISO-8859-2");
        View view = new View(response.getWriter());

        try {
            connection = connectToDB.getConnection(this.getServletConfig());
        } catch (ClassNotFoundException | SQLException e) {
            view.printError();
        }
        if (getParameter != null) {
            action = getParameter;
        }

        switch (action) {
            case "addData":
                String name = request.getParameter("name");
                String lastName = request.getParameter("lastName");
                String phoneNumber = request.getParameter("phoneNumber");
                try {
                    if (!name.equals("") && !lastName.equals("") && !phoneNumber.equals("")) {
                        int phoneData = Integer.parseInt(phoneNumber);
                        AddAddress addToDatabase = new AddAddress();
                        result = addToDatabase.add(name, lastName, phoneData, connection);
                    }
                } catch (NullPointerException e) {
                } catch (NumberFormatException e) {
                    result = "You insert inappropriate value";
                }
                view.printAddAddressForm(result);
                session.setMaxInactiveInterval(time);
                break;

            case "viewData":
                GetAddresses getAddresses = new GetAddresses();
                view.printGetAddressesForm(getAddresses.getData(connection));
                session.setMaxInactiveInterval(time);
                break;

            case "createTables":
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("CREATE TABLE Book "
                            + "(id INTEGER PRIMARY KEY, name VARCHAR(50), "
                            + "lastName VARCHAR(50), phoneNumber INTEGER )");
                    result = "You created database";
                    statement.close();
                } catch (SQLException | NullPointerException e) {
                    result = "There is an exception. Tables probably already exists or there is an error with connection into database";
                }

                PrintWriter out = response.getWriter();
                view.printCreateForm(result);
                session.setMaxInactiveInterval(time);
                break;

            case "removeData":
                String id = request.getParameter("idInput");
                try {
                    if (!id.equals("")) {
                        int idValue = Integer.parseInt(id);
                        RemoveAddress removeFromDatabase = new RemoveAddress();
                        result = removeFromDatabase.remove(idValue, connection);
                    }
                } catch (NullPointerException e) {
                } catch (NumberFormatException e) {
                    result = "You insert inappropriate value";
                }
                view.printRemoveForm(result);
                session.setMaxInactiveInterval(time);
                break;
        }
    }
}
