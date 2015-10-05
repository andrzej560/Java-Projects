package pl.polsl.java.andrzej.kowol.serverclient.view;

/**
 * Class responsible for printing information on screen.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class View {

    /**
     * Printing information about chosen mode.
     *
     * @param i Index of message.
     */
    public void printInfo(int i) {
        switch (i) {
            case 1:
                System.out.println("You choose Server Mode");
                break;
            case 2:
                System.out.println("You choose Client Mode");
                break;
        }
    }

    /**
     * Printing information about number of port.
     *
     * @param value Number of port.
     */
    public void printPortInfo(int value) {
        System.out.println("Your port have a number: " + value);
    }

    /**
     * Printing information about exception.
     *
     * @param i Index of message.
     */
    public void printException(int i) {
        System.out.print("There is exception: ");
        switch (i) {
            case 1:
                System.out.println("Server Exception. Server on this port probably exists already");
                break;
            case 2:
                System.out.println("Client Exception. You need to create server first");
                break;
        }
    }
}
