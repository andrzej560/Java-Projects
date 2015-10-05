package pl.polsl.java.andrzej.kowol.phonebook.view;


import java.io.PrintWriter;

/**
 * Class responsible for printing information on screen.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class View {

    /**
     * PrintWriter is responsible for printing strings.
     */
    private final PrintWriter printWriter;

    /**
     * Constructor with parameter.
     *
     * @param printWriter PrintWriter responsible for printing strings.
     */
    public View(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    /**
     * Method which is responsible for printing form of adding address procedure.
     * @param msg String with information which will be printed
     */
    public void printAddAddressForm(String msg) {
        printHeader();
        printWriter.print(
                "\t\t<h1>Add address into database:</h1>\n"
                + "\t<h2>" + msg + "</h2>\n"
                + "\t\t<form action=\"PhoneBook\" method=\"POST\">\n"
                + "\t\t\t<pre>\n"
                + "\t\t\t\t<p>Name:        <input type=text size=20 name=name></p>\n"
                + "\t\t\t\t<p>Last Name:   <input type=text size=20 name=lastName></p>\n"
                + "\t\t\t\t<p>Phone Number:<input type=text size=20 name=phoneNumber></p>\n"
                + "\t\t\t</pre>\n"
                + "\t\t\t<input type=\"submit\" value=\"Add Address\" /><br/>\n"
                + "\t\t</form>\n"
                + "\t\t<form action=\"index.html\" method=\"POST\">\n"
                + "\t\t\t<input type=\"submit\" value=\"Back\" />\n"
                + "\t\t</form>\n"
        );
        printFooter();
    }

    /**
     * Method which is responsible for printing form of get addresses procedure.
     * @param msg String with information which will be printed
     */
    public void printGetAddressesForm(String msg) {
        printHeader();
        printWriter.print("\t\t<h1>Your contacts from phone book:</h1>\n"
                + "\t" + msg + "\n"
                + "\t\t<form action=\"index.html\" method=\"POST\">\n"
                + "\t\t\t<input type=\"submit\" value=\"Go to homepage\" />\n"
                + "\t\t</form>\n"
        );
        printFooter();
    }

    /**
     * Method which is responsible for printing form of remove address procedure.
     * @param msg String with information which will be printed
     */
    public void printRemoveForm(String msg) {
        printHeader();
        printWriter.print(
                "\t\t<h1>Input id of address that you want to remove from database</h1>\n"
                + "\t" + msg + "\n"
                + "\t\t<form action=\"PhoneBook\" method=\"POST\">\n"
                + "\t\t\t<p>ID:\t<input type=text size=20 name=idInput></p>\n"
                + "\t\t\t<input type=\"submit\" value=\"Remove Address\" />\n"
                + "\t\t</form>\n"
                + "\t\t<form action=\"index.html\" method=\"POST\">\n"
                + "\t\t\t<input type=\"submit\" value=\"Back\" />\n"
                + "\t\t</form>\n"
        );
        printFooter();
    }

    /**
     * Method which is responsible for printing form of create tables procedure.
     * @param msg String with information which will be printed
     */
    public void printCreateForm(String msg) {
        printHeader();
        printWriter.print(
                "\t\t<h1>" + msg + "</h1>\n"
                + "\t\t<form action=\"index.html\" method=\"POST\">\n"
                + "\t\t\t<input type=\"submit\" value=\"Back\" />\n"
                + "\t\t</form>\n"
        );
        printFooter();
    }

    /**
     * Method which is responsible for printing header.
     */
    public void printHeader() {
        printWriter.print("<!DOCTYPE html>\n"
                + "<html>\n"
                + "\t<head>\n"
                + "\t\t<title>PhoneBook</title>\n"
                + "\t</head>\n"
                + "\t<body>\n");
    }

    /**
     * Method which is responsible for printing error with information about.
     */
    public void printError() {
        printWriter.print("\t\t" + "There is an exception:  Database probably does not exists \n");
    }

    /**
     * Method which is responsible for printing footer.
     */
    public void printFooter() {
        printWriter.print("\t</body>\n"
                + "</html>\n");
    }
}
