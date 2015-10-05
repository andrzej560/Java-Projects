package pl.polsl.java.andrzej.kowol.serverclient.model;

import java.io.*;
import java.net.*;

/**
 * Class which is responsible for create server.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class Server {

    int port;
    String clientString;
    String serverString;
    ServerSocket serverSocket;
    DataProtocol dataProtocol = new DataProtocol();

    /**
     * Parametered constructor. Set port.
     *
     * @param port Number of port.
     */
    public Server(int port) {
        this.port = port;
    }

    /**
     * Method responsible for work of server.
     *
     * @throws IOException Exception which is thrown if there is problem with
     * connection.
     * @throws NullPointerException Exception which is thrown when an
     * application attempts to use null in a case where an object is required.
     */
    public void serverRun() throws IOException, NullPointerException {

        boolean listeningSocket = true;
        serverSocket = new ServerSocket(port);

        while (listeningSocket) {
            Socket clientSocket = serverSocket.accept();
            SingleThread serverProtocol = new SingleThread(clientSocket);
            serverProtocol.start();
        }
        serverSocket.close();
    }
}
