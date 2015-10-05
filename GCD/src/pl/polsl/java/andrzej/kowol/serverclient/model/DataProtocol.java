package pl.polsl.java.andrzej.kowol.serverclient.model;

import static java.lang.Math.abs;

/**
 * Class responsible for validation input data and calculate result.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class DataProtocol {

    int firstValue;
    int secondValue;
    long multiple;
    int divisor;

    /**
     * Method which checks inputted line. Expects two integers different from 0
     * separated with space.
     *
     * @param receivedLine Line which client sent to server.
     * @return True if inputted data is correct.
     */
    public boolean validate(String receivedLine) {

        String firstString;
        String secondString;

        try {
            firstString = receivedLine.split(" ")[0];
            secondString = receivedLine.split(" ")[1];
        } catch (ArrayIndexOutOfBoundsException e) { //if to little elements
            return false;
        }

        try {
            firstValue = abs(Integer.parseInt(firstString));
            secondValue = abs(Integer.parseInt(secondString));
        } catch (NumberFormatException e) {
            return false;
        }
        if (firstValue == 0 || secondValue == 0) {
            return false;
        }
        return true;
    }

    /**
     * Calculate least common multiple and greatest common divisor. Results are
     * saved into private variables.
     */
    public void leastCommonMultipleAndGreatestDivisor() {

        int first = firstValue;
        int second = secondValue;
        long multi = firstValue * secondValue;

        while (first != second) {
            if (first > second) {
                first = first - second;
            } else {
                second = second - first;
            }
        }
        divisor = first;
        multiple = multi / divisor;
    }

    /**
     * Create String with information about least common multiple and greatest
     * common divisor.
     *
     * @return String with information about least common multiple and greatest
     * common divisor.
     */
    public String result() {
        return "Least common multiple: " + multiple + "  Greatest common divisor: " + divisor;
    }

}
