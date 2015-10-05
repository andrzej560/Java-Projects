package pl.polsl.java.andrzej.kowol.serverclient.controller;

import java.io.IOException;
import pl.polsl.java.andrzej.kowol.serverclient.model.Server;
import pl.polsl.java.andrzej.kowol.serverclient.view.Client;
import pl.polsl.java.andrzej.kowol.serverclient.view.View;

/**
 * Main class of application. Create server or client.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class Controller {

    /**
     * Main method of application. Responsible for create server or client on
     * specified port.
     *
     * @param args First optional parameter is number of port. If the second
     * optional parameter equals "client" then the client will be started. In
     * other cases server will be started.
     */
    public static void main(String[] args) {

        View view = new View();
        int port;
        final int DEFAULT_PORT = 1025;
        final String CLIENT_KEYWORD = "client";

        if (args.length >= 1) {

            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                view.printException(1);
                port = DEFAULT_PORT;
            }

        } else {
            port = DEFAULT_PORT;
        }

        if (!(port >= 1025 && port <= 65535)) {
            port = DEFAULT_PORT;
        }
        view.printPortInfo(port); //information about port

        if (args.length >= 2 && args[1].equals(CLIENT_KEYWORD)) {
            view.printInfo(2); //information about client mode
            Client client = new Client(port);
            try {
                client.clientRun();
            } catch (IOException e) {
                view.printException(2); //information that is necessary to create server first
            }

        } else {
            view.printInfo(1); //information about server mode
            Server server = new Server(port);
            try {
                server.serverRun();
            } catch (IOException | NullPointerException e) {
                view.printException(1); //information that server probably exists on this port already
            }
        }
    }
}
