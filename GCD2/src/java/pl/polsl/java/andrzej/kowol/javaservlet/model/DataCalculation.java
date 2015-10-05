package pl.polsl.java.andrzej.kowol.javaservlet.model;

/**
 * Class responsible for validation input data and calculate result.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class DataCalculation {

    int firstValue;
    int secondValue;
    long multiple;
    long divisor;

    public DataCalculation(int first, int second) {
        firstValue = first;
        secondValue = second;
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
        return "Values:<b> " + firstValue + "</b> and <b>" + secondValue + "</b>: Least common multiple: <b>" + multiple + "</b>  Greatest common divisor: <b>" + divisor + "</b>";
    }

}
