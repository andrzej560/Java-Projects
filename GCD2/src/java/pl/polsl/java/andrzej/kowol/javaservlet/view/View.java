package pl.polsl.java.andrzej.kowol.javaservlet.view;

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
     * Method which is responsible for printing header.
     */
    public void printHeader() {
        printWriter.print("<!DOCTYPE html>\n"
                + "<html>\n"
                + "\t<head>\n"
                + "\t\t<title>Greatest common divisor and least common multiple</title>\n"
                + "\t</head>\n"
                + "\t<body>\n");
    }
    /**
     * Method which is responsible for printing error.
     * 
     * @param i Index of message with error.
     */
    public void printError(int i) {
        switch (i) {
            case 1:
                printWriter.print("\t\t" + "You entered inappropriate values \n");
                break;
            case 2:
                printWriter.print("\t\t" + "'0' is not correct value \n");
                break;
        }
    }

     /**
     * Method which is responsible for printing form.
     */
    public void printForm() {
        printWriter.print("<h1>Enter numbers</h1>\n"
                + "\t\t<form action=\"Servlet\">\n"
                + "\t\t\t<table>\n"
                + "\t\t\t\t<tr>\n"
                + "\t\t\t\t\t<td>Enter first number:</td>\n"
                + "\t\t\t\t\t<td><input type=\"text\" name=\"n1\" /></td>  \n"
                + "\t\t\t\t</tr>\n"
                + "\t\t\t\t<tr>\n"
                + "\t\t\t\t\t<td>Enter second number:</td>\n" + "\t\t\t\t\t<td><input type=\"text\" name=\"n2\" /></td>\n"
                + "\t\t\t\t</tr>\n"
                + "\t\t\t</table>\n"
                + "\t\t\t<input type=\"submit\" value=\"Send\">\n"
                + "\t\t</form>\n");
    }

    /**
     * Method which is responsible for printing footer.
     */
    public void printFooter() {
        printWriter.print("\t</body>\n"
                + "</html>\n");
    }

    /**
     * Method which is responsible for printing result.
     *
     * @param result String which will be printed
     */
    public void printResult(String result) {
        printWriter.println("\t\t" + result + "<br/>\n");
    }
}
