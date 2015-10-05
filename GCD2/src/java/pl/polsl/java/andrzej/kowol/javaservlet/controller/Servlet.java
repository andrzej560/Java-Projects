package pl.polsl.java.andrzej.kowol.javaservlet.controller;

import java.io.IOException;
import static java.lang.Math.abs;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.java.andrzej.kowol.javaservlet.model.DataCalculation;
import pl.polsl.java.andrzej.kowol.javaservlet.view.View;

/**
 * This servlet calculates least common multiple and greatest common divisor.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class Servlet extends HttpServlet {

    /**
     * Overrided method which handles HTTP GET requests.
     * 
     * @param req Servlet request
     * @param resp Servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        View view = new View(resp.getWriter());
        HttpSession session = req.getSession();

        final String cookieName = "GCDLCM"; //great common divisor least common multiple cookie
        Cookie cookie = null;
        try {
            for (Cookie c : req.getCookies()) {
                if (c.getName().equals(cookieName)) {
                    cookie = c;
                    break;
                }
            }
        } catch (NullPointerException e) { //throws exception when cookie array are empty
        }

        view.printHeader();
        view.printForm();

        String cookieInfo;
        if (cookie != null) {
            cookieInfo = "Your saved result: " + cookie.getValue() + "\n";
        } else {
            cookieInfo = "There are not saved results \n";
        }

        String stringN1 = req.getParameter("n1");
        String stringN2 = req.getParameter("n2");
        int number1;
        int number2;

        try {
            number1 = abs(Integer.parseInt(stringN1));
            number2 = abs(Integer.parseInt(stringN2));
        } catch (NumberFormatException e) {
            view.printError(1);
            view.printFooter();
            return;
        }

        if (number1 == 0 || number2 == 0) {
            view.printError(2);
            view.printFooter();
            return;
        }
        DataCalculation dataCalculation = new DataCalculation(number1, number2);
        dataCalculation.leastCommonMultipleAndGreatestDivisor(); //calculation
        String result = dataCalculation.result();

        session.setAttribute("SESSION", result);
        session.setMaxInactiveInterval(30 * 60);

        view.printResult(result);
        view.printResult(cookieInfo);

        cookie = new Cookie(cookieName, result);
        resp.addCookie(cookie);

        view.printFooter();
    }

    /**
     * Overrided method which handles HTTP POST requests.
     * 
     * @param req Servlet request
     * @param resp Servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
